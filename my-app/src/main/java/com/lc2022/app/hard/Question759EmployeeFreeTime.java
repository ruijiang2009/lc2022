package com.lc2022.app.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question759EmployeeFreeTime {
  class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
      start = _start;
      end = _end;
    }
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> timeLine = new ArrayList<>();
    schedule.forEach(e -> timeLine.addAll(e));
    Collections.sort(timeLine, ((a, b) -> a.start - b.start));

    Interval pre = timeLine.get(0);
    List<Interval> result = new ArrayList<>();
    for(int i = 1; i < timeLine.size(); i++) {
      Interval cur = timeLine.get(i);
      if (pre.end >= cur.start) {
        pre.end = Math.max(cur.end, pre.end);
      } else {
        result.add(new Interval(pre.end, cur.start));
        pre = cur;
      }

    }
    return result;
  }
}
