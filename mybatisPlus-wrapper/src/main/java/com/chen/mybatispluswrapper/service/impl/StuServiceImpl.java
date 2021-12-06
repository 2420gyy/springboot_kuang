package com.chen.mybatispluswrapper.service.impl;

import com.chen.mybatispluswrapper.entity.Stu;
import com.chen.mybatispluswrapper.mapper.StuMapper;
import com.chen.mybatispluswrapper.service.StuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chenchen
 * @date 2021-11-11 0:37
 */
@Service
public class StuServiceImpl implements StuService {

    @Resource
    private StuMapper stuMapper;

    @Override
    public Stu findStudentBySid(int sid) {
        return stuMapper.findStudentBySid(sid);
    }
}
