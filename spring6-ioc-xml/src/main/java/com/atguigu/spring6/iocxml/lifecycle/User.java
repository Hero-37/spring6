package com.atguigu.spring6.iocxml.lifecycle;

public class User {
    private String name;

    public User() {
        System.out.println("1. 调用无参构造创建对象");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2. bean 对象设置属性值");
    }

    // 初始话方法
    public void initMethod() {
        System.out.println("4. bean对象初始化");
    }

    public void destroyMethod() {
        System.out.println("7. bean对象销毁");
    }
}
