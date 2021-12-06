package com.lyx.service;

import com.lyx.model.Page;
import com.lyx.model.TGoods;

import java.util.List;

public interface GoodsService {

    /**
     * 根据货物状态分页查找
     * @return
     */
    public List<TGoods> findGoodsByStateLimit(Page page);

    /**
     * 根据条件分页查找
     * @return
     */
    public List<TGoods> findGoodsByGoodsInfoLimit(Page page);

    /**
     * 根据货物状态查询信息
     * @param goods
     * @return
     */
    public long findGoodsCountByState(TGoods goods);

    /**
     * 根据货物id查询货物信息
     * @param id
     * @return
     */
    public TGoods findGoodsById(int id);

    /**
     * 根据id修改货物信息
     * @param goods
     * @return
     */
    public int updateGoodsById(TGoods goods);

    /**
     * 添加货物
     * @param goods
     * @return
     */
    public int addGoods(TGoods goods);

    /**
     * 根据id删除货物
     * @param id
     * @return
     */
    public int deleteGoodsById(Integer id);

    /**
     * 得到所有货物
     * @return
     */
    public List<TGoods> findAllGoods();

}
