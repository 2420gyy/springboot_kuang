package com.chen.work有时间整理回顾下.验证码;

import java.awt.image.BufferedImage;

public class testVerifyCode {
    public static void main(String[] args) {
        VerifyCode vc = new VerifyCode();
        BufferedImage bi = vc.getImage();
        vc.outputImage(bi, "6");
        System.out.println(vc.getText());
    }
}
