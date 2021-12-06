package com.lyx.service;

import com.lyx.model.TUserTitle;

import java.util.List;

public interface UserTitleService {

    /**
     * 查询所有商品标题
     * @return
     */
    public List<TUserTitle> findAllTUserTitle();
}
