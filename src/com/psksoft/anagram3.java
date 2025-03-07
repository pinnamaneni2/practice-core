package com.psksoft;

import java.util.*;

public class anagram3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputStrings = new ArrayList<>();

        System.out.println("Enter strings for finding Anagram, type exit to stop");

        while (true) {
            String inputString = scanner.next();

            if ("exit".equalsIgnoreCase(inputString)) {
                break;
            }

            if (Objects.isNull(inputString) || inputString.length() == 0) {
                continue;
            }

            inputStrings.add(inputString);
        }


        System.out.println("input strings:" + inputStrings);
        System.out.println("output strings:" + skipAnagramStrings(inputStrings));
    }

    private static Set<String> skipAnagramStrings(final List<String> inputStrings) {
        Set<String> uniqStrings = new HashSet<String>();
        Set<String> result = new HashSet<String>();
        inputStrings.forEach(str -> {
            String sortedString = getSortedString(str);
            if (!uniqStrings.contains(sortedString)) {
                uniqStrings.add(sortedString);
                result.add(str);
            }
        });
        return result;
    }

    private static String getSortedString(final String str) {
        Set<Character> characters = new TreeSet<>();
        for (char c : str.toCharArray()) {
            characters.add(c);
        }
        StringBuilder stringBuilder = new StringBuilder(characters.size());
        for (char c : characters) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
