package com.atguigu.spring6.autowired.service;

import com.atguigu.spring6.autowired.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    // 根据类型找到对象，完成注入
    // 1. 属性注入
    // @Autowired
    private IUserDao userDao;

    // 2. set 方法注入
    // @Autowired
    // public void setUserDao(IUserDao userDao) {
    //     this.userDao = userDao;
    // }

    // 3. 构造方法注入
    // @Autowired
    // public UserServiceImpl(IUserDao userDao) {
    //     this.userDao = userDao;
    // }

    // 4. 形参上注入
    public UserServiceImpl(@Autowired IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("service...add()...");
        userDao.add();
    }
}
