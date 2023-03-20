package com.chc.seckill.controller;

import com.chc.seckill.modal.vo.ResponseBean;
import com.chc.seckill.modal.vo.UserLoginVo;
import com.chc.seckill.service.TUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/***
 *@title UserController
 *@description 用户接口
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 13:34
 **/
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private TUserService tUserService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean doLogin(@Valid UserLoginVo userLoginVo, HttpServletRequest request, HttpServletResponse response){
        log.info("{}",userLoginVo);
        return tUserService.checkLoginVO(userLoginVo,request,response);
    }
}
