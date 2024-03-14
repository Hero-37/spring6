package com.atguigu.spring6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestUser {

    @Test
    public void testUserObject() {
        // 加载 spring 配置文件，对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 获取创建的对象
        User user = (User) context.getBean("user");
        System.out.println(user);

        // 对象调用方法测试
        user.add();
    }

    // 反射创建对象
    @Test
    public void testUserObject1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取类 Class 对象
        Class<?> clazz = Class.forName("com.atguigu.spring6.User");

        // 调用方法创建对象
        User user = (User)clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }
}
