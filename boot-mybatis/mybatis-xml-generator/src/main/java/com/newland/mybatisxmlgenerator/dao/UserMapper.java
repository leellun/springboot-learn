package com.newland.mybatisxmlgenerator.dao;

import com.newland.mybatisxmlgenerator.po.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User row);

    int insertSelective(User row);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User row);

    int updateByPrimaryKey(User row);
}