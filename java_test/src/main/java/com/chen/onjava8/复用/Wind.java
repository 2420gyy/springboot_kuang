package com.chen.onjava8.复用;

public class Wind extends Instrument {
        public static void main(String[] args) {
            Wind flute = new Wind();
            Instrument.tune(flute); // Upcasting 向上转型
            // 从一个更具体的类转化为一个更一般的类，所以向上转型永远是安全的

        }
    }