package com.newland.mybatis.controller;

import com.newland.mybatis.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理 控制器
 * @author leellun
 * @since 2023-02-19 13:37:25
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户管理", description = "用户管理")
public class UserController {
    @Autowired
    private UserService userService;
}