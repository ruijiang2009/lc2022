package com.lc2022.app.medium;

import java.util.*;

public class Question1387SortIntegersByThePowerValue {
  class Value implements Comparable<Value> {
    int value;
    int numOfSteps;
    public Value(int value, int numOfSteps) {
      this.value = value;
      this.numOfSteps = numOfSteps;
    }

    @Override
    public int compareTo(Value o) {
      if (this.numOfSteps == o.numOfSteps) {
        return Integer.compare(this.value, o.value);
      }
      return Integer.compare(this.numOfSteps, o.numOfSteps);
    }
  }

  public int getKth(int lo, int hi, int k) {
    Map<Integer, Integer> valueToSteps = new HashMap<>();
    PriorityQueue<Value> pq = new PriorityQueue<>();
    for(int num = lo; num <= hi; num++) {
      int counter = 0;
      int tmp = num;
      List<Integer> records = new ArrayList<>();
      while(tmp != 1) {
        if (valueToSteps.containsKey(tmp)) {
          for(int i = 0; i < records.size(); i++) {
            valueToSteps.put(records.get(i), records.size() - i + valueToSteps.get(tmp));
          }
          records.clear();
          counter = valueToSteps.get(tmp) + counter;
          break;
        }
        counter++;
        records.add(tmp);
        tmp = getNextValue(tmp);
      }
      valueToSteps.put(num, counter);
      pq.add(new Value(num, counter));

      for(int i = 0; i < records.size(); i++) {
        valueToSteps.put(records.get(i), records.size() - i);
      }
    }
    int result = 0;
    for(int i = 0; i < k; i++) {
      Value v = pq.poll();
      result = v.value;
      System.out.println(String.format("value is %d, numOfstemps is %d", v.value, v.numOfSteps));
    }
    return result;
  }

  private int getNextValue(int num) {
    if (num % 2 == 1) {
      return num * 3 + 1;
    }
    return num/2;
  }
}
