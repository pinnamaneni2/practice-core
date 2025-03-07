package com.psksoft;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class MaxCounters {
    public static void main(String[] args) {
        int a[] = new int[]{3, 4, 4, 6, 1, 4, 4};

        int b[] = new int[]{2, 1, 3, 2};
        //3 2 2 4 2
        //getMaxCounters(5, a).s
        Arrays.stream(solution(5, a)).forEach(i -> System.out.print(" " + i));
        System.out.println("");
        //Arrays.stream(getMaxCounters(2, b)).forEach(i->System.out.print(" " + i ));
    }

    public static int[] getMaxCounters(int N, int[] a) {

        List<Integer> counters = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            counters.add(0);
        }
        final AtomicInteger maxCount = new AtomicInteger(0);
        for (int j = 0; j < a.length; j++) {
            if (a[j] == N + 1) {
                counters.replaceAll(e -> maxCount.get());
            } else if (1 <= a[j] && a[j] <= N) {
                int counterPosition = a[j] - 1;
                int sum = Integer.sum(counters.get(counterPosition), 1);
                counters.remove(counterPosition);
                counters.add(counterPosition, sum);
                maxCount.set(Math.max(sum, maxCount.get()));
            }
        }

        return counters.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution1(int N, int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        final AtomicInteger maxC = new AtomicInteger(0);
        for (int j = 0; j < a.length; j++) {
            if (a[j] == N + 1) {
                for (int i = 0; i < N; i++) {
                    map.replaceAll((k, v) -> maxC.get());
                }
            } else if (1 <= a[j] && a[j] <= N) {
                int counterPosition = a[j] - 1;
                int i = map.get(counterPosition) + 1;
                map.put(counterPosition, i);
                maxC.set(Math.max(maxC.get(), i));
            }
        }
        return map.values().stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution(int N, int[] a) {
        int[] counters = new int[N];
        //0<= a[k] <=N+1
        int minVal = 0;
        int maxVal = 0;
        for (int j = 0; j < a.length; j++) {
            int operation = a[j];
            if (operation == N + 1) {
                minVal = maxVal;
            } else {
                operation--;
                counters[operation] = Math.max(counters[operation] + 1, minVal + 1);
                maxVal = Math.max(maxVal, counters[operation]);

            }
        }

        for(int i=0; i<N; i++){
            counters[i] = Math.max(counters[i], minVal);

        }
        return counters;
    }

    public static <K, V extends Comparable<V>> V maxUsingStreamAndMethodReference(Map<K, V> map) {
        Optional<Map.Entry<K, V>> maxEntry = map.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue));
        return maxEntry.get()
                .getValue();
    }
}
