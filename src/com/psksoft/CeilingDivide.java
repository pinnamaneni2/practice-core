package com.psksoft;

import java.util.*;
import java.util.stream.Collectors;

public class CeilingDivide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Enter numbers separated by commas:");
        String input = scanner.nextLine();
        System.out.println("Enter key:");
        int key = scanner.nextInt();

        // Parse input numbers
        numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Initial processing: Divide each number by 2 and calculate ceiling
        numbers = numbers.stream()
                .map(num -> (int) Math.ceil(num / 2.0))
                .collect(Collectors.toList());

        // Key iterations
        for (int i = 0; i < key; i++) {
            // Find the maximum number in the list
            int maxIndex = 0;
            for (int j = 1; j < numbers.size(); j++) {
                if (numbers.get(j) > numbers.get(maxIndex)) {
                    maxIndex = j;
                }
            }
            // Divide the maximum number by 2 and calculate ceiling
            numbers.set(maxIndex, (int) Math.ceil(numbers.get(maxIndex) / 2.0));
        }

        // Calculate the sum of the resulting list
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();

        // Output the result
        System.out.println("Resulting sum: " + sum);
    }
}

