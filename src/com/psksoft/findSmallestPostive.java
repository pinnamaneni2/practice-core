package com.psksoft;

import java.util.Scanner;
import java.util.TreeSet;

public class findSmallestPostive {

    public static void main(String[] args) throws Exception {
      int[] i= new int[]{1, 2, 5, 4, 6};

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter array size:");
        int arraySize = scanner.nextInt();
        int[] intArray = new int[arraySize];
        System.out.println("Enter array values of size: "+arraySize);
        int j=0;
        while (j<arraySize) {
            intArray[j] = scanner.nextInt();
            j++;
        }

        System.out.println(findSmallMissingPositiveNum(intArray));
    }

    private static int findSmallMissingPositiveNum(final int[] intArray) throws Exception {

        int smallestPositiveNum =-1000000;
        int maxNumber =1000000;
        int maxSize = 1000000;
        TreeSet<Integer> integers = new TreeSet<>();

        for(int i=0; i<intArray.length; i++){
            integers.add(intArray[i]);
        }

        if(integers.last()> maxNumber || integers.first()<smallestPositiveNum || integers.size() >maxSize){
            throw new Exception("in valid number");
        }

        for(int j=1; j<intArray.length; j++){
            if(!integers.contains(j)){
             return j;
            }
        }

        return 1;
    }



}
