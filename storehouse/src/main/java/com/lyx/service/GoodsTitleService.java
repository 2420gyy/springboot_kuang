package com.lyx.service;

import com.lyx.model.TGoodsTitle;

import java.util.List;

public interface GoodsTitleService {

    /**
     * 查询所有商品标题
     * @return
     */
    public List<TGoodsTitle> findAllTGoodsTitle();
}
