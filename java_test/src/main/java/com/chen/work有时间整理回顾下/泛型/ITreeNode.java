package com.chen.work有时间整理回顾下.泛型;

import java.util.List;

/**
 * 树节点
 *
 * @author wuyipeng
 * @since 17:04 2022-3-14
 */
public interface ITreeNode<ID, CHD> {

    ID getId();

    ID getParentId();

    void setChildren(List<CHD> children);

    List<CHD> getChildren();

}
