package com.atguigu.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestUser {

    // 创建 Logger 对象
    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject() {
        // 加载 spring 配置文件，对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 获取创建的对象
        User user = (User) context.getBean("user");
        System.out.println(user);

        // 对象调用方法测试
        user.add();

        // 手动写日志
        logger.info("日志测试");
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
