package com.newland.k8s;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/k8s")
public class K8sController {
    @GetMapping("/test")
    public Map<String,String> test(){
        Map<String,String> map=new HashMap<>();
        map.put("sdfsdf","234234234");
        return map;
    }
}
