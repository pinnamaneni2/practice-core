package com.psksoft;

import java.util.Arrays;

public class ArthmeticCal {
    public static void main(String[] args) {
        System.out.println("aByB = " + aByB(5, 3));
        System.out.println("aPersentB = " + aPersentB(5, 2));
        //System.out.println("aminusB = " + aMinusB(3, 2));
    }

    public static double aMinusB (int a, int b){
        return a-b;
    }
    public static double aByB (int a, int b){
       return a/b;
    }

    public static double aPersentB (int a, int b){
        return a%b;
    }
}
