package com.lyx.exception;

/**
 * 自定义异常类
 */
public class SystemException extends Exception {

    //存储提示信息
    private String Massage;

    public String getMassage() {
        return Massage;
    }

    public void setMassage(String massage) {
        Massage = massage;
    }

    public SystemException(String massage) {
        Massage = massage;
    }

}
