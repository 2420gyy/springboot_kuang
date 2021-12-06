package com.chen.mybatispluswrapper.service;

import com.chen.mybatispluswrapper.entity.Stu;

/**
 * @author chenchen
 * @date 2021-11-11 0:37
 */
public interface StuService {

    Stu findStudentBySid(int sid);
}
