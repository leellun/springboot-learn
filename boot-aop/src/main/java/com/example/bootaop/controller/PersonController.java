package com.example.bootaop.controller;

import com.example.bootaop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: leell
 * Date: 2022/9/4 00:40:22
 */
@RestController
@RequestMapping
public class PersonController {

    @Autowired
    PersonService personService;
    @RequestMapping("/person")
    public String getPerson() {
        personService.save("");
        return "";
    }
}
