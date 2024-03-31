package com.atguigu.spring6.resource.controller;

import com.atguigu.spring6.resource.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller("myController")
public class UserController {

    @Resource(name = "myUserServiceImpl")
    private IUserService userService;


    public void add() {
        System.out.println("Controller...add()...");
        userService.add();
    }
}
