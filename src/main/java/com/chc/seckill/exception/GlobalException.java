package com.chc.seckill.exception;

import com.chc.seckill.modal.vo.ResponseEnum;

/***
 *@title GlobalException
 *@description 全局异常
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 16:19
 **/
public class GlobalException extends RuntimeException  {
    private ResponseEnum respBeanEnum;

    public ResponseEnum getRespBeanEnum() {
        return respBeanEnum;
    }

    public void setRespBeanEnum(ResponseEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }

    public GlobalException(ResponseEnum respBeanEnum) {
        this.respBeanEnum = respBeanEnum;
    }
}
