package com.atguigu.spring6.iocxml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        /**
         * 一个接口只有一个实现类，可以根据接口类型获取 bean
         * 一个接口有多个实现类，不能根据接口类型获取 bean
         */

        //1. 根据 id 获取 bean
        UserDao userDaoImpl = (UserDao) context.getBean("userDaoImpl");
        System.out.println("根据 id 获取 bean: " + userDaoImpl);
        userDaoImpl.run();

        // 2. 根据类型获取 bean
        UserDao userDaoImpl2 = context.getBean(UserDao.class);
        System.out.println("根据类型获取 bean: " + userDaoImpl2);
        userDaoImpl2.run();

        // 3. 根据 id + 类型获取 bean
        UserDao userDaoImpl3 = context.getBean("userDaoImpl", UserDao.class);
        System.out.println("根据 id + 类型获取 bean: " + userDaoImpl3);
        userDaoImpl3.run();
    }
}
