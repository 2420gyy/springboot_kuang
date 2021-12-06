package com.lyx.service.impl;

import com.lyx.dao.TGoodsMapper;
import com.lyx.model.Page;
import com.lyx.model.TGoods;
import com.lyx.model.TGoodsExample;
import com.lyx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("goodsService")
public class GoodsServiceImpl  implements GoodsService {
    @Autowired
    private TGoodsMapper goodsMapper;

    @Override
    public List<TGoods> findGoodsByStateLimit(Page page) {
        return goodsMapper.findGoodsByStateLimit(page);
    }

    @Override
    public List<TGoods> findGoodsByGoodsInfoLimit(Page page) {
        return goodsMapper.findGoodsByGoodsInfoLimit(page);
    }

    @Override
    public long findGoodsCountByState(TGoods goods) {
        System.out.println("goods:"+goods);
        TGoodsExample example = new TGoodsExample();
        TGoodsExample.Criteria criteria = example.createCriteria();
        if(goods.getState() != -1){
            criteria.andStateEqualTo(goods.getState());
        }
        if(goods.getGoodsName() != null && !goods.getGoodsName().equals("null")){
            criteria.andGoodsNameLike("%"+goods.getGoodsName()+"%");
        }
        if(goods.getGoodsSource() != null && !goods.getGoodsSource().equals("null")){
            criteria.andGoodsSourceLike("%"+goods.getGoodsSource()+"%");
        }
        if(goods.getSupply() != null && !goods.getSupply().equals("null")){
            criteria.andSupplyLike("%"+goods.getSupply()+"%");
        }
        if (goods.getSupplyTel() != null && !goods.getSupplyTel().equals("null")){
            criteria.andSupplyTelLike("%"+goods.getSupplyTel()+"%");
        }
        if(goods.getNumber() != null && !goods.getNumber().equals("null")){
            criteria.andNumberEqualTo(goods.getNumber());
        }
        long lineCount = goodsMapper.countByExample(example);
        System.out.println("lineCount:"+lineCount);
        return lineCount;
    }

    @Override
    public TGoods findGoodsById(int id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateGoodsById(TGoods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public int addGoods(TGoods goods) {
        return goodsMapper.insertSelective(goods);
    }

    @Override
    public int deleteGoodsById(Integer id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TGoods> findAllGoods() {
        return goodsMapper.selectByExample(null);
    }

}
