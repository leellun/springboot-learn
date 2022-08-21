package com.newland.bootredis.service;

public interface IUserService {
    String login(String username, String password);

    String getUser(String username);
}