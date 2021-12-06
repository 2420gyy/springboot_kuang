package com.chen.mybatispluswrapper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.chen.mybatispluswrapper.entity.Teacher;
import com.chen.mybatispluswrapper.mapper.TeacherMapper;
import com.chen.mybatispluswrapper.service.ITeacherService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChenChen
 * @since 2021-10-12
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

}
