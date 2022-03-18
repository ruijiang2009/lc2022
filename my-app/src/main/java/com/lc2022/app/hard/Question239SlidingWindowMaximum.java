package com.lc2022.app.hard;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Question239SlidingWindowMaximum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    TreeMap<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();
    int[] result = new int[nums.length - k + 1];
    for(int i = 0; i < nums.length; i++) {
      int cur = nums[i];
      if (!treeMap.containsKey(cur)) {
        treeMap.put(cur, new PriorityQueue<>((x, y) -> Integer.compare(y, x)));
      }
      treeMap.get(cur).add(i);
      if (i >= k-1) {
        PriorityQueue<Integer> pq = null;
        int lastValue;
        do {
          lastValue = treeMap.lastKey();
          pq = treeMap.lastEntry().getValue();
          while (!pq.isEmpty() && i- pq.peek() >= k) {
            pq.poll();
          }
          if (pq.isEmpty()) {
            treeMap.remove(lastValue);
          }
        } while(pq.isEmpty());
        result[i - k + 1] = lastValue;
      }
    }
    return result;
  }
}
