package com.lyx.controller;

import com.lyx.model.TGoodsTitle;
import com.lyx.model.TUserTitle;
import com.lyx.service.GoodsTitleService;
import com.lyx.service.UserTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("userTitle")
public class UserTitleController {

    private Map<String , Object> resMap;

    @Autowired
    private UserTitleService userTitleService;

    @RequestMapping("findAllUserTitle")
    @ResponseBody
    public Map<String , Object> findAllUserTitle(){
        resMap = new HashMap<>();
        List<TUserTitle> userTitles = userTitleService.findAllTUserTitle();
        resMap.put("userTitles" , userTitles);
        return  resMap;
    }

}
