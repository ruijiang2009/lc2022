package com.lc2022.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question435NonOverlappingIntervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    List<Interval> intervalList = new ArrayList<>();
    for(int[] interval : intervals) {
      intervalList.add(new Interval(interval[0], interval[1]));
    }
    Collections.sort(intervalList, new MyComparator());

    int count = 0;
    int end = intervalList.get(0).end;
    for(int i = 1; i < intervalList.size(); i++) {
      Interval interval = intervalList.get(i);
      if (end > interval.start) { // overlab
        count++;
        if (interval.end < end) {
          end = interval.end;
        }
      } else {
        end = interval.end;
      }
    }
    return count;
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
