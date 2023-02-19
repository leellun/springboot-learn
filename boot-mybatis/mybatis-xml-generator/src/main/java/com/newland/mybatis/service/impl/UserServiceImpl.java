package com.newland.mybatis.service.impl;

import com.newland.mybatis.mapper.UserMapper;
import com.newland.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理 服务实现类
 * @author leellun
 * @since 2023-02-19 13:37:25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
}