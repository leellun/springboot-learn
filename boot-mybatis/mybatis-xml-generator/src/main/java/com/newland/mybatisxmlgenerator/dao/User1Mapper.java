package com.newland.mybatisxmlgenerator.dao;

import com.newland.mybatisxmlgenerator.po.User1;

public interface User1Mapper {
    int deleteByPrimaryKey(Long id);

    int insert(User1 row);

    int insertSelective(User1 row);

    User1 selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User1 row);

    int updateByPrimaryKey(User1 row);
}