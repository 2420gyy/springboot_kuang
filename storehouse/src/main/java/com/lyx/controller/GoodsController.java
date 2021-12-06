package com.lyx.controller;

import com.alibaba.fastjson.JSONObject;
import com.lyx.model.Page;
import com.lyx.model.TGoods;
import com.lyx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("goods")
public class GoodsController {
    private Map<String , Object> resMap;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("findGoodsLimitByState")
    @ResponseBody
    public Map<String , Object> findGoodsLimitByState(@RequestBody String reqData){
        JSONObject jsonobject = JSONObject.parseObject(reqData);
        Page page = JSONObject.toJavaObject(jsonobject, Page.class);
        resMap = new HashMap<>();
        TGoods temp = new TGoods();
        temp.setState(page.getState());
        long lineCount = goodsService.findGoodsCountByState(temp);
        long pageNow = page.getPageNow() == 0 ? 1 : page.getPageNow(); //如果传过来的页码为空，则默认第一页
        Integer state = null;
        if(page.getState() != -1){
            state = page.getState();
        }
        Page pageInfo = new Page(lineCount,page.getPageSize(),pageNow,state);
        List<TGoods> goods = goodsService.findGoodsByStateLimit(pageInfo);
        resMap.put("result","success");
        resMap.put("goods",goods);
        resMap.put("pageInfo",pageInfo);
        return  resMap;
    }

    @RequestMapping("findGoodsByGoodsInfoLimit")
    @ResponseBody
    public Map<String , Object> findGoodsByGoodsInfoLimit(@RequestBody String reqData) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("findGoodsByGoodsInfoLimit");
        JSONObject jsonobject = JSONObject.parseObject(reqData);
        TGoods g = new TGoods();
        String title = jsonobject.getString("title");
        System.out.println("title:"+title);
        String titleInfo = jsonobject.getString("titleInfo");
        //通过反射赋值
        Field f = g.getClass().getDeclaredField(title);
        f.setAccessible(true);
        if (title.equals("number")){
            f.set(g, Integer.parseInt(titleInfo));
        }else{
            f.set(g, titleInfo);
        }
        System.out.println("goods:"+g);
        jsonobject.remove("title");
        jsonobject.remove("titleInfo");
        Page page = JSONObject.toJavaObject(jsonobject, Page.class);
        System.out.println(page);
        resMap = new HashMap<>();
        g.setState(page.getState());
        long lineCount = goodsService.findGoodsCountByState(g);
        long pageNow = page.getPageNow() == 0 ? 1 : page.getPageNow(); //如果传过来的页码为空，则默认第一页
        Integer state = null;
        if(page.getState() != -1){
            state = page.getState();
        }
        Page pageInfo = new Page(lineCount,page.getPageSize(),pageNow,state);
        pageInfo.setGoods(g);
        System.out.println(pageInfo);
        List<TGoods> goods = goodsService.findGoodsByGoodsInfoLimit(pageInfo);
        resMap.put("result","success");
        resMap.put("goods",goods);
        resMap.put("pageInfo",pageInfo);
        return  resMap;
    }

    @RequestMapping("updateGoodsById")
    @ResponseBody
    public Map<String , Object> updateGoodsById(@RequestBody String reqData){
        resMap = new HashMap<>();
        JSONObject jsonobject = JSONObject.parseObject(reqData);
        String warehousing = jsonobject.getString("warehousing");
        jsonobject.remove("warehousing");
        TGoods goods = JSONObject.toJavaObject(jsonobject, TGoods.class);
        if(warehousing.equals("出库")){
            TGoods oldGoods = goodsService.findGoodsById(goods.getId());
            int number = oldGoods.getNumber() - goods.getNumber();
            goods.setNumber(number);
        }else if(warehousing.equals("入库")){
            TGoods oldGoods = goodsService.findGoodsById(goods.getId());
            int number = oldGoods.getNumber() + goods.getNumber();
            goods.setNumber(number);
        }
        int i = goodsService.updateGoodsById(goods);
        if(i > 0){
            resMap.put("result" , "success");
        }else{
            resMap.put("result" , "fail");
        }
        return resMap;
    }

    @RequestMapping("AdminUpdateGoodsById")
    @ResponseBody
    public Map<String , Object> AdminUpdateGoodsById(@RequestBody TGoods goods){
        resMap = new HashMap<>();
        int i = goodsService.updateGoodsById(goods);
        if(i > 0){
            resMap.put("result","success");
        }else{
            resMap.put("result","fail");
        }
        return resMap;
    }


    @RequestMapping("addGoods")
    @ResponseBody
    public Map<String , Object> addGoods(@RequestBody TGoods goods){
        resMap = new HashMap<>();
        int i = goodsService.addGoods(goods);
        if(i > 0){
            resMap.put("result","success");
        }else{
            resMap.put("result","fail");
        }
        return resMap;
    }

    @RequestMapping("deleteGoodsById")
    @ResponseBody
    public Map<String , Object> deleteGoodsById(@RequestBody TGoods goods){
        resMap = new HashMap<>();
        int i = goodsService.deleteGoodsById(goods.getId());
        if(i > 0){
            resMap.put("result","success");
        }else{
            resMap.put("result","fail");
        }
        return resMap;
    }

    @RequestMapping("findAllGoods")
    @ResponseBody
    public Map<String , Object> findAllGoods(){
        resMap = new HashMap<>();
        List<TGoods> goods = goodsService.findAllGoods();
        resMap.put("result","success");
        resMap.put("goods",goods);
        return resMap;
    }
}
