package com.psksoft.sol;

public class Pizza implements Food{
    {
        System.out.println("Food factory Returned object of "+ getType());
        System.out.println("Someone Ordered main course");
    }
    @Override
    public String getType() {
        return "Pizza";
    }
}
