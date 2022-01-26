package com.lc2022.app.medium.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question57InsertInterval {
  /**
   * The solution is O(n), no better solution
   * */
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int n = intervals.length;
    List<int[]> intervalList = new ArrayList<>();
    boolean added = false;
    for(int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];
      if (interval[1] < newInterval[0]) {
        intervalList.add(interval);
      } else if(interval[0] > newInterval[1]) {
        if (!added) {
          intervalList.add(newInterval);
          added = true;
        }
        intervalList.add(interval);
      } else if (canMerge(interval, newInterval)) {
        merge(newInterval, interval);
      }
    }
    if (!added) {
      intervalList.add(newInterval);
    }
    return convertToArray(intervalList);
  }


  /**
   * make sure interval1's start is less or equal to interval 2
   * */
  private boolean canMerge(int[] interval1, int[] interval2) {
    int end1 = interval1[0] < interval2[0] ? interval1[1] : interval2[1];
    int beg2 = interval1[0] < interval2[0] ? interval2[0] : interval1[0];;
    if(end1 >= beg2) {
      return true;
    }
    return false;
  }

  /**
   * Merge into interval1
   * */
  private void merge(int[] interval1, int[] interval2) {
    interval1[0] = Math.min(interval1[0], interval2[0]);
    interval1[1] = Math.max(interval1[1], interval2[1]);
  }

  private int[][] convertToArray(List<int[]> list) {
    int[][] intervals = new int[list.size()][2];
    for(int i = 0; i < list.size(); i++) {
      intervals[i] = list.get(i);
    }
    return intervals;
  }
}
