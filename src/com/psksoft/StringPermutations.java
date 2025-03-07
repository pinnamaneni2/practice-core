package com.psksoft;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        String input = "abc"; // Example input string
        List<String> permutations = generatePermutations(input);

        System.out.println("All possible permutations:");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<String> generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        char[] chars = str.toCharArray();
        boolean[] used = new boolean[str.length()];
        StringBuilder currentPermutation = new StringBuilder();
        generatePermutationsHelper(chars, used, currentPermutation, result);
        return result;
    }

    private static void generatePermutationsHelper(char[] chars, boolean[] used, StringBuilder currentPermutation, List<String> result) {
        if (currentPermutation.length() == chars.length) {
            result.add(currentPermutation.toString());
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

