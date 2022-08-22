package com.newland.sharejdbcclient.controller;

import com.newland.sharejdbcclient.model.User;
import com.newland.sharejdbcclient.service.UserService;
import com.newland.sharejdbcclient.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Author: leell
 * Date: 2022/8/22 14:43:40
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public String save() {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(1, 3);
        for (int i = 1; i < 50; i++) {
            User user = new User();
            long id = idWorker.nextId();
            long a= Math.random() > 0.5 ? 1l : 2l;
            user.setId ( id+a);  //此处只为方便显示不同库中不同表，不保证id不重复；仅仅为了更好的测试出效果
            user.setName("test" + i);
            // 1 男 2 女
            user.setSex(Math.random() > 0.5 ? 1 : 2);
            user.setCreateTime(new Date());
            userService.save(user);
        }
        return "success";
    }

    @RequestMapping("/get")
    public User get(Long id) {
        User user = this.userService.get(id);
        return user;
    }

}
