package com.chc.seckill.modal.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *@title RequestBean
 *@description <TODO description class purpose>
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 13:54
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {

    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回(没有返回数据)
     * @return
     */
    public static ResponseBean success(){
        return new ResponseBean(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMessage(),null);
    }

    /**
     * 成功返回(有返回数据)
     * @param obj
     * @return
     */
    public static ResponseBean success(Object obj){
        return new ResponseBean(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMessage(),obj);
    }

    /**
     * 错误返回
     * @param responseEnum
     * @return
     */
    public static ResponseBean error(ResponseEnum responseEnum){
        return new ResponseBean(responseEnum.getCode(),responseEnum.getMessage(),null);
    }

    /**
     * 错误返回
     * @param responseEnum
     * @param obj
     * @return
     */
    public static ResponseBean error(ResponseEnum responseEnum,Object obj){
        return new ResponseBean(responseEnum.getCode(),responseEnum.getMessage(),obj);
    }
}
