package com.atguigu.spring6.resource.service;

import com.atguigu.spring6.resource.dao.IUserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("myUserServiceImpl")
public class UserServiceImpl implements IUserService {

    // 不指定名称，按照属性名匹配
    @Resource
    private IUserDao myUserDao;

    @Override
    public void add() {
        System.out.println("service...add()...");
        myUserDao.add();
    }
}
