package com.psksoft;

import java.util.*;

public class LeastCommonMultipule {
    public static void main(String[] args) {
        System.out.print(calLcm(12, 30));
    }

    private static Set<Integer> calLcm(int i, int u) {
        List<Integer>  divOfI = divisiableNumbers(i);
        List<Integer>  divOfU = divisiableNumbers(u);
        divOfI.retainAll(divOfU);
        return new HashSet<>(divOfI);
    }

    private static List<Integer> divisiableNumbers(int i) {
        int divisor = 2;
        List<Integer> integers = new ArrayList<>();
        do {
            if (i % divisor == 0) {
                i = (i /divisor);
                integers.add(divisor);
            }else{
                divisor = ++divisor;
            }

        } while (i >1);
        return integers;
    }
}
