package com.psksoft;

import java.util.TreeSet;

public class FindSmallestPositiveNumber {

    public static void main(String[] args) throws Exception {
//        int a[] = new int[]{1, 3, 6, 4, 1, 2 };
//        System.out.println(findMissingPositiveSmallNumber(a) + "-----" + 5);
//        int b[] = new int [] {1, 2, 3 };
//        System.out.println(findMissingPositiveSmallNumber(b) + "-----" + 4);
        int c[]=new int [] {             -1000000,       1 };
        System.out.println(findMissingPositiveSmallNumber(c) + "-----" + 2);

//        int d[]=new int [] {             -1000000 };
//        System.out.println(findMissingPositiveSmallNumber(d) + "-----" + 1);
//
//        int e[] = new int [] { 1, 3, 999999, 999998, 1000000};
//        System.out.println(findMissingPositiveSmallNumber(e) + "-----" + 2);
//
//        int f[] =new int [] {                      -1,-3, 1 };
//        System.out.println(findMissingPositiveSmallNumber(f) + "-----" + 2);

    }

    public static int findMissingPositiveSmallNumber(int[] a) throws Exception {

        int smallestNumber = -1000000;
        int largestNumber = 1000000;
        int maxSize = 1000000;

        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            treeSet.add(a[i]);
        }
        if (treeSet.size() > maxSize ||
                treeSet.first() < smallestNumber ||
                treeSet.last() > largestNumber) {
            throw new Exception("Invalid input");
        }
        for (int i = 1; i <=a.length; i++) {
            if (!treeSet.contains(i)) {
                return i;
            }
        }
        if(!treeSet.contains((treeSet.last() + 1))) {
            return treeSet.last() + 1;
        }
        return 1;
    }

//    public static void createData1() {
//
//                 { {               };
//                new Object [] { new int [] {           1, 3, 6, 4, 1, 2, 5 }, 7 },
//                new Object [] { new int [] {                       1, 2, 3 }, 4 },
//                new Object [] { new int [] {                         -1,-3 }, 1 },
//                new Object [] { new int [] {                      -1,-3, 2 }, 1 },
//                new Object [] { new int [] {                      -1,-3, 1 }, 2 },
//                new Object [] { new int [] {                             0 }, 1 },
//                new Object [] { new int [] {                      -1000000 }, 1 },
//                new Object [] { new int [] {             -1000000,       1 }, 2 },
//                new Object [] { new int [] {                       1000000 }, 1 },
//                new Object [] { new int [] {       999999, 999998, 1000000 }, 1 },
//                new Object [] { new int [] { 1, 3, 999999, 999998, 1000000 }, 2 },
//}
}