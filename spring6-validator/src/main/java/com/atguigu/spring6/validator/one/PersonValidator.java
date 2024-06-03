package com.atguigu.spring6.validator.one;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    // 校验规则
    @Override
    public void validate(Object target, Errors errors) {
        // name 不能为空
        ValidationUtils.rejectIfEmpty(
                errors,
                "name",
                "name.empty",
                "name is NULL");
        // age > 0
        Person p = (Person) target;
        if (p.getAge() < 0) {
            errors.rejectValue("age", "age.value.error", "age < 0");
        }
    }
}
