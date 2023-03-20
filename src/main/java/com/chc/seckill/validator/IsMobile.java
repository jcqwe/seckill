package com.chc.seckill.validator;

import org.hibernate.validator.internal.constraintvalidators.hv.ISBNValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/***
 *@title IsMobile
 *@description 自定义校验注解
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 15:23
 **/
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IsMobileValidator.class}
)
public @interface  IsMobile{
    boolean required() default true;

    String message() default "手机号码格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
