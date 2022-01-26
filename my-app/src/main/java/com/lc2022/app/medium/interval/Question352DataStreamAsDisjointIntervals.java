package com.lc2022.app.medium.interval;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeMap;

public class Question352DataStreamAsDisjointIntervals {

  public static class SummaryRanges {

    class Interval {
      int start;
      int end;
      public Interval(int start, int end) {
        this.start = start;
        this.end = end;
      }
    }

    class MyComparator implements Comparator<Interval> {
      public int compare(Interval a, Interval b) {
        return a.start - b.start;
      }
    }

    TreeMap<Integer, Interval> records;
    public SummaryRanges() {
      records = new TreeMap<>();
    }

    public void addNum(int val) {
      Integer leftBiggestStart = records.floorKey(val);
      Integer rightSmallestStart = records.ceilingKey(val);
      Interval rightSmallestInterval = rightSmallestStart == null ? null : records.get(rightSmallestStart);
      Interval leftBiggestInterval = leftBiggestStart == null ? null : records.get(leftBiggestStart);

      if (leftBiggestInterval == null && rightSmallestInterval == null) {
        records.put(val, new Interval(val, val));
      } else if (leftBiggestInterval == null && rightSmallestInterval != null) {
        // leftBiggestInterval == null && rightSmallestInterval != null
        if (rightSmallestInterval.start == val + 1) {
          records.remove(rightSmallestInterval.start);
          rightSmallestInterval.start = val;
          records.put(rightSmallestInterval.start, rightSmallestInterval);
        } else {
          records.put(val, new Interval(val, val));
        }
      } else if (leftBiggestInterval != null && rightSmallestInterval == null) {
        // leftBiggestInterval != null && rightSmallestInterval == null
        if (leftBiggestInterval.end + 1 >= val) {
          leftBiggestInterval.end = Math.max(leftBiggestInterval.end, val);
        } else {
          records.put(val, new Interval(val, val));
        }
      } else {
        // leftBiggestInterval != null && rightSmallestInterval != null
        if (leftBiggestInterval.end + 1 == val && rightSmallestInterval.start - 1 == val) {
          // merge 3 interval
          leftBiggestInterval.end = rightSmallestInterval.end;
          records.remove(rightSmallestStart);
        } else if (leftBiggestInterval.end + 1 >= val) {
          leftBiggestInterval.end = Math.max(leftBiggestInterval.end, val);
        } else if (val >= rightSmallestInterval.start - 1) {
          records.remove(rightSmallestStart);
          rightSmallestInterval.start = Math.min(rightSmallestInterval.start, val);
          records.put(rightSmallestInterval.start, rightSmallestInterval);
        } else {
          records.put(val, new Interval(val, val));
        }
      }

    }

    public int[][] getIntervals() {
      Collection<Interval> values = records.values();
      int[][] result = new int[values.size()][2];
      int idx = 0;
      for(Interval i : values) {
        result[idx][0] = i.start;
        result[idx][1] = i.end;
        idx++;
      }
      return result;
    }
  }
}
