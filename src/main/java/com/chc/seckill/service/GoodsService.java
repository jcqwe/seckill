package com.chc.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chc.seckill.modal.entity.Goods;
import com.chc.seckill.modal.vo.SeckillGoodsVo;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_goods(商品表)】的数据库操作Service
* @createDate 2023-03-22 16:02:29
*/
public interface GoodsService extends IService<Goods> {

    List<SeckillGoodsVo> findGoodsVo();
    SeckillGoodsVo findGoodsVoByGoodsId(String goodsId);
}
