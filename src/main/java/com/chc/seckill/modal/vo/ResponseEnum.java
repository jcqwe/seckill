package com.chc.seckill.modal.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/***
 *@title ResponseEnum
 *@description 返回枚举
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 13:54
 **/
@Getter
@ToString
@AllArgsConstructor
public enum ResponseEnum {
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务端异常"),
    LOGIN_ERROR(500210, "用户名或密码错误"),
    BIND_ERROR(500211, "参数校验异常"),
    EMPTY_STOCK(500500, "库存不足"),

    JUST_ONE(500600,"该商品每个用户只限购一件")
    ;



    private final Integer code;
    private final String message;
}
