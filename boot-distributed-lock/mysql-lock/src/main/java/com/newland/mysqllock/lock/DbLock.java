package com.newland.mysqllock.lock;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 数据表t_method_lock(id,method_name)
 */
@Repository
public interface DbLock {
    @Insert("insert into t_method_lock(method_name) value (#{methodName})")
    void lock(@Param("methodName") String methodName);
    @Delete("delete from t_method_lock where method_name=#{methodName}")
    void unLock(@Param("methodName") String methodName);
}
