package com.chen.work有时间整理回顾下.chen;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListToString {

    @Test
    public void test1(){
        // creating a list with strings.
        List<String> list = Arrays.asList("One",
                "Two",
                "Three",
                "Four",
                "Five");

        // converting List<String> to String using toString() method
        String stringFromList = list.toString();

        // priting the string
        System.out.println("String : "+stringFromList);
        // [One, Two, Three, Four, Five]
    }

    @Test
    public void test2(){
        // creating a list with strings.
        List<String> list = Arrays.asList("One",
                "Two",
                "Three",
                "Four",
                "Five");

        // converting List<String> to String using toString() method
        String stringFromList = String.join("~", list);

        // priting the string
        System.out.println("String with tilde delimiter: "+stringFromList);

        // delimiting with pipe | symbol.
        String stringPipe = String.join("|", list);

        // printing
        System.out.println("String with pipe delimiter : "+stringPipe);

    }

}
