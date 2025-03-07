package com.psksoft;

public class Quote {
    private String stockSymbol;
    private double stockPrice;

    // Constructors, getters, setters
    public Quote(String stockSymbol, double stockPrice) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public double getStockPrice() {
        return stockPrice;
    }
}