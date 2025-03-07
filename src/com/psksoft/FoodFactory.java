package com.psksoft;

import java.util.HashMap;
import java.util.Map;

public class FoodFactory {
    private FoodFactory() {

    }
    Map<String, Cuisine> register = new HashMap<String, Cuisine>();

    private static class singletonClass {
        private static final FoodFactory INSTANCE = new FoodFactory();
    }

    public static FoodFactory getInstance() {
        return singletonClass.INSTANCE;
    }

    void registerCuisine(final String cuisineKey, final Cuisine cuisine) {
        register.put(cuisineKey, cuisine);
    }

    Cuisine getCuisine(final String cuisineKey) {
        return register.get(cuisineKey);
    }
}
