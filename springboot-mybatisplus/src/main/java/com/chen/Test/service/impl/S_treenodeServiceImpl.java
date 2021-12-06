package com.chen.Test.service.impl;

import com.chen.Test.entity.S_treenode;
import com.chen.Test.mapper.S_treenodeMapper;
import com.chen.Test.service.IS_treenodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 节点定义表 服务实现类
 * </p>
 *
 * @author ChenChen
 * @since 2021-11-21
 */
@Service
public class S_treenodeServiceImpl extends ServiceImpl<S_treenodeMapper, S_treenode> implements IS_treenodeService {

    @Override
    public List<S_treenode> getAllTree() {
        return baseMapper.selectList(null);
    }
}
