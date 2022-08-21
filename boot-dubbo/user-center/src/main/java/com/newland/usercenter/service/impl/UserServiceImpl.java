package com.newland.usercenter.service.impl;

import com.newland.common.UserService;
import com.newland.common.bean.User;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String username) {
        if (username.equals("admin")) {
            return new User(username, "adminnick");
        }
        return null;
    }
}
