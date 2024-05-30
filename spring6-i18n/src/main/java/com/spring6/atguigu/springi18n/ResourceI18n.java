package com.spring6.atguigu.springi18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceI18n {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object[] objects = {"atguigu", new Date().toString()};
        String value = context.getMessage("www.atguigu.com", objects, Locale.CHINA);
        System.out.println(value);
    }
}
