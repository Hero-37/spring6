package com.atguigu.spring6.iocxml.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Employee employee = context.getBean("employee2", Employee.class);
        employee.work();
    }
}
