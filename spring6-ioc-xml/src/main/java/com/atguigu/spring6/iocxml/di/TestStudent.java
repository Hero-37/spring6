package com.atguigu.spring6.iocxml.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Student student = context.getBean("student", Student.class);
        student.run();
    }
}
