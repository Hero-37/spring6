package com.atguigu.dao.impl;

import com.atguigu.annotation.Bean;
import com.atguigu.dao.IUserDao;

@Bean
public class UserDaoImpl implements IUserDao {
    @Override
    public void add() {
        System.out.println("Dao add......");
    }
}
