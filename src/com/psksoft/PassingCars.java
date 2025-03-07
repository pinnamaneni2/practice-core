package com.psksoft;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PassingCars {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 1};
        int [] b = new int [] { 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1 };
        System.out.println("13---" + getPassingCars(b));
        System.out.println("5---" + getPassingCars(a));
        //System.out.println("5---" + solution(a));
        //(0, 1), (0, 3), (0, 4), (2, 3), (2, 4)
        //( 0,1) ,( 0,2) ,( 0,3) ,( 0,4) ,( 1,2) ,( 1,3) ,( 1,4) ,( 2,3) ,( 2,4) ,( 3,4)
        ////( 0,1) ,( 0,2) ,( 0,3) ,( 0,4) ,( 1,2) ,( 1,3) ,( 1,4) ,( 2,3) ,( 2,4) ,( 3,4)
    }

    public static int getPassingCars(int[] a) {
        //0 ≤ P < Q < N
        HashMap<Integer, Coordinates> coMap = new HashMap<>();
        AtomicInteger count = new AtomicInteger(0);
        for (int q = 0; q < a.length; q++) {
            for (int p = 0; p < q; p++) {
                    if(a[p] ==a[q] || a[p]>a[q]){
                        continue;
                    }
                    coMap.put(count.get(), new Coordinates(p, q));
                    count.getAndIncrement();
                }
        }
        if (coMap.size() > 1000000000) {
            return -1;
        }
        return coMap.size();
    }

    public static int solution(int[] A) {
        int zeros = 0;
        int carPasses = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeros++;
            } else if (A[i] == 1) {
                carPasses++;
                //for every 1 - there will be an extra car pass for ALL the 0's
                // that came before it carPasses += zeros;
                if (carPasses > 1000000000) {
                    return -1;
                }
            } else throw new RuntimeException("shouldn't reach here");
        }
        return carPasses;
    }
}
