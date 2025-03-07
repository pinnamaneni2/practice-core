package com.psksoft;

import java.util.*;
import java.util.stream.Collectors;

public class FindSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> ints = new ArrayList<Double>();

        System.out.println("Enter the key value ");
        int key = scanner.nextInt();

        System.out.println("Enter the integer values for list, type exit to stop");
        while (true) {
            String inputInt = scanner.nextLine();
            if ("exit".equalsIgnoreCase(inputInt)) {
                break;
            }

            if (Objects.isNull(inputInt) || !isNumber(inputInt)) {
                System.out.println("print valid number");
                continue;
            }
            ints.add(Double.valueOf(inputInt));
        }

        System.out.println("input numbers" + ints);
        double bigNumber = 0;
        int indexToReplace =0;
        for (int i = 0; i < key; i++) {
            for(int j=0; j< ints.size(); j++) {
                if(-1==Double.compare(bigNumber, ints.get(j))){
                   bigNumber = ints.get(j);
                   indexToReplace = j;
                }
            }
            bigNumber = bigNumber/2;
            bigNumber = Math.ceil(bigNumber);
            ints.set(indexToReplace, bigNumber);
        }

        Optional<Double> reduce = ints.stream().reduce(Double::sum);

        System.out.println(reduce.orElse(0.0));

    }

    private static boolean isNumber(String inputInt) {
        try {
            Integer.parseInt(inputInt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
