package com.chc.seckill.utils;

import java.util.UUID;

/***
 *@title UUIDUtil
 *@description uuid工具类
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 16:45
 **/
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
