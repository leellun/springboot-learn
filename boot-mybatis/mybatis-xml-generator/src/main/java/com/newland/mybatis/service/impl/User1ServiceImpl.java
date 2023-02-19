package com.newland.mybatis.service.impl;

import com.newland.mybatis.mapper.User1Mapper;
import com.newland.mybatis.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理 服务实现类
 * @author leellun
 * @since 2023-02-19 13:37:25
 */
@Service
public class User1ServiceImpl implements User1Service {
    @Autowired
    private User1Mapper user1Mapper;
}