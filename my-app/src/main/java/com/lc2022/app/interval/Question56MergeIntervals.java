package com.lc2022.app.medium.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question56MergeIntervals {
  public int[][] merge(int[][] intervals) {
    List<Interval> intervalList = sortIntervalList(intervals);
    Interval pre = intervalList.get(0);

    List<Interval> mergedList = new ArrayList<>();

    for(int i = 1; i < intervals.length; i++) {
      Interval cur = intervalList.get(i);
      if (canMerge(pre, cur)) {
        pre = merge(pre, cur);
      } else {
        mergedList.add(pre);
        pre = cur;
      }
    }
    mergedList.add(pre);

    int[][] result = new int[mergedList.size()][2];
    for(int i = 0; i < mergedList.size(); i++) {
      result[i][0] = mergedList.get(i).start;
      result[i][1] = mergedList.get(i).end;
    }
    return result;
  }

  private Interval merge(Interval i1, Interval i2) {
    return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
  }


  private boolean canMerge(Interval i1, Interval i2) {
    if (i1.start < i2.start) {
      if (i2.start > i1.end) {
        return false;
      }
      return true;
    } else if (i1.start > i2.start) {
      if (i1.start > i2.end) {
        return false;
      }
      return true;
    } else {
      return true;
    }
  }

  private List<Interval> sortIntervalList(int[][] intervals) {
    List<Interval> intervalList = new ArrayList<>();
    for(int[] interval : intervals) {
      intervalList.add(new Interval(interval[0], interval[1]));
    }
    Collections.sort(intervalList, new MyComparator());
    return intervalList;
  }

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
}
