package com.psksoft.ml;

import java.util.*;

public class NavieBiasML {
    public static void main(String[] args) {
        List<Email> emails = Arrays.asList(
                new Email(List.of(1, 0, 0, 1), "spam"),
                new Email(List.of(0, 1, 1, 0), "spam"),
                new Email(List.of(0, 0, 0, 1), "non-spam"),
                new Email(List.of(1, 1, 0, 0), "spam"),
                new Email(List.of(0, 0, 1, 0), "non-spam")
        );

        Map<String, Map<String, Integer>> wordCounts = new HashMap<>();
        int spamCount = 0;
        int nonSpamCount = 0;

        for (Email email : emails) {
            if (email.getClsName().equals("spam")) {
                spamCount++;
            } else {
                nonSpamCount++;
            }

            for (int i = 0; i < email.getWordsPresence().size(); i++) {
                String word = "W" + i;
                int presence = email.getWordsPresence().get(i);
                String key = presence == 1 ? "S1" : "S0";
                if (email.getClsName().equals("non-spam")) {
                    key = presence == 1 ? "NS1" : "NS0";
                }

                wordCounts.computeIfAbsent(word, k -> new HashMap<>()).merge(key, 1, Integer::sum);
            }
        }

        Email testEmail = new Email(List.of(0, 1, 1, 0), "spam");
        double probability = calculateProbability(testEmail, wordCounts, spamCount, nonSpamCount);
        System.out.println(probability > 0.5 ? "spam" : "non-spam");
    }

    private static double calculateProbability(Email email, Map<String, Map<String, Integer>> wordCounts, int spamCount, int nonSpamCount) {
        double probability = 1.0;
        for (int i = 0; i < email.getWordsPresence().size(); i++) {
            String word = "W" + i;
            int presence = email.getWordsPresence().get(i);
            String key = presence == 1 ? "S1" : "S0";

            int count = wordCounts.getOrDefault(word, Collections.emptyMap()).getOrDefault(key, 0);
            probability *= (double) count / spamCount;
        }
        return probability;
    }

    static class Email {
        List<Integer> wordsPresence;
        String clsName;

        public Email(List<Integer> wordsPresence, String clsName) {
            this.wordsPresence = wordsPresence;
            this.clsName = clsName;
        }

        public List<Integer> getWordsPresence() {
            return wordsPresence;
        }

        public String getClsName() {
            return clsName;
        }
    }
}
