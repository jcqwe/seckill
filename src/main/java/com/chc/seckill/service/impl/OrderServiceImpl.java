package com.chc.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chc.seckill.mapper.OrderMapper;
import com.chc.seckill.modal.entity.Order;
import com.chc.seckill.service.OrderService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2023-03-22 16:02:29
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {

}




