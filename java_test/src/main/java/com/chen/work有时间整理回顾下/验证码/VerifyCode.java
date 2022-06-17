package com.chen.work有时间整理回顾下.验证码;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class VerifyCode {
    //定义一些变量
    private int x = 80;
    private int y = 80;
    private int fontSize = 70;
    private StringBuilder sb = new StringBuilder();
    private Random random = new Random();
    private Color bgColor = new Color(82, 178, 56);
    private String codes = "鸣人";

    //获取字母
    private String getChar(){
        String ch = codes;
        return ch.charAt(0)+"";
    }
    //获取颜色
    private Color getColor(){
        int red = random.nextInt(150);
        int green = random.nextInt(150);
        int blue = random.nextInt(150);
        return new Color(red,green,blue);
    }
    //设置缓冲区
    private BufferedImage getBufferedImage(){
        BufferedImage bi = new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
        Graphics2D pen = (Graphics2D)bi.getGraphics();
        pen.setColor(this.bgColor);
        pen.fillRect(0,0,x,y);
        return bi;
    }
    //给缓冲区添加字符串,添加干扰线
    private BufferedImage addCharAndLine(){
        BufferedImage bi = getBufferedImage();
        Graphics2D pen = (Graphics2D)bi.getGraphics();
        int style = random.nextInt(4);
        pen.setColor(getColor());
//        pen.setBackground(Color.CYAN);
        pen.setFont(new Font("楷体_GB2312",style,fontSize));
        String s = getChar();
        sb.append(s);
        pen.drawString(s, 5, 65);
        return bi;
    }
    //获取验证码的值
    public String getText(){
        return sb.toString();
    }
    //获取一张验证码图片
    public BufferedImage getImage(){
        return addCharAndLine();
    }
    //输出图片
    public void outputImage(BufferedImage bi,String imageName){
        String path = "C:\\study\\MybatisEvolution\\src\\main\\java\\com\\验证码\\"+imageName+".jpg";
        try {
            ImageIO.write(bi, "JPEG", new FileOutputStream(path));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

