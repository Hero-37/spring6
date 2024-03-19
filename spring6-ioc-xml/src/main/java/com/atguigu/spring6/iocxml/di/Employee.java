package com.atguigu.spring6.iocxml.di;

/**
 * 员工 类
 */
public class Employee {

    private String eName;

    private Integer age;

    private Department department;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void work() {
        System.out.println(eName + " emp work...... " + age);
        department.info();
    }
}
