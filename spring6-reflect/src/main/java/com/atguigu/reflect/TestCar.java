package com.atguigu.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestCar {

    // 1. 获取 class 对象多种方式
    @Test
    public void testGetClass() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 类名.class
        Class clazz1 = Car.class;

        // 对象.getClass
        Class clazz2 = new Car().getClass();

        // Class.forName("全路径")
        Class clazz3 = Class.forName("com.atguigu.reflect.Car");

        // 实例化
        Car car = (Car)clazz3.getDeclaredConstructor().newInstance();

        System.out.println(car);
    }

    // 2. 获取构造方法
    @Test
    public void testGetConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Car> clazz = Car.class;

        // 获取所有构造（获取所有 public 的构造器）
        Constructor<?>[] constructors = clazz.getConstructors();

        // 获取所有构造器(public、private 都可以获得)
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println(c.getName() + c.getParameterCount());
        }

        // 指定有参构造创建对象
        // 1. 构造器是 public

        // Constructor<Car> constructor = clazz.getConstructor(String.class, int.class, String.class);
        // Car car = constructor.newInstance("小米", 1, "灰");
        // System.out.println(car);

        // 2. 构造器是 private
        Constructor<Car> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        declaredConstructor.setAccessible(true);
        Car car1 = declaredConstructor.newInstance("xiaomi", 1, "灰");
        System.out.println(car1);
    }

    // 3. 获取属性

    // 4. 获取方法
}
