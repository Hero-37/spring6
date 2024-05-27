package com.atguigu.spring6.resource_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        ResourceBean bean = context.getBean(ResourceBean.class);
        bean.parse();
    }
}
