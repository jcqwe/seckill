package com.chc.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chc.seckill.modal.entity.Order;
import com.chc.seckill.modal.entity.User;
import com.chc.seckill.modal.vo.SeckillGoodsVo;
import com.sun.org.apache.xpath.internal.operations.Or;

/**
* @author Administrator
* @description 针对表【t_order】的数据库操作Service
* @createDate 2023-03-22 16:02:29
*/
public interface OrderService extends IService<Order> {

    Order seckill(User user, SeckillGoodsVo seckillGoodsVo);
}
