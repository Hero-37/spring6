package com.atguigu.service.impl;

import com.atguigu.annotation.Bean;
import com.atguigu.annotation.Di;
import com.atguigu.dao.IUserDao;
import com.atguigu.service.IUserService;

@Bean
public class UserServiceImpl implements IUserService {

    @Di
    private IUserDao userDao;

    @Override
    public void add() {
        System.out.println("Service add......");
        userDao.add();
    }
}
