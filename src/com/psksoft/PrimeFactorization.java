package com.psksoft;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {

    public static void main(String[] args) {
        System.out.println(primeFactorizationOfGivenNumber(18));
    }

    //12
    //6
    private static List<Integer> primeFactorizationOfGivenNumber(int i) {
        List<Integer> result = new ArrayList<Integer>();
        int m = i;
        for (int j = 2; j <= m; j++){
            if (i % j == 0) {
                int k = i / j;
                result.add(j);
                i = k;
            }}
        return result;
    }


}
