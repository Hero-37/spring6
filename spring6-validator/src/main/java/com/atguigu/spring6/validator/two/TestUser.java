package com.atguigu.spring6.validator.two;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    @Test
    public void testValidationOne() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);

        MyValidation1 validation1 = context.getBean(MyValidation1.class);
        User user = new User();
        user.setName("name");
        boolean b = validation1.validatorByUserOne(user);
        System.out.println(b);
    }

    @Test
    public void testValidationTwo() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);

        MyValidation2 validation2 = context.getBean(MyValidation2.class);
        User user = new User();
        user.setName("name");
        user.setAge(-1);
        boolean b = validation2.validatorByUserTwo(user);
        System.out.println(b);
    }
}
