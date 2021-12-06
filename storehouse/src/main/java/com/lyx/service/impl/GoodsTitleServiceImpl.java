package com.lyx.service.impl;

import com.lyx.dao.TGoodsTitleMapper;
import com.lyx.model.TGoodsTitle;
import com.lyx.service.GoodsTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("goodsTitleService")
public class GoodsTitleServiceImpl implements GoodsTitleService {

    @Autowired
    private TGoodsTitleMapper goodsTitleMapper;

    @Override
    public List<TGoodsTitle> findAllTGoodsTitle() {
        return goodsTitleMapper.selectByExample(null);
    }
}
