package com.atguigu.spring6.aop.example;

public class CalculatorStaticProxy implements Calculator{

    // 被代理的目标对象传递进来
    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {

        System.out.println("[日志] add 方法开始了，参数是：" + i + " , " + j);
        // 调用目标对象的方法实现核心业务
        int addRes = calculator.add(1, 3);
        System.out.println();
        System.out.println("[日志] add 方法结束了，结果是：" + addRes);
        return addRes;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
