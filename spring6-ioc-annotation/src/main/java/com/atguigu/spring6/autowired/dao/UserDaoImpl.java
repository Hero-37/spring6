package com.atguigu.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {
    @Override
    public void add() {
        System.out.println("dao...add()...");
    }
}
