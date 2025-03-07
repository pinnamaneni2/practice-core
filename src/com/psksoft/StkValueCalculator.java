package com.psksoft;

import java.util.*;
import java.util.stream.Collectors;

public class StkValueCalculator {

    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position("Acc1", "TM", 5));
        positions.add(new Position("Acc2", "APPL", 15));
        positions.add(new Position("Acc1", "TM", 10));
        positions.add(new Position("Acc2", "MSFT", 20));

        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("TM", 192));
        quotes.add(new Quote("APPL", 220));
        quotes.add(new Quote("MSFT", 330));

        HashMap<String, Double> stockByPrice = new HashMap<>();
        quotes.forEach(q-> stockByPrice.computeIfAbsent(q.stockSymbol, k->q.getStockPrice()));

        Map<String, Double> aByV = positions
                .stream()
                .collect(Collectors.groupingBy(Position::getAccountNumber,
                                                    Collectors.summingDouble(position ->
                                                            position.getNumOfShares() * stockByPrice.getOrDefault(position.getStockSymbol(),
                                                                    0.0))));


        HashMap<String, Double> acctByValue = new HashMap<>();
        positions.forEach(
                acc-> {
                    double value = acc.numOfShares * stockByPrice.getOrDefault(acc.getStockSymbol(), 0.0);
                    acctByValue.merge(acc.getAccountNumber(), value, Double::sum);
                }
        );
        acctByValue.entrySet().forEach(System.out::println);
        System.out.println("-------------------");
        Map<String, Double> accByValue = positions
                .stream()
                .collect(Collectors.groupingBy(Position::getAccountNumber,
                                                    Collectors.summingDouble(position ->
                                                            position.numOfShares * stockByPrice.getOrDefault(position.getStockSymbol(),
                                                                    0.0))));

        accByValue.entrySet().forEach(System.out::println);
    }

    private static class Position {
        private String accountNumber;
        private String stockSymbol;
        private int numOfShares;

        Position() {
        }

        Position(final String accountNumber, final String stockSymbol, final int numOfShares) {
            this.accountNumber = accountNumber;
            this.stockSymbol = stockSymbol;
            this.numOfShares = numOfShares;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public String getStockSymbol() {
            return stockSymbol;
        }

        public void setStockSymbol(String stockSymbol) {
            this.stockSymbol = stockSymbol;
        }

        public int getNumOfShares() {
            return numOfShares;
        }

        public void setNumOfShares(int numOfShares) {
            this.numOfShares = numOfShares;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (numOfShares != position.numOfShares) return false;
            if (!Objects.equals(accountNumber, position.accountNumber))
                return false;
            return Objects.equals(stockSymbol, position.stockSymbol);
        }

        @Override
        public int hashCode() {
            int result = accountNumber != null ? accountNumber.hashCode() : 0;
            result = 31 * result + (stockSymbol != null ? stockSymbol.hashCode() : 0);
            result = 31 * result + numOfShares;
            return result;
        }
    }

    private static class Quote {
        private String stockSymbol;
        private double stockPrice;

        Quote(final String stockSymbol, final double stockPrice) {
            this.stockSymbol = stockSymbol;
            this.stockPrice = stockPrice;
        }

        public String getStockSymbol() {
            return this.stockSymbol;
        }

        public double getStockPrice() {
            return this.stockPrice;
        }

        public void setStockSymbol(final String stockSymbol) {
            this.stockSymbol = stockSymbol;
        }

        public void setStockPrice(double stockPrice) {
            this.stockPrice = stockPrice;
        }

        @Override
        public boolean equals(final Object o){
            if(this== o) return true;

            if (Objects.isNull(o) || getClass() != o.getClass()) return false;

            Quote quote = (Quote) o;

            if(Objects.nonNull(quote.getStockSymbol()) && this.getStockSymbol().equalsIgnoreCase(quote.getStockSymbol())) return false;

            return this.getStockPrice() == quote.getStockPrice();
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = stockSymbol != null ? stockSymbol.hashCode() : 0;
            temp = Double.doubleToLongBits(stockPrice);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}
