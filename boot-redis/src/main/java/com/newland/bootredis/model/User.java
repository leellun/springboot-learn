package com.newland.bootredis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: leell
 * Date: 2022/9/28 13:45:18
 */
@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
}
