package com.atguigu.spring6.resource.dao;

import org.springframework.stereotype.Repository;

@Repository("myUserDao")
public class UserDaoImpl implements IUserDao {
    @Override
    public void add() {
        System.out.println("dao...add()...");
    }
}
