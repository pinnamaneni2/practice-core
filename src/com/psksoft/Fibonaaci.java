package com.psksoft;

import java.util.*;


public class Fibonaaci {

    private static final int MAX_NUM = 100;

    public static void main(String[] args) {


//        calFibonaaciloop(100).stream().forEach(i-> {
//        System.out.println("-");
//            System.out.print(i);
//        });
        fb(5).forEach(i -> {
            System.out.print("-");
            System.out.print(i);
        });
    }

    private static List<Integer> calFibonaaciloop(int i) {
        if (i == 0) return List.of(0);
        if (i == 1) return List.of(0, 1);
        if (i <= MAX_NUM) {
            ArrayList<Integer> fs = new ArrayList<>();
            fs.add(0);
            fs.add(1);
            fs.add(2);
            int f = 0;
            for (int k = 2; k < i; k++) {
                f = fs.get(k - 1) + fs.get(k);
                if (f >= i)
                    break;
                fs.add(f);
            }

            Collections.sort(fs);
            return fs;
        }
        return Collections.emptyList();
    }

    private static List<Integer> fb(int i) {
        if (i == 0) return List.of(0);
        if (i == 1) return List.of(0, 1);
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        for (int k = 3; k < i; k++) {
            integers.add(integers.get(k - 1) + integers.get(k - 2));
        }
        return integers;
    }
}
