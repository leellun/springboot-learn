package com.newland.bootredis.service.impl;

import com.newland.bootredis.model.User;
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
            redisUtil.set(username,new User(username,password));
            redisUtil.setHash("person","username","leellun");
            redisUtil.setListLeft("list1","item1");
            redisUtil.setListLeft("list1","item2");
            return username+password;
        }else{
            return null;
        }
    }

    public String getUser(String username) {
        return (String) redisUtil.get(username);
    }
}
