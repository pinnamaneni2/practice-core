package com.psksoft;

import java.util.HashSet;

public class FrogRiverOne {
    public static void main(String[] args) {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        System.out.println(frogRiverOne. solution(new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 4));
    }

    public int solution(int[] a, int k) {
        HashSet<Integer> values = new HashSet<>();
        for (int j = 1; j <= k; j++) {
            values.add(j);
        }

        for (int i = 0; i < a.length; i++) {
            if (values.remove(a[i])) {
               if(values.isEmpty()) {
                   return i;
               }
            }
        }
        return -1;
    }
}
