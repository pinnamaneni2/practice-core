package com.psksoft;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CeilingDivide2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String numbersInString = getString(scanner);
        System.out.println("Enter values by comma separated");
        int key = scanner.nextInt();

        if (Objects.isNull(numbersInString) || numbersInString.length() == 0) {
            throw new Exception("in valid input");
        }


        List<Integer> ints = Arrays.stream(numbersInString.split(","))
                .map(String::trim).filter(CeilingDivide2::isRealInt)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int bigNum = 0;
        int indexToReplacement = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < ints.size(); j++) {
                if (-1 == Integer.compare(bigNum, ints.get(j))) {
                    bigNum = ints.get(j);
                    indexToReplacement=j;
                }
            }
            double i1 = bigNum / (double)2;
            double ceil = Math.ceil(i1);
            bigNum= Double.valueOf(ceil).intValue();
            ints.set(indexToReplacement,bigNum);
        }

        ints.stream().reduce(Integer::sum).ifPresent(System.out::println);
    }

    private static boolean isRealInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static String getString(Scanner scanner) {
        System.out.println("Enter values by comma separated");
        String numbersInString = scanner.next();
        return numbersInString;
    }
}
