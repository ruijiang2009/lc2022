package com.lc2022.app.hard;

import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

public class Question895MaximumFrequencyStack {
  static class FreqStack {
    TreeMap<Integer, TreeMap<Integer, Integer>> frequencyToIdxToNumbers = new TreeMap<>();
    HashMap<Integer, Integer> numberToFrequency = new HashMap<>();
    HashMap<Integer, Stack<Integer>> numberToIdx = new HashMap<>();
    int idx = 0;

    public FreqStack() {
    }

    public void push(int val) {
      int frequency = numberToFrequency.getOrDefault(val, 0) + 1;
      numberToFrequency.put(val, frequency);
      Stack<Integer> indexes = numberToIdx.getOrDefault(val, new Stack<>());
      int lastIdx = -1;
      if (!indexes.isEmpty()) {
        lastIdx = indexes.peek();
      }
      indexes.push(idx);
      numberToIdx.put(val, indexes);
      if (frequency > 1) {
        // remove the number from old frequency
        TreeMap<Integer, Integer> idxToNumbers = frequencyToIdxToNumbers.get(frequency-1);
        idxToNumbers.remove(lastIdx);
        if (idxToNumbers.isEmpty()) {
          frequencyToIdxToNumbers.remove(frequency-1);
        }
      }
      TreeMap<Integer, Integer> idxToNumbers = frequencyToIdxToNumbers.getOrDefault(frequency, new TreeMap<>());
      idxToNumbers.put(idx, val);
      frequencyToIdxToNumbers.put(frequency, idxToNumbers);
      idx++;
    }

    public int pop() {
      int maxFrequency = frequencyToIdxToNumbers.lastEntry().getKey();
      TreeMap<Integer, Integer> idxToNumbers = frequencyToIdxToNumbers.lastEntry().getValue();
      int lastNumber = idxToNumbers.lastEntry().getValue();
      int lastIdx = idxToNumbers.lastKey();

      Stack<Integer> indexes = numberToIdx.get(lastNumber);
      indexes.pop();
      if (indexes.isEmpty()) {
        numberToIdx.remove(lastNumber);
      }
      if (numberToFrequency.get(lastNumber) == 1) {
        numberToFrequency.remove(lastNumber);
      } else {
        numberToFrequency.put(lastNumber, maxFrequency-1);
      }

      // update old frequency
      if (idxToNumbers.size()==1) {
        frequencyToIdxToNumbers.remove(maxFrequency);
      } else {
        idxToNumbers.remove(lastIdx);
      }

      // update to new frequency
      TreeMap<Integer, Integer> idxToNumbersNew = frequencyToIdxToNumbers.getOrDefault(maxFrequency-1, new TreeMap<>());
      if (!indexes.isEmpty()) {
        lastIdx = indexes.peek();
        idxToNumbersNew.put(lastIdx, lastNumber);
      }
      frequencyToIdxToNumbers.put(maxFrequency-1, idxToNumbersNew);

      return lastNumber;
    }
  }
}
