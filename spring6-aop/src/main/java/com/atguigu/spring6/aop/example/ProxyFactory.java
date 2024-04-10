package com.atguigu.spring6.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    // 目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回代理对象
    public Object getProxy() {
        /**
         * Proxy.newProxyInstance() 的三个参数
         * 1. class Loader：加载动态生成代理类的类加载器
         * 2. 目录对象实现的所有接口的 class 类型数组
         * 3. InvocationHandler: 设置代理对象实现目标对象方法的过程
         */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * 参数 1 - 代理对象
             * 参数 2 - 需要重写目标对象的方法
             * 参数 3 - method 方面里面的参数
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy,
                                 Method method,
                                 Object[] args) throws Throwable {
                // 调用目标兑现方法
                System.out.println("[动态代理][日志]" + method.getName() + ", 参数: " + Arrays.toString(args));
                Object res = method.invoke(target, args);
                System.out.println("[动态代理][日志]" + method.getName() + ", 结果: " + res);

                return res;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
