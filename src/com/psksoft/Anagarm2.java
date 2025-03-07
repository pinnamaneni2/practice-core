package com.psksoft;

import java.util.*;
import java.util.stream.Stream;

public class Anagarm2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings1 = new ArrayList<>();
        System.out.println("enter values (type 'exit' to stop):");
        while(true) {
            System.out.println(">");
            String next = scanner.nextLine();
            if("exit".equalsIgnoreCase(next)){
                break;
            }
            strings1.add(next);
        }

        strings1.forEach(System.out::println);

        strings1.stream()
                .map(Anagarm2::generatePermutations)
                .forEach(System.out::println);
        Set<String> strings = generatePermutations(strings1.get(0));
        //System.out.println(strings.size());
    }

    public static Set<String> generatePermutations(String str) {
        Set<String> result = new HashSet<String>();
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        System.out.println(calFactorial(chars.length));
        boolean[] used = new boolean[str.length()];
        StringBuilder currentPermutation = new StringBuilder();
        generatePermutationsHelper(chars, used, currentPermutation, result);
        return result;
    }

    private static Long calFactorial(int length) {
        if(length == 0){
            return 0l;
        }
        if(length > 1){
            return length * calFactorial(length-1);
        }
        return 1l;

    }

    private static void generatePermutationsHelper(char[] chars, boolean[] used, StringBuilder currentPermutation, Set<String> result) {
        String s = currentPermutation.toString();
        if (currentPermutation.length() == chars.length && !result.contains(s)) {
            result.add(s);
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            currentPermutation.append(chars[i]);
            generatePermutationsHelper(chars, used, currentPermutation, result);
            currentPermutation.deleteCharAt(currentPermutation.length() - 1);
            used[i] = false;
        }
    }
}
