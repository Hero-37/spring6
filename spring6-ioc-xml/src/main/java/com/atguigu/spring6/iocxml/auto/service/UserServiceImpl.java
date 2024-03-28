package com.atguigu.spring6.iocxml.auto.service;

import com.atguigu.spring6.iocxml.auto.dao.IUserDao;

public class UserServiceImpl implements IUserService{

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("UserService 方法执行了......");
        // 执行 userDao 中的方法
        userDao.addUser();
    }
}
