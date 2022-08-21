package com.newland.bootredis.service.impl;

import com.newland.bootredis.repository.RedisUtil;
import com.newland.bootredis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private RedisUtil redisUtil;
    public String login(String username, String password) {
        if("admin".equals(username)&&password.equals("admin")){
            redisUtil.set(username,username+"@"+password);
            return username+password;
        }else{
            return null;
        }
    }

    public String getUser(String username) {
        return (String) redisUtil.get(username);
    }
}
