package com.psksoft.slove;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class LRU {
    private static final Map<Integer, Integer> map = new ConcurrentHashMap<>();
    private static final LinkedList<Integer> list = new LinkedList<>();


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the key to search in the cache");
        int key = s.nextInt();
        System.out.println("enter initial value for cache, lets assume key and values are same, comma separated values");
        String input = s.next();

        if (Objects.isNull(input) || input.length() == 0) {
            System.out.println("your data in valid for this problem");
            return;
        }


        Arrays.stream(input.split(","))
              .filter(LRU::isNumber)
              .map(String::trim)
              .map(Integer::parseInt)
              .forEach(
                      i -> {
                          map.computeIfAbsent(i, k -> i);
                          list.add(i);
                      }
              );

        System.out.println("Entered values: " + list);
        System.out.println("key that is fetched: " + getKey(key));
        System.out.println("After update: " + list);
    }

    private static boolean isNumber(final String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (final Exception e) {
            return false;
        }
    }

    private static Integer getKey(int i) {
        if (map.containsKey(i)) {
            updateKey(i);
            return map.get(i);
        }
        return -1;
    }

    private static void updateKey(int i) {
        int indexOf = list.indexOf(i);

        if (indexOf == -1) {
            list.addFirst(i);
        } else {
            list.remove(indexOf);
            list.addFirst(i);
        }

        if (list.size() > 10) {
            list.removeLast();
        }
    }

}

