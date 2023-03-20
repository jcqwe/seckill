package com.chc.seckill.controller;

import com.chc.seckill.modal.entity.TUser;
import com.chc.seckill.service.TUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 *@title GoodsController
 *@description 商品接口
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 16:49
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private TUserService userService;

    @RequestMapping("/toList")
    public String toList(Model model, @CookieValue("USER_LOGIN") String cookie, HttpServletRequest request, HttpServletResponse response){
        if(StringUtils.isEmpty(cookie)){
            return "login";
        }
        TUser currentUser = userService.getCurrentUser(cookie, request, response);
        if(currentUser == null){
            return "login";
        }
        model.addAttribute("currentUser",currentUser);
        return "goodsList";
    }
}
