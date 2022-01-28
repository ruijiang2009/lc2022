package com.lc2022.app.medium.interval;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Question436FindRightInterval {

  public int[] findRightInterval(int[][] intervals) {
    TreeMap<Integer, int[]> records = new TreeMap<>();
    Map<Integer, Integer> startToIdx = new HashMap<>();
    for(int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];
      records.put(interval[0], interval);
      startToIdx.put(interval[0], i);
    }
    int[] result = new int[intervals.length];
    for(int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];
      Integer ceilingKey = records.ceilingKey(interval[1]);
      if (ceilingKey == null) {
        result[i] = -1;
      } else {
        result[i] = startToIdx.get(ceilingKey);
      }
    }
    return result;
  }

}
