package com.chc.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chc.seckill.mapper.SeckillOrderMapper;
import com.chc.seckill.modal.entity.SeckillOrder;
import com.chc.seckill.service.SeckillOrderService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_seckill_order(秒杀订单表)】的数据库操作Service实现
* @createDate 2023-03-22 16:02:29
*/
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder>
    implements SeckillOrderService {

}




