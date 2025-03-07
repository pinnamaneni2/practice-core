package com.psksoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GenomicRangeQuery {

    public static void main(String[] args) {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        System.out.println(genomicRangeQuery.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
//        System.out.println(solution("CAGTCAT", new int[]{0, 1, 3}, new int[]{0, 5, 4}));
//        System.out.println(solution("ATT", new int[]{0, 0, 0}, new int[]{0, 0, 0}));
//        System.out.println(solution("GG", new int[]{0, 1, 0}, new int[]{0, 1, 1}));
//        System.out.println(solution("TT", new int[]{0, 0, 0}, new int[]{1, 1, 1}));
//        System.out.println(solution("CAGCCTA", new int[]{0, 1, 3}, new int[]{2, 3, 7}));
    }

    public static int[] solution1(String s, int[] p, int[] q) {
        IntStream chars = s.chars();
        List<Integer> c = new ArrayList<>();
        chars.forEach(i -> c.add(i));
        ArrayList<Integer> minImpFact = new ArrayList<>();
        Map<Integer, Integer> impactFactor = new HashMap<>();
        impactFactor.put(65, 1);
        impactFactor.put(67, 2);
        impactFactor.put(71, 3);
        impactFactor.put(84, 4);
        final AtomicInteger minIF = new AtomicInteger(Integer.MAX_VALUE);
        for (int j = 0; j < p.length; j++) {
            if (p[j] <= q[j]) {
                if (p[j] == q[j]) {
                    minImpFact.add(impactFactor.get(c.get(p[j]).intValue()));
                } else if (p[j] < q[j]) {
                    Map<Integer, Integer> subNucImpFac = new HashMap<>();
                    c.subList(p[j], q[j]).forEach(i -> {
                        if (!subNucImpFac.containsKey(i)) {
                            Integer integer = impactFactor.get(i);
                            minIF.set(Math.min(minIF.get(), integer));
                            subNucImpFac.put(i, integer);
                        }
                    });

                    minImpFact.add(minIF.get());

                }
            }

        }
        return minImpFact.stream().mapToInt(i -> i).toArray();
    }

    public int[] solution(String S, int[] P, int[] Q) {
        int sL = S.length();
        int[][] counters = new int[3][sL];
        int a = 0;
        int c = 0;
        int g = 0;
        for (int i = 1; i < S.length(); i++) {
            String s = S.substring(i, i + 1);
            if (s.equals("A")) {
                a++;
            } else if (s.equals("C")) {
                c++;
            } else if (s.equals("G")) {
                g++;
            }
            counters[0][i] = a;
            counters[1][i] = c;
            counters[2][i] = g;
        }

        int[] result = new int[P.length];
        for (int i = 0; i < result.length; i++) {
            int startIndex = P[i];
            int endIndex = Q[i] + 1;
            int re = 4;
            for (int j = 0; j < 3; j++) {
                if (counters[j][startIndex] != counters[j][endIndex]) {
                    re = j + 1;
                    break;
                }
            }
            result[i] = re;
        }
        return result;
    }
}
