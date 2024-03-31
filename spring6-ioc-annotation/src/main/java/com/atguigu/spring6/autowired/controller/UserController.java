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
    // @Autowired
    // public void setUserService(IUserService userService) {
    //     this.userService = userService;
    // }

    // 3. 构造方法注入
    // @Autowired
    // public UserController(IUserService userService) {
    //     this.userService = userService;
    // }

    // 4. 形参上注入
    // public UserController(@Autowired IUserService userService) {
    //     this.userService = userService;
    // }

    // 5. 只有一个构造函数，无注解(当是有参构造，可以不用注解注入，会自动注入)
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    public void add() {
        System.out.println("Controller...add()...");
        userService.add();
    }
}
