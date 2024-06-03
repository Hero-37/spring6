package com.atguigu.spring6.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class TestPerson {
    public static void main(String[] args) {
        // 创建 Person 对象
        Person person = new Person();

        // 创建 person 对应的 databinder
        DataBinder dataBinder = new DataBinder(person);

        // 设置校验器
        dataBinder.setValidator(new PersonValidator());

        // 调用方法执行校验
        dataBinder.validate();

        // 输出校验结果
        BindingResult bindingResult = dataBinder.getBindingResult();
        System.out.println(bindingResult.getAllErrors());
    }
}
