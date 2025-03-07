package com.psksoft;

import java.util.HashSet;

public class PermMissingEle {
    public static void main(String[] args) {
        PermMissingEle permMissingEle = new PermMissingEle();
        System.out.println(permMissingEle.solution(new int[]{2, 3, 1,5}));
        System.out.println(permMissingEle.solution(new int[]{}));
        System.out.println(permMissingEle.solution(new int[]{1}));
        System.out.println(permMissingEle.solution(new int[]{1, -2, 4}));
        System.out.println(permMissingEle.solution(new int[]{1, 1}));
        System.out.println(permMissingEle.solution(new int[]{1, 2, 2}));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) {
            return 1;
        }
        HashSet<Integer> list = new HashSet<>();
        HashSet<Integer> actualList = new HashSet<>();

        for (int i = 1; i < A.length + 1; i++) {
            list.add(i);
            actualList.add(A[i - 1]);
        }

        for (Integer i : actualList) {
            list.remove(i);
        }
        if (list.size() > 0) {
            return list.iterator().next();
        }

        if (A[A.length - 1] > 0) {
            return A[A.length - 1] + 1;
        } else {
            return 1;
        }
    }
}
