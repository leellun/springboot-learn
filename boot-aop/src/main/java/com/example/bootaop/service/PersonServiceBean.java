package com.example.bootaop.service;

import org.springframework.stereotype.Service;

/**
 * Author: leell
 * Date: 2022/9/2 09:00:48
 */
@Service
public class PersonServiceBean implements PersonService {
    public PersonServiceBean() {
    }

    public String save(String name) {
        if ("3".equals(name)) {
            throw new RuntimeException();
        }
        System.out.println("我是save()方法");
        commit();
        return name;
    }

    public void commit() {
        System.out.println(this);
    }
}
