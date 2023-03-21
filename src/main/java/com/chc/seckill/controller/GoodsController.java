package com.chc.seckill.controller;

import com.chc.seckill.modal.entity.TUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @RequestMapping("/toList")
    public String toList(Model model, TUser user){
        model.addAttribute("currentUser",user);
        return "goodsList";
    }
}
