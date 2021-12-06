package com.chen;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author chenchen
 * @date 2021-12-03 17:55
 */
@Data
public class ExcelData {
    @ExcelProperty("ID")
    private int id;
    @ExcelProperty("用户名")
    private String name;
    @ExcelProperty("邮箱")
    private String email;
    @ExcelProperty("性别")
    private String gender;
    @ExcelProperty("积分")
    private Integer score;
    @ExcelProperty("IP")
    private String ip;
    @ExcelProperty("加入时间")
    private String date;
}
