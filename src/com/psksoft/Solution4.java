package com.psksoft;

import java.io.*;
import java.util.*;
interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    public PerformOperation isOdd(){
        return (int a)-> a % 2 != 0;
    }

    public PerformOperation isPrime(){
        return (int a)-> a % 2 == 1;
    }
    public PerformOperation isPalindrome(){
        return (int a)-> {
            int temp =a;
            StringBuilder s = new StringBuilder();
            while(true){
                s.append(a%10);
                if(a/10==0){
                    break;
                }
                a = a/10;
            }
            return Integer.parseInt(s.toString())==temp;

        };
    }

}   // Write your code here

public class Solution4 {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.next());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            int ch = Integer.parseInt(scanner.next());
            int num = Integer.parseInt(scanner.next());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

