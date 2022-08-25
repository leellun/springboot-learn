package com.newland.mongodb.repository;

import com.newland.mongodb.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 查询文档是User ID类型是String
 */
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * springdata 查询方式
     * @param name
     * @param age
     */
    User findByNameAndAge(String name, Integer age);
}
