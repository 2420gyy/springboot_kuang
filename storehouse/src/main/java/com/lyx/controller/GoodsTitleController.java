package com.lyx.controller;

import com.lyx.model.TGoodsTitle;
import com.lyx.service.GoodsTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("goodsTitle")
public class GoodsTitleController {

    private Map<String , Object> resMap;

    @Autowired
    private GoodsTitleService goodsTitleService;

    @RequestMapping("findAllGoodsTitle")
    @ResponseBody
    public Map<String , Object> findAllGoodsTitle(){
        resMap = new HashMap<>();
        List<TGoodsTitle> goodsTitles = goodsTitleService.findAllTGoodsTitle();
        resMap.put("goodsTitles" , goodsTitles);
        return  resMap;
    }

}
