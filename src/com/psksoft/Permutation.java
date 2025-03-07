package com.psksoft;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
       System.out.println(solution(new int [] {2, 2 }));
        System.out.println(solution(new int [] {1, 2 }));
        System.out.println(solution(new int [] {1, 2 }));
        System.out.println(solution(new int [] {1, 2, 4, 5 }));
    }

    public static int solution(int []a){
        HashSet<Integer> givenIntegers = new HashSet<>();
        HashSet<Integer> perfectInteger = new HashSet<>();
        for(int i=1;i<=a.length;i++){
            givenIntegers.add(a[i-1]);
            perfectInteger.add(i);
        }
        for(Integer integer:perfectInteger){
            if(!givenIntegers.contains(integer)){
              return 0;
            }
        }
        return 1;
    }
}
