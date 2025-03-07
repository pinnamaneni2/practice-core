package com.psksoft.ml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class NavieBias {
    public static final String S1 = "S1";
    public static final String S0 = "S0";
    public static final String NS1 = "NS1";
    public static final String NS0 = "NS0";
    public static final String W0 = "W0";
    public static final String W1 = "w1";
    public static final String W2 = "w2";

    public static void main(String[] args) {
        NavieBias bias = new NavieBias();

        List<Email> emails = new ArrayList<>();
        emails.add(new Email(List.of(1, 0, 0, 1), "spam"));
        emails.add(new Email(List.of(0, 1, 1, 0), "spam"));
        emails.add(new Email(List.of(0, 0, 0, 1), "non-spam"));
        emails.add(new Email(List.of(1, 1, 0, 0), "spam"));
        emails.add(new Email(List.of(0, 0, 1, 0), "non-spam"));
        AtomicInteger spamCount = new AtomicInteger(0);
        AtomicInteger nonSpamCount = new AtomicInteger(0);

        Map<String, Map<String, AtomicInteger>> wordBySpamNonSpamByCount = new HashMap<>();
        emails.forEach(e -> {
            int i = e.getClsName()
                     .contains("non") ? nonSpamCount.incrementAndGet() : spamCount.incrementAndGet();
            for (int j = 0; j < e.getWordsPresence().size(); j++) {
                if (e.getWordsPresence().get(j) == 0) {
                    zeroOrOne(e, wordBySpamNonSpamByCount, j, NS0, S0);
                } else {
                    zeroOrOne(e, wordBySpamNonSpamByCount, j, NS1, S1);
                }
            }
        });

        Email spam = new Email(List.of(0, 1, 1,0), "spam");


        Map<String, Double> values = new HashMap<String, Double>();

        wordBySpamNonSpamByCount.forEach((k, v) -> {
            v.forEach((k1, v1) -> {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(k);
                stringBuilder.append(k1);
                values.put(stringBuilder.toString(), bias.getValues(k1, v1, spamCount, nonSpamCount));


            });
        });
        Double y1 = Double.parseDouble(String.valueOf(spamCount)) / emails.size();
        Double y0 = Double.parseDouble(String.valueOf(nonSpamCount)) / emails.size();

        List<String> spamKeys = getFinalKeyForPro(spam, "spam");
        List<String> nonSpamKeys = getFinalKeyForPro(spam, "nonSpam");
        Optional<Double> sP = getTotalSOrNPropability(values, spamKeys);
        Optional<Double> nsp = getTotalSOrNPropability(values, nonSpamKeys);
        double s00 = sP.get() * y1;
        double s11 = nsp.get() * y0;
        String s = s00 > s11 ? "spam" : "non-spam";
        System.out.println(s);
    }

    private static Optional<Double> getTotalSOrNPropability(Map<String, Double> values, List<String> spamKeys) {
        System.out.println("____________");
        spamKeys.forEach(k -> System.out.println(k + ":" + values.get(k)));
        return Optional.of(spamKeys.stream()
                                   .map(values::get)
                                   .map(v -> Objects.isNull(v) ? 0 : v)
                                   .reduce(Double.valueOf("1"), (d0, d1) -> d0 * d1));
    }

    private static List<String> getFinalKeyForPro(Email spam, String spamOrNot) {
        Set<String> set = new HashSet<>();
        for (int k = 0; k < spam.getWordsPresence().size(); k++) {
            StringBuilder builder = new StringBuilder();
            builder.append(getWord(k));
            if (spamOrNot.contains("non")) {
                getPKey(spam, k, builder, NS1, NS0);
            } else {
                getPKey(spam, k, builder, S1, S0);
            }
            set.add(builder.toString());
        }
        return new ArrayList<>(set);
    }

    private static void getPKey(Email spam, int k, StringBuilder builder, String ns1, String ns0) {
        if (spam.getWordsPresence().get(k) == 1) {
            builder.append(ns1);
        } else {
            builder.append(ns0);
        }
    }

    private Double getValues(String k1, AtomicInteger v1, final AtomicInteger sCount, final AtomicInteger nsCount) {
        double v = Double.parseDouble(String.valueOf(v1.get()));
        double sc = Double.parseDouble(String.valueOf(sCount.get()));
        double nsc = Double.parseDouble(String.valueOf(nsCount.get()));
        return k1.contains("n") ? v / nsc : v / sc;

    }


    private static void zeroOrOne(Email e, Map<String, Map<String, AtomicInteger>> wordBySpamNonSpamByCount, int j, String ns, String s) {
        if (e.getClsName().contains("non")) {
            setValues(wordBySpamNonSpamByCount, j, ns);

        } else {
            setValues(wordBySpamNonSpamByCount, j, s);
        }
    }

    private static void setValues(Map<String, Map<String, AtomicInteger>> wordBySpamNonSpamByCount, int j, String ns0) {
        if (wordBySpamNonSpamByCount.containsKey(getWord(j))) {

            if (wordBySpamNonSpamByCount.get(getWord(j)).containsKey(ns0)) {
                wordBySpamNonSpamByCount.get(getWord(j)).get(ns0)
                                        .incrementAndGet();
            } else {
                wordBySpamNonSpamByCount.get(getWord(j)).put(ns0, new AtomicInteger(1));
            }

        } else {
            Map<String, AtomicInteger> spamNonSpamByCount = new HashMap<>();
            spamNonSpamByCount.put(ns0, new AtomicInteger(1));
            wordBySpamNonSpamByCount.put(getWord(j), spamNonSpamByCount);
        }
    }

    private static String getWord(int j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("W");
        stringBuilder.append(j);
        return stringBuilder.toString();
    }

    static class Email {
        List<Integer> wordsPresence;
        String clsName;

        public List<Integer> getWordsPresence() {
            return wordsPresence;
        }

        public void setWordsPresence(List<Integer> wordsPresence) {
            this.wordsPresence = wordsPresence;
        }

        public String getClsName() {
            return clsName;
        }

        public void setClsName(String clsName) {
            this.clsName = clsName;
        }

        public Email(List<Integer> wordsPresence, String clsName) {
            this.wordsPresence = wordsPresence;
            this.clsName = clsName;
        }
    }
}
