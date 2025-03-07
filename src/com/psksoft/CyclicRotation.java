package com.psksoft;

public class CyclicRotation {



    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();

        //int[] ints = cyclicRotation.solution(new int[]{3, 4, 5, 6, 1, 2}, 1);
        int[] ints = cyclicRotation.solution1(new int[]{3, 4, 5, 6, 1, 2}, 1000);
        for(int i:ints){
            System.out.print(i);
        }
    }

    private int[] solution(int[] ints, int i) {
        for(int l:ints){
            System.out.print(l);
        }
        System.out.println("");

        if(ints.length ==0 || ints.length == i){
            return ints;
        }
        for(int r =0; r<i;r++){
           int lastValue = ints[ints.length-1];
           for(int k=ints.length-2; k>=0; k--){
               ints[k+1]=ints[k];
           }
           ints[0]=lastValue;
        }
        return ints;
    }

    private int[] solution1(int[] ints, int i){
        if(ints.length ==0 || ints.length == i){
            return ints;
        }
        int[] finalInt = new int[ints.length];

        for(int j=0; j<ints.length; j++){
            int rotation = (j+i)%ints.length;
            finalInt[rotation]=ints[j];
        }
        return finalInt;
    }
}
