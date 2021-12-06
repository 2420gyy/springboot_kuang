package com.chen.Test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.Test.entity.S_treenode;

import java.util.List;

/**
 * <p>
 * 节点定义表 服务类
 * </p>
 *
 * @author ChenChen
 * @since 2021-11-21
 */
public interface IS_treenodeService extends IService<S_treenode> {

    List<S_treenode> getAllTree();

}
