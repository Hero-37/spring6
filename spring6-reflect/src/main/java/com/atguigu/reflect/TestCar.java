package com.atguigu.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    @Test
    public void testGetAttribute() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Car> clazz = Car.class;

        Car car = clazz.getDeclaredConstructor().newInstance();

        // 获取所有 public 属性
        Field[] fields = clazz.getFields();

        // 获取所有属性(public、private)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {

            if ("name".equals(field.getName())) {
                field.setAccessible(true);
                field.set(car, "保时捷");
            }

            System.out.println(field.getName());
            System.out.println(car.toString());
        }


    }

    // 4. 获取方法
    @Test
    public void testGetFunction() throws InvocationTargetException, IllegalAccessException {
        Car car = new Car("奔驰", 1, "black");
        Class<? extends Car> clazz = car.getClass();
        // 1. public 方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());

            if ("toString".equals(method.getName())) {
                Object invoke = method.invoke(car);
                System.out.println(String.valueOf(invoke));
            }
        }

        // 2. private 方法
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());

            method.setAccessible(true);
            if ("run".equals(method.getName())) {
                Object invoke = method.invoke(car);
                System.out.println(String.valueOf(invoke));
            }
        }
    }
}
