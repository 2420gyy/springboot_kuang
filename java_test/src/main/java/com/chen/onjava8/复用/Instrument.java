package com.chen.onjava8.复用;

class Instrument {
    public void play() {
        System.out.println("Instrument的play方法");
    }

    static void tune(Instrument i) {
        // ...
        i.play();
    }
}
