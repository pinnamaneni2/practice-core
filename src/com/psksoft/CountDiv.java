package com.psksoft;

import java.util.concurrent.atomic.AtomicInteger;

public class CountDiv {

    public static void main(String[] args) {
        //0, 11, 12
        //System.out.println(getCountDiv(6, 11, 2));
        //System.out.println(getCountDiv(0, 11, 12));
        //0, 0,  12
        //System.out.println(getCountDiv(0, 0, 12));
        //System.out.println(getCountDiv(1, 11, 12));
        CountDiv countDiv = new CountDiv();
        countDiv.solution(1, 6, 3);
    }

    public static int getCountDiv(int a, int b, int k){
        AtomicInteger atomicInteger = new AtomicInteger(0);
       if(a>=0 && 0<k && k<=b) {
           for (int i = a; i <= b; i++) {
               if (i % k == 0) {
                   atomicInteger.getAndIncrement();
               }
           }
       }else if((a==0 || b== 0) && k>b){
         return 1;
        }
        return atomicInteger.get();
    }

    public int solution(int A,int B, int K){
        //a, b 0, 2,000,000,000
    System.out.println("A :"+A+" B :"+B+" K :"+K);
        System.out.println("A/K :"+((double)A/K));
        int base = (int)Math.ceil((double) A/K);
       System.out.println("base: "+base);
        base *=K;
        B -=base;
        System.out.println("B-base :"+(B-base));
        int  count = (int)Math.floor((double) B / K);
        System.out.println("B/base :"+((double)B/K));
       count++;
       System.out.println("count: "+count);
        return count;
    }

}
