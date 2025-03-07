package com.psksoft;

import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        System.out.println("enter Strings for anagram of len 4");
        System.out.println("enter values for anagram, type exit to stop:");
        while (true) {
            System.out.println("enter value >");
            String string = scanner.nextLine();
            if ("exit".equalsIgnoreCase(string)) {
                break;
            }
            if (Objects.nonNull(string) && string.length() <= 4) {
                strings.add(string);
            }

        }
        System.out.println("\n input strings start here\n");
        strings.forEach(System.out::println);
        System.out.println("\n input strings ends here\n");
        Map<String, Set<String>> stringsByPermutations = new HashMap<String, Set<String>>();
        Set<String> toRemove = new HashSet<String>();
        strings.forEach(str -> {
            if (isAnagram(stringsByPermutations, str)) {
                toRemove.add(str);
            }else if (!stringsByPermutations.containsKey(str)) {
                Set<String> perms = generatePermutations(str);
                stringsByPermutations.put(str, perms);
            }
        });
//        strings.forEach(string -> {
//            if (isAnagram(stringsByPermutations, string)) {
//                toRemove.add(string);
//            }
//        });
        strings.removeAll(toRemove);
        System.out.println("output strings start here\n");
        strings.forEach(System.out::println);
        System.out.println("output strings ends here\n");
    }

    private static boolean isAnagram(Map<String, Set<String>> stringsByPermutations, String str) {
        return stringsByPermutations.values().stream().flatMap(Collection::stream).anyMatch(str::equalsIgnoreCase);
    }

    private static Set<String> generatePermutations(final String str) {
        if (Objects.isNull(str) || str.length() == 0) {
            return Collections.emptySet();
        }

        char[] characters = str.toCharArray();
        boolean[] used = new boolean[str.length()];
        StringBuilder currentPermutation = new StringBuilder();
        Set<String> result = new HashSet<>();
        genPermHelper(characters, used, currentPermutation, result);
        return result;
    }

    private static void genPermHelper(char[] characters, boolean[] used, StringBuilder currentPermutation, Set<String> result) {
        if (currentPermutation.length() == characters.length) {
            result.add(currentPermutation.toString());
            return;
        }
        for (int i = 0; i < characters.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            currentPermutation.append(characters[i]);
            genPermHelper(characters, used, currentPermutation, result);
            currentPermutation.deleteCharAt(currentPermutation.length() - 1);
            used[i] = false;
        }
    }
}

