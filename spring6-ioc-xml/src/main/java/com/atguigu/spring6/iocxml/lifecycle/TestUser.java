package com.atguigu.spring6.iocxml.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-lifeCycle.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6. bean 对象创建完成");
        System.out.println(user);
        context.close();
    }
}
