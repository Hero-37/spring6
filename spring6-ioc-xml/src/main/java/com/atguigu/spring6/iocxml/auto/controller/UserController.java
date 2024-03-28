package com.atguigu.spring6.iocxml.auto.controller;

import com.atguigu.spring6.iocxml.auto.service.IUserService;

public class UserController {

    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        System.out.println("controller 方法执行了......");
        // 调用 userService 中的方法
        userService.addUserService();
    }
}
