package com.lc2022.app.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Question2034StockPriceFluctuation {
  static class StockPrice {
    TreeMap<Integer, Integer> timeToPriceMap;
    TreeMap<Integer, Set<Integer>> priceToTimeMap;

    public StockPrice() {
      timeToPriceMap = new TreeMap<>();
      priceToTimeMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
      if (timeToPriceMap.containsKey(timestamp)) {
        int oldPrice = timeToPriceMap.get(timestamp);
        Set<Integer> oldTimestamps = priceToTimeMap.get(oldPrice);
        oldTimestamps.remove(timestamp);
        if (oldTimestamps.isEmpty()) {
          priceToTimeMap.remove(oldPrice);
        }

        Set<Integer> timestamps = priceToTimeMap.getOrDefault(price, new HashSet<>());
        timestamps.add(timestamp);
        priceToTimeMap.put(price, timestamps);
      } else {
        Set<Integer> timestamps = priceToTimeMap.getOrDefault(price, new HashSet<>());
        timestamps.add(timestamp);
        priceToTimeMap.put(price, timestamps);
      }
      timeToPriceMap.put(timestamp, price);
    }

    public int current() {
      return timeToPriceMap.lastEntry().getValue();
    }

    public int maximum() {
      return priceToTimeMap.lastKey();
    }

    public int minimum() {
      return priceToTimeMap.firstKey();
    }
  }
}
