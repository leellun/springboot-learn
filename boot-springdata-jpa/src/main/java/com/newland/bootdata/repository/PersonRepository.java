package com.newland.bootdata.repository;

import com.newland.bootdata.pojo.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * 1. Repository 是一个空接口. 即是一个标记接口
 * 2. 若我们定义的接口继承了 Repository, 则该接口会被 IOC 容器识别为一个 Repository Bean.
 * 纳入到 IOC 容器中. 进而可以在该接口中定义满足一定规范的方法.
 *
 * 3. 实际上, 也可以通过 @RepositoryDefinition 注解来替代继承 Repository 接口
 */
/**
 * 在 Repository 子接口中声明方法 1. 不是随便声明的. 而需要符合一定的规范 2. 查询方法以 find | read | get 开头 3.
 * 涉及条件查询时，条件的属性用条件关键字连接 4. 要注意的是：条件属性以首字母大写。 5. 支持属性的级联查询. 若当前类有符合条件的属性, 则优先使用,
 * 而不使用级联属性. 若需要使用级联属性, 则属性之间使用 _ 进行连接.
 * JpaSpecificationExecutor<Person>
 */
// @RepositoryDefinition(domainClass=Person.class,idClass=Integer.class)
public interface PersonRepository
        extends JpaRepository<Person, Integer>, PersonDao {
    // 根据 lastName 来获取对应的 Person
    Person getByLastName(String lastName);

    // WHERE lastName LIKE ?% AND id < ?
    List<Person> getByLastNameStartingWithAndIdLessThan(String lastName, Integer id);

    // WHERE lastName LIKE %? AND id < ?
    List<Person> getByLastNameEndingWithAndIdLessThan(String lastName, Integer id);

    // WHERE email IN (?, ?, ?) OR birth < ?
    List<Person> getByEmailInAndBirthLessThan(List<String> emails, Date birth);

    // WHERE a.id > ?
    List<Person> getByAddress_IdGreaterThan(Integer id);

    // 查询 id 值最大的那个 Person
    // 使用 @Query 注解可以自定义 JPQL 语句以实现更灵活的查询
    @Query("SELECT p FROM Person p WHERE p.id = (SELECT max(p2.id) FROM Person p2)")
    Person getMaxIdPerson();

    // 为 @Query 注解传递参数的方式1: 使用占位符.
    @Query("SELECT p FROM Person p WHERE p.lastName = ?1 AND p.email = ?2")
    List<Person> testQueryAnnotationParams1(String lastName, String email);

    // 为 @Query 注解传递参数的方式1: 命名参数的方式.
    @Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
    List<Person> testQueryAnnotationParams2(@Param("email") String email, @Param("lastName") String lastName);

    // SpringData 允许在占位符上添加 %%.
    @Query("SELECT p FROM Person p WHERE p.lastName LIKE %?1% OR p.email LIKE %?2%")
    List<Person> testQueryAnnotationLikeParam(String lastName, String email);

    // SpringData 允许在占位符上添加 %%.
    @Query("SELECT p FROM Person p WHERE p.lastName LIKE %:lastName% OR p.email LIKE %:email%")
    List<Person> testQueryAnnotationLikeParam2(@Param("email") String email, @Param("lastName") String lastName);

    // 设置 nativeQuery=true 即可以使用原生的 SQL 查询
    @Query(value = "SELECT count(id) FROM jpa_persons", nativeQuery = true)
    long getTotalCount();

    // 可以通过自定义的 JPQL 完成 UPDATE 和 DELETE 操作. 注意: JPQL 不支持使用 INSERT
    // 在 @Query 注解中编写 JPQL 语句, 但必须使用 @Modifying 进行修饰. 以通知 SpringData, 这是一个
    // UPDATE 或 DELETE 操作
    // UPDATE 或 DELETE 操作需要使用事务, 此时需要定义 Service 层. 在 Service 层的方法上添加事务操作.
    // 默认情况下, SpringData 的每个方法上有事务, 但都是一个只读事务. 他们不能完成修改操作!
    @Modifying
    @Query("UPDATE Person p SET p.email = :email WHERE p.id = :id")
    void updatePersonEmail(@Param("id") Integer id, @Param("email") String email);
}
 