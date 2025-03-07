package com.psksoft;

import java.util.ArrayList;

public class TapeEquilibrium {
    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        System.out.println(tapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}));
        System.out.println(tapeEquilibrium.solution(new int[]{3, 1}));
        System.out.println(tapeEquilibrium.solution(new int[]{-3, -1}));
        System.out.println(tapeEquilibrium.solution(new int[]{2, 2}));
    }

    public int solution1(int[] A) {
//not approved
        int n = A.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return A[0];
        }
        int p = n - (n - 1);
        int sum = 0;
        int sumFinal = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            list.add(A[j]);
        }
        boolean started = false;
        for (int j = 1; j <= n - 1; j++) {
            int sum1 = list.subList(0, j).stream().mapToInt(i -> i).sum();
            int sum2 = list.subList(j, n).stream().mapToInt(i -> i).sum();
            sum = Math.abs(sum1 - sum2);
            if (!started) {
                started = true;
                sumFinal = sum;
            }
            if (sum < sumFinal) {
                sumFinal = sum;
            }
        }
        return sumFinal;
    }

    public int solution(int[] A) {
        int numsOnRight = 0;
        int numsOnleft = 0;

        if (A.length <= 0) {
            return 0;
        }
        if (A.length == 2) {
            if (A[0] == A[1]) {
                return A[0];
            } else if (A[0] - A[1] < 0) {
                return A[0];
            } else {
                return A[1];
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i : A) {
            numsOnRight += i;
        }

        for (int i = 0; i < A.length; i++) {
            numsOnRight -= A[i];
            numsOnleft += A[i];

            if (Math.abs(numsOnleft - numsOnRight) < minSum) {
                minSum = Math.abs(numsOnleft - numsOnRight);
            }
        }
        return minSum;
    }
}
