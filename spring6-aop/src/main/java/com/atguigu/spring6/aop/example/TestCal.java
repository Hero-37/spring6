package com.atguigu.spring6.aop.example;

public class TestCal {
    public static void main(String[] args) {
        // 创建代理对象(动态)
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorLogImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1, 2);
    }
}
