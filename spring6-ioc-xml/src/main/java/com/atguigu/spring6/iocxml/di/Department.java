package com.atguigu.spring6.iocxml.di;

/**
 * 部门 类
 */
public class Department {

    private String dName;

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public void info() {
        System.out.println("部门名称: " + dName);
    }



}
