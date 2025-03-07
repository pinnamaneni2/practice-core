package com.psksoft;

import java.util.HashSet;
import java.util.Set;

public class primeFC {

    public static void main(String[] args) {
        System.out.println(prime(18));
    }

    private static Set<Integer> prime(int i) {
        Set<Integer> integerHashSet = new HashSet<Integer>();
        int m = i;
        for (int j = 2; j <= m; j++) {
            if (i % j == 0) {
                int k = i / j;
                integerHashSet.add(j);
                i = k;
            }
        }
        return integerHashSet;

    }
}
