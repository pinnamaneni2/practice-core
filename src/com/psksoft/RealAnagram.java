package com.psksoft;

import java.util.*;

public class RealAnagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> inputStrings = new HashSet<>();

        System.out.println("enter stings length of 4 or less, type exit to stop");

        while (true) {
            String inputString = scanner.nextLine();
            if ("exit".equalsIgnoreCase(inputString)) {
                break;
            }

            if (Objects.nonNull(inputString) && inputString.length() <= 4) {
                inputStrings.add(inputString);
            }
        }
        System.out.println("inputStrings = " + inputStrings);
        Set<String> stringsToRemove = new HashSet<>();
        Map<String, Set<String>> stringByPerms = new HashMap<String, Set<String>>();

        inputStrings.forEach(str -> {
            if (isAnagram(stringByPerms, str)) {
                stringsToRemove.add(str);
            } else if (!stringByPerms.containsKey(str)) {
                Set<String> perms = getPermutations(str);
                stringByPerms.put(str, perms);
            }
        });

        inputStrings.removeAll(stringsToRemove);

        System.out.println("outputStrings = " + inputStrings);
    }

    private static boolean isAnagram(final Map<String, Set<String>> stringByPerms, final String str) {
        return stringByPerms.values().stream().flatMap(Collection::stream).anyMatch(str::equalsIgnoreCase);
    }

    private static Set<String> getPermutations(final String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return Collections.emptySet();
        }

        char[] chars = str.toCharArray();
        boolean[] used = new boolean[str.length()];
        StringBuilder permutation = new StringBuilder();
        Set<String> result = new HashSet<String>();
        calculatePossiblePermutation(chars, used, permutation, result);
        return result;
    }

    private static void calculatePossiblePermutation(char[] chars, boolean[] used, StringBuilder permutation, Set<String> result) {
        String oneCompPermutation = permutation.toString();
        if (oneCompPermutation.length() == chars.length) {
            result.add(oneCompPermutation);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            permutation.append(chars[i]);
            calculatePossiblePermutation(chars, used, permutation, result);
            permutation.deleteCharAt(permutation.length() - 1);
            used[i] = false;
        }
    }
}
