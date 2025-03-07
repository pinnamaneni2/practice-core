package com.psksoft;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class StockValueCalculator {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Position> positions = Arrays.asList(
                new Position("ACC1", "AAPL", 10),
                new Position("ACC1", "GOOG", 15),
                new Position("ACC2", "AAPL", 5),
                new Position("ACC2", "MSFT", 20)
        );

        List<Quote> quotes = Arrays.asList(
                new Quote("AAPL", 150.0),
                new Quote("GOOG", 1000.0),
                new Quote("MSFT", 200.0)
        );

        Map<String, Double> stockPrices = quotes.stream()
                .collect(Collectors.toMap(Quote::getStockSymbol, Quote::getStockPrice));

        Map<String, Double> accountTotalValues2 = getTotalAccountValue2(positions, stockPrices);
        accountTotalValues2.forEach((account, totalValue) ->
                System.out.println("Account: " + account + ", Total Stock Value: " + totalValue)
        );

        Map<String, Double> accountTotalValues
                = getTotalAccountValue(positions, stockPrices);
        accountTotalValues.forEach((account, totalValue) ->
                System.out.println("Account: " + account + ", Total Stock Value: " + totalValue)
        );
    }

    private static Map<String, Double> getTotalAccountValue(List<Position> positions, Map<String, Double> stockPrices) throws InterruptedException, ExecutionException {
        CompletableFuture<Map<String, Double>> futureResult = CompletableFuture.supplyAsync(() ->
                positions.stream()
                        .collect(Collectors.groupingBy(
                                Position::getAccountNumber,
                                Collectors.summingDouble(position ->
                                        position.getNumOfShares() * stockPrices.getOrDefault(position.getStockSymbol(), 0.0)
                                )
                        ))
        );

        return futureResult.get();
    }

    private static Map<String, Double> getTotalAccountValue1(List<Position> positions, Map<String, Double> stockPrices) throws InterruptedException, ExecutionException {
        HashMap<String, Double> accNumByValue = new HashMap<>();
                positions.forEach(p->{
                    Double val = p.getNumOfShares() * stockPrices.getOrDefault(p.getStockSymbol(), 0.0);
                    Double value = accNumByValue.getOrDefault(p.getAccountNumber(), 0.0);
                    double v = value + val;
                    accNumByValue.put(p.getAccountNumber(), v);
                });

        return accNumByValue;
    }


        private static Map<String, Double> getTotalAccountValue2(List<Position> positions, Map<String, Double> stockPrices) throws InterruptedException, ExecutionException {
            Map<String, Double> accNumByValue = new HashMap<>();
            positions.forEach(position ->{
                double stockPrice = stockPrices.getOrDefault(position.getStockSymbol(), 0.0);
                double positionValue = position.getNumOfShares() * stockPrice;
                accNumByValue.merge(position.getAccountNumber(), positionValue, Double::sum);
            });

            return accNumByValue;
        }


    }


