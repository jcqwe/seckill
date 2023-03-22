package com.chc.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chc.seckill.mapper.GoodsMapper;
import com.chc.seckill.modal.entity.Goods;
import com.chc.seckill.service.GoodsService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_goods(商品表)】的数据库操作Service实现
* @createDate 2023-03-22 16:02:29
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService {

}




