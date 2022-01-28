package com.lc2022.app.interval;

import java.util.*;

public class Question253MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, new MyComparator());
    if (intervals == null || intervals.length < 1) {
      return 0;
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length, new MyComparator());
    int result = 1;
    pq.add(intervals[0]);
    for(int i = 1; i < intervals.length; i++) {
      Iterator<int[]> iterator = pq.iterator();
      while(iterator.hasNext()) {
        int[] cursor = iterator.next();
        if (cursor[1] <= intervals[i][0]) {
          iterator.remove();;
        }
      }
      pq.add(intervals[i]);
      result = Math.max(result, pq.size());
    }
    return result;
  }

  // sort the intervals by end
  class MyComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
      if (a[0] != b[0]) {
        return a[0] - b[0];
      }
      return a[1] - b[1];
    }
  }
}
