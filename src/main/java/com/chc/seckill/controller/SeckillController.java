package com.chc.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chc.seckill.modal.entity.Order;
import com.chc.seckill.modal.entity.SeckillOrder;
import com.chc.seckill.modal.entity.User;
import com.chc.seckill.modal.vo.ResponseEnum;
import com.chc.seckill.modal.vo.SeckillGoodsVo;
import com.chc.seckill.service.GoodsService;
import com.chc.seckill.service.OrderService;
import com.chc.seckill.service.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 *@title SeckillController
 *@description 秒杀接口
 *@author chc
 *@version 1.0.0
 *@create 2023/3/25 13:51
 **/
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private SeckillOrderService seckillOrderService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, User user, String goodsId){
        if(null == user){
            return "login";
        }
        SeckillGoodsVo seckillGoodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断库存
        if(seckillGoodsVo.getGoodsStock() < 1){
            model.addAttribute("errorMessage", ResponseEnum.EMPTY_STOCK.getMessage());
            return "seckillFail";
        }
        //判断用户是否重复抢购
        QueryWrapper<SeckillOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getId());
        queryWrapper.eq("goods_id",goodsId);
        SeckillOrder seckillOrder = seckillOrderService.getOne(queryWrapper);
        if(seckillOrder != null){
            model.addAttribute("errorMessage",ResponseEnum.JUST_ONE.getMessage());
            return "seckillFail";
        }
        //进行秒杀
        Order order = orderService.seckill(user,seckillGoodsVo);
        model.addAttribute("order",order);
        model.addAttribute("goods",seckillGoodsVo);
        return "orderDetail";
    }
}
