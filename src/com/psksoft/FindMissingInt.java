package com.psksoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMissingInt {
    public static void main(String [] args){
       //System.out.println( solution(new int[]{1, 4, 5, 3, 6, 7}));
        //System.out.println( solution(new int[]{-1, -2, -4, -5, 3, 6, 7}));
        System.out.println(solution(new int[]{2, 3, 1,5}));
    }

    private static int solution(int[] a){
        Set<Integer> ints = new HashSet<>();
        for(int i=1;i<a.length+1; i++){
            ints.add(i);
        }
        Arrays.stream(a).forEach(System.out::print);
        System.out.println(ints);
        for(int j:a){
            ints.remove(j);
        }
        return ints.iterator().next();
    }
}
