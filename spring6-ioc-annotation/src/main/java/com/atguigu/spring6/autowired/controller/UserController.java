package com.atguigu.spring6.autowired.controller;

import com.atguigu.spring6.autowired.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    // 根据类型找到对象，完成注入
    // 1. 属性注入
    // @Autowired
    private IUserService userService;

    // 2. set 方法注入
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void add() {
        System.out.println("Controller...add()...");
        userService.add();
    }
}
