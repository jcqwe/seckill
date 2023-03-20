package com.chc.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 *@title DemoController
 *@description 测试接口
 *@author chc
 *@version 1.0.0
 *@create 2023/3/15 16:24
 **/
@Controller
@RequestMapping("/demo")
public class DemoController {


    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","chc");
        return "hello";
    }
}
