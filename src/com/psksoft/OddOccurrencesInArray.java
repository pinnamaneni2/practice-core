package com.psksoft;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
        System.out.println(oddOccurrencesInArray.solution(new int[]{2, 5, 6, 7, 4, 2, 5 , 6}));
    }

    public int solution(int[] A) {
        Set<Integer> ints = new HashSet<>();
        for(int j=0; j<A.length; j++){
            int a = A[j];
            if(ints.contains(a)){
                ints.remove(a);
            }else{
                ints.add(a);
            }
       }
        return ints.iterator().next();
    }
}
