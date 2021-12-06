package com.chen.util;

import com.chen.pojo.STreeNodeVO;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author chenchen
 * @date 2021-11-20 15:51
 */
@SuppressWarnings({"ALL", "AlibabaAvoidCommentBehindStatement"})
public class STreeToolUtils {
    private List<STreeNodeVO> rootList; //根节点对象存放到这里

    private List<STreeNodeVO> bodyList; //其他节点存放到这里，可以包含根节点

    public STreeToolUtils(List<STreeNodeVO> rootList, List<STreeNodeVO> bodyList) {
        this.rootList = rootList;
        this.bodyList = bodyList;
    }

    public List<STreeNodeVO> getTree(){   //调用的方法入口
        if(bodyList != null && !bodyList.isEmpty()){
            //声明一个map，用来过滤已操作过的数据
            Map<String,String> map = Maps.newHashMapWithExpectedSize(bodyList.size());
            rootList.forEach(beanTree -> getChild(beanTree,map));
            return rootList;
        }
        return null;
    }

    public void getChild(STreeNodeVO treeDto,Map<String,String> map){
        List<STreeNodeVO> childList = Lists.newArrayList();
        bodyList.stream()
                .filter(c -> !map.containsKey(c.getNodeid())) //已经分好的数据不再进入
                .filter(c ->c.getParentid().equals(treeDto.getNodeid())) // bodyList中父id与根节点id相同的
                .forEach(c ->{
                    map.put(c.getNodeid(),c.getParentid());//1. 049/F08 2. 503/049 3. /
                    getChild(c,map);
                    childList.add(c);
                });
        treeDto.setSTreeNodeVOList(childList);
    }
}
