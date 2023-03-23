package com.chc.seckill.controller;

import cn.hutool.json.JSONUtil;
import com.chc.seckill.modal.entity.Goods;
import com.chc.seckill.modal.entity.User;
import com.chc.seckill.modal.vo.ResponseBean;
import com.chc.seckill.modal.vo.SeckillGoodsVo;
import com.chc.seckill.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


/***
 *@title GoodsController
 *@description 商品接口
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 16:49
 **/
@Controller
@RequestMapping("/goods")
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/toList")
    public String toList(Model model, User user) {
        model.addAttribute("currentUser", user);
        model.addAttribute("goods", goodsService.findGoodsVo());
        return "goodsList";
    }

    @RequestMapping("/detail/{goodsId}")
    public String getGoodsById(@PathVariable String goodsId, Model model, User user) {
        //打印查询结果
        log.info(JSONUtil.toJsonPrettyStr(goodsService.findGoodsVoByGoodsId(goodsId)));
        SeckillGoodsVo seckillGoodsVo = goodsService.findGoodsVoByGoodsId(goodsId);

        Date startDate = seckillGoodsVo.getStartDate();
        Date endDate = seckillGoodsVo.getEndDate();
        Date now = new Date();
        //秒杀状态
        int seckillStatus = 0;
        //秒杀倒计时
        int remainSeconds = 0;
        //当前时间小于开始时间 -> 秒杀未开始
        if (now.before(startDate)) {
            remainSeconds = ((int)((startDate.getTime() - now.getTime()) / 1000));
        } else if (now.after(endDate)) {
            // 当前时间大于结束时间 -> 秒杀已结束
            seckillStatus = 2;
            remainSeconds = -1;
        } else {
            //秒杀进行中
            seckillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("remainSeconds", remainSeconds);
        model.addAttribute("goods", seckillGoodsVo);
        model.addAttribute("user", user);
        model.addAttribute("seckillStatus", seckillStatus);
        return "goodsDetail";
    }
}
