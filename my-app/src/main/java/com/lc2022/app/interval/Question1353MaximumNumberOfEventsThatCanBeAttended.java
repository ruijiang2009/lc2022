package com.lc2022.app.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question1353MaximumNumberOfEventsThatCanBeAttended {
  public int maxEvents(int[][] events) {
    Arrays.sort(events, new Comparator<int[]>() {
      public int compare(int[] event1, int[] event2) {
          return event1[0] - event2[0];
      }
    });
    int result = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int idx = 0;
    int currentDay = 0;
    while(idx < events.length || !pq.isEmpty()) {
      if (pq.isEmpty()) {
        currentDay = events[idx][0]; //
      }
      // if event's start <= currentday, put those event's end into the priority queue
      while(idx < events.length && events[idx][0] <= currentDay) {
        pq.offer(events[idx][1]); // put those events' end in the queue
        idx++;
      }
      pq.poll();
      result++;
      currentDay++;// move to next day

      // if there are event's end before current day, we need to remove it, because those events has already ended.
      while(!pq.isEmpty() && pq.peek() < currentDay) {
        pq.poll();
      }
    }

    return result;
  }
}
