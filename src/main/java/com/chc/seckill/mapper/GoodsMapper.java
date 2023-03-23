package com.chc.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chc.seckill.modal.entity.Goods;
import com.chc.seckill.modal.vo.SeckillGoodsVo;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_goods(商品表)】的数据库操作Mapper
* @createDate 2023-03-22 16:02:29
* @Entity com.chc.seckill.modal.entity.Goods
*/
public interface GoodsMapper extends BaseMapper<Goods> {

    List<SeckillGoodsVo> findGoodsVo();
    SeckillGoodsVo findGoodsVoByGoodsId(String goodsId);
}




