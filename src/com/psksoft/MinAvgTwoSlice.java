package com.psksoft;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.IntStream;

public class MinAvgTwoSlice {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }

    public static Character solution(int[] a) {
        List<Integer> givenList = new ArrayList<>();
        Arrays.stream(a).forEach(i -> givenList.add(i));
        System.out.println(givenList);
        Map<String, Double> indexAndAvgMap = new ConcurrentHashMap<>();
        for (int q = 0; q < a.length; q++) {

            for (int p = 0; p < q; p++) {
                if (p == q) {
                    System.out.println("p" + p + "q");
                } else {
                    Double sum = Double.valueOf(givenList.subList(p, q).stream().mapToInt(i -> i).sum());
                    Double avg = sum / (q - p + 1);
                    final int p1 = p;
                    final int q1 = q;
                    if (indexAndAvgMap != null && indexAndAvgMap.size()>1) {
                        indexAndAvgMap.entrySet().forEach(e -> {
                            double min = Math.min(avg, e.getValue());
                            if (min == avg && avg == e.getValue()) {
                            } else if (min == avg && avg != e.getValue()) {
                                indexAndAvgMap.remove(e.getKey());
                                indexAndAvgMap.put(p1 + String.valueOf(q1), min);
                            }
                        });
                    }else{
                        indexAndAvgMap.put(p1 + String.valueOf(q1), avg);
                    }
                }

            }
        }
        //System.out.println(minImpFact);
        if (indexAndAvgMap.entrySet().stream().findFirst().isPresent()) {
            return indexAndAvgMap.entrySet().stream().findFirst().get().getKey().charAt(0);
        }
        return '1';
    }

}
