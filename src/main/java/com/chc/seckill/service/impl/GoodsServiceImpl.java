package com.chc.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chc.seckill.mapper.GoodsMapper;
import com.chc.seckill.modal.entity.Goods;
import com.chc.seckill.modal.vo.SeckillGoodsVo;
import com.chc.seckill.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* @author Administrator
* @description 针对表【t_goods(商品表)】的数据库操作Service实现
* @createDate 2023-03-22 16:02:29
*/
@Service
@Slf4j
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<SeckillGoodsVo> findGoodsVo() {
        return goodsMapper.findGoodsVo();
    }

    @Override
    public SeckillGoodsVo findGoodsVoByGoodsId(String goodsId) {
        return goodsMapper.findGoodsVoByGoodsId(goodsId);
    }
}




