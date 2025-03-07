package com.psksoft;

public class TestPalindrome {
    public static void main(String[] args) {
        int n=898;
        System.out.println(isPalindrome(n));
    }

    private static boolean isPalindrome(int n) {
        int temp =n;
        StringBuilder s = new StringBuilder();
        while(true){
            s.append(n%10);
            if(n/10==0){
                break;
            }
            n = n/10;
        }
        return Integer.parseInt(s.toString())==temp;
    }
}
