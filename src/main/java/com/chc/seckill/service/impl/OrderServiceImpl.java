package com.chc.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chc.seckill.mapper.OrderMapper;
import com.chc.seckill.modal.entity.Order;
import com.chc.seckill.modal.entity.SeckillGoods;
import com.chc.seckill.modal.entity.SeckillOrder;
import com.chc.seckill.modal.entity.User;
import com.chc.seckill.modal.vo.SeckillGoodsVo;
import com.chc.seckill.service.OrderService;
import com.chc.seckill.service.SeckillGoodsService;
import com.chc.seckill.service.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author Administrator
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2023-03-22 16:02:29
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {
    @Autowired
    private SeckillGoodsService seckillGoodsService;
    @Autowired
    private SeckillOrderService seckillOrderService;
    @Override
    public Order seckill(User user, SeckillGoodsVo seckillGoodsVo) {
        //商品库存-1
        QueryWrapper<SeckillGoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_id",seckillGoodsVo.getId());
        SeckillGoods seckillGoods = seckillGoodsService.getOne(queryWrapper);
        seckillGoods.setStockCount(seckillGoods.getStockCount() - 1);
        seckillGoodsService.updateById(seckillGoods);

        //生成订单
        Order order = new Order();
        order.setUserId(user.getId());
        order.setGoodsId(seckillGoods.getGoodsId());
        order.setDeliveryAddrId(0L);
        order.setGoodsName(seckillGoodsVo.getGoodsName());
        order.setGoodsCount(seckillGoods.getStockCount());
        order.setGoodsPrice(seckillGoods.getSeckillPrice());
        order.setOrderChannel(1);
        order.setStatus(0);
        order.setCreateDate(new Date());
        this.save(order);

        //生成秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setUserId(user.getId());
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setGoodsId(seckillGoods.getGoodsId());
        seckillOrderService.save(seckillOrder);
        return order;
    }
}




