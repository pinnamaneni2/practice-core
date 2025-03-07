package com.psksoft.sol;

public class Cake implements Food{
    {
        System.out.println("Food factory Returned object of "+ getType());
        System.out.println("Someone Ordered desert");
    }
    @Override
    public String getType() {
        return "Cake";
    }
}
