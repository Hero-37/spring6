package com.atguigu.spring6.iocxml.di;

import java.util.Arrays;

/**
 * 员工 类
 */
public class Employee {

    private String eName;

    private Integer age;

    private Department department;

    private String[] hobbies;

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

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public void work() {
        System.out.println(eName + " emp work...... " + age);
        department.info();
        System.out.println(Arrays.toString(hobbies));
    }
}
