package com.newland.mybatis.mapper;

import com.mybatis.generator.mapper.BaseMapper;
import com.newland.mybatis.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户管理 Mapper 接口
 * @author leellun
 * @since 2023-02-19 13:37:25
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}