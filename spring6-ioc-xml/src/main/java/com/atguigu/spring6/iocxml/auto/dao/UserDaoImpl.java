package com.atguigu.spring6.iocxml.auto.dao;

public class UserDaoImpl implements IUserDao{
    @Override
    public void addUser() {
        System.out.println("UserDao 方法执行了......");
    }
}
