package com.chen.Test.service.impl;

import com.chen.Test.entity.Student;
import com.chen.Test.mapper.StudentMapper;
import com.chen.Test.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChenChen
 * @since 2021-10-16
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
