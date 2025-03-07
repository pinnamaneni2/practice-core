package com.psksoft;

public class Position {
    private String accountNumber;
    private String stockSymbol;
    private int numOfShares;

    // Constructors, getters, setters
    public Position(String accountNumber, String stockSymbol, int numOfShares) {
        this.accountNumber = accountNumber;
        this.stockSymbol = stockSymbol;
        this.numOfShares = numOfShares;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getNumOfShares() {
        return numOfShares;
    }
}

