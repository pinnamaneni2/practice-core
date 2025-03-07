package com.psksoft;

import java.util.Arrays;

public class GCD
{
    public static void main(String[] args) {
       // System.out.print("gcd = " + solve(10, 4));

        System.out.print("gcd = " + gcdByDivision(61, 3));
    }


    public static int solve(int N, int M) {
        return N / gcdByDivision(N, M);
    }
    public static int gcdByDivision(int A, int B) {

        if (A % B == 0) {
            System.out.println("A ="+ A+"  B="+B);
            return B;
        } else {
            System.out.println("A ="+ A+"  B="+B);
            return gcdByDivision(B, A % B);
        }
    }


}
