package com.chen.GOF;

/**
 * @author chenchen
 * @date 2022-01-09 18:07
 */
public class sss {
    public static void main(String[] args) {
        a aa = new a();
        b bb = new b();
        // geta(aa)
        getb(bb);
    }



    static class a {

    }
    static class b extends a{

    }

    static void geta(b bb){
        System.out.println(bb);
    }
    static void getb(a a2){
        System.out.println(a2);
    }
}
