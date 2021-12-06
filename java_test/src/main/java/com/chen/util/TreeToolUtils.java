package com.chen.util;

import com.chen.pojo.TreeDto;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author chenchen
 * @date 2021-11-20 15:51
 */
@SuppressWarnings({"ALL", "AlibabaAvoidCommentBehindStatement"})
public class TreeToolUtils {
    private List<TreeDto> rootList; //根节点对象存放到这里

    private List<TreeDto> bodyList; //其他节点存放到这里，可以包含根节点

    public TreeToolUtils(List<TreeDto> rootList, List<TreeDto> bodyList) {
        this.rootList = rootList;
        this.bodyList = bodyList;
    }

    public List<TreeDto> getTree(){   //调用的方法入口
        if(bodyList != null && !bodyList.isEmpty()){
            //声明一个map，用来过滤已操作过的数据
            Map<String,String> map = Maps.newHashMapWithExpectedSize(bodyList.size());
            rootList.forEach(beanTree -> getChild(beanTree,map));
            return rootList;
        }
        return null;
    }

    public void getChild(TreeDto treeDto,Map<String,String> map){
        List<TreeDto> childList = Lists.newArrayList();
        bodyList.stream()
                .filter(c -> !map.containsKey(c.getId())) //
                .filter(c ->c.getPid().equals(treeDto.getId())) // bodyList中父id与根节点id相同的
                .forEach(c ->{
                    map.put(c.getId(),c.getPid());
                    getChild(c,map);
                    childList.add(c);
                });
        treeDto.setChildTreeDto(childList);

    }
}
