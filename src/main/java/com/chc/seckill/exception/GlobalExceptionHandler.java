package com.chc.seckill.exception;

import com.chc.seckill.modal.vo.ResponseBean;
import com.chc.seckill.modal.vo.ResponseEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***
 *@title GlobalExceptionHandler
 *@description 全局异常处理器
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 16:18
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseBean ExceptionHandler(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException exception = (GlobalException) e;
            return ResponseBean.error(exception.getRespBeanEnum());
        } else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            ResponseBean respBean = ResponseBean.error(ResponseEnum.BIND_ERROR);
            respBean.setMessage("参数校验异常：" + bindException.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        System.out.println("异常信息" + e);
        return ResponseBean.error(ResponseEnum.ERROR);
    }
}
