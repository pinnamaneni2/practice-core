package com.psksoft;

import com.psksoft.sol.Food;


import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter food that you would like from Cake or Pizza");
        String food = scanner.next();

        String f = toUpperCamelCase(food);
        FoodFactory factory = new FoodFactory();

        System.out.println("The factory returned class of " + f);
        System.out.println(factory.getFood(f).getType());
    }

    private static String toUpperCamelCase(String food) {
        if (Objects.isNull(food) || food.length() == 0) {
            throw new RuntimeException("empty or null input");
        }
        StringBuilder builder = new StringBuilder();
        char[] chars = food.toCharArray();
        for (int i = 0; i < food.length(); i++) {
            if (i == 0) {
                builder.append(String.valueOf(chars[i]).toUpperCase());
            } else {
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }

    static class FoodFactory {

        public Food getFood(final String obj) {
            if (Objects.isNull(obj)) {
                return null;
            }
            if (obj.equalsIgnoreCase("cake")) {
                return new Cake();
            } else if (obj.equalsIgnoreCase("pizza")) {
                return new Pizza();
            }
            return null;
        }
    }

    static class Pizza implements Food {
        @Override
        public String getType() {
            return "Someone ordered Fast Food!";
        }
    }

    static class Cake implements Food {

        @Override
        public String getType() {
            return "Someone ordered a Dessert!";
        }
    }
}


