package com.lc2022.app.medium;

import java.util.*;

public class Question1058MinimizeRoundingErrorToMeetTarget {
  public String minimizeError(String[] prices, int target) {
    List<Double> diff = new ArrayList<>(); // diff to next integer, e.g.["0.700","2.800","4.900"] => [0.3, 0.2, 0.1]
    for (String p : prices) {
      double price = Double.valueOf(p);
      target -= (int) price;
      if (target < 0)
        return "-1";
      double decimal = price - (int)price;
      if (decimal != 0 && decimal != 1) {
        diff.add(1 - decimal);
      }
    }
    if (target > diff.size()) return "-1";
    // need to pick (# of target) greater integer, and pick (diff.size()-target) smaller integer
//    diff.sort((d1, d2) -> d1.compareTo(d2));
    Collections.sort(diff);
    double res = 0;
    for (int i = 0; i < diff.size(); i++) {
      if (i < target) {
        res += diff.get(i);
      } else {
        res += 1 - diff.get(i);
      }
    }
    return String.format("%.3f", res);
  }

  public String minimizeErrorNotWorking(String[] prices, int target) {
    int minV = 0;
    int maxV = 0;
    PriorityQueue<Double> ceilingDiff = new PriorityQueue<>();
    for(String p : prices) {
      Double price = Double.parseDouble(p);
      minV += Math.floor(price);
      Double ceiling = Math.ceil(price);
      ceilingDiff.add(ceiling - price);
      maxV += ceiling;
    }
    if(target < minV || target > maxV) {
      return "-1";
    }
    int numberOfCeiling = target - minV;
    Double result = 0.0;
    for(int i = 0; i < numberOfCeiling; i++) {
      result += ceilingDiff.poll();
    }
    for(int i = numberOfCeiling; i < prices.length; i++) {
      double diff = ceilingDiff.poll();
      if(diff == 0.000) {
        continue;
      }
      result += (1 - diff);
    }
    return String.format("%.3f", result);
  }
}
