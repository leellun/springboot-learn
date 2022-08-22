package com.newland.sharejdbcclient.service;

import com.newland.sharejdbcclient.mapper.UserMapper;
import com.newland.sharejdbcclient.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author: leell
 * Date: 2022/8/22 14:43:00
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void save(User user){
        this.userMapper.save(user);
    }

    public User get(Long id){
        User user = this.userMapper.get(id);
        return user;
    }


}
