package com.chc.seckill.modal.vo;

import com.chc.seckill.validator.IsMobile;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/***
 *@title LoginVo
 *@description 登录VO
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 14:12
 **/
@Data
@ToString
public class UserLoginVo {
    @NotNull
    @IsMobile
    private String mobile;
    @NotNull
    @Length(min = 32)
    private String password;
}
