package com.atguigu;

import com.atguigu.bean.AnnotationApplicationContext;
import com.atguigu.bean.ApplicationContext;
import com.atguigu.service.IUserService;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.atguigu");
        IUserService userService = (IUserService) context.getBean(IUserService.class);
        System.out.println(userService);
        userService.add();
    }
}
