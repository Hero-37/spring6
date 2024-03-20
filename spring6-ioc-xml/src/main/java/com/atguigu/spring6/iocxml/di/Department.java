package com.atguigu.spring6.iocxml.di;

import java.util.List;

/**
 * 部门 类
 */
public class Department {

    private String dName;

    private List<Employee> empList;

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public void info() {
        System.out.println("部门名称: " + dName);
        for(Employee emp : empList) {
            System.out.println(emp.geteName());
        }
    }
}
