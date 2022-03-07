package com.lc2022.app.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question1751MaximuMumberOfEventsII {
  class Event implements  Comparable<Event> {
    int start;
    int end;
    int value;

    public Event(int start, int end, int value) {
      this.start = start;
      this.end = end;
      this.value = value;
    }

    @Override
    public int compareTo(Event obj) {
        if (this.start == obj.start) {
          return 0;
        }
        if (this.start > obj.start) {
          return 1;
        }
        return -1;
    }
  }
  public int maxValue(int[][] events, int k) {
    List<Event> eventList = new ArrayList<>();
    for(int[] event : events) {
      eventList.add(new Event(event[0], event[1], event[2]));
    }
    Collections.sort(eventList);

    int[][] opt = new int[events.length+1][k+1]; // Maximum value attending at most events among the ith events
    int result = 0;
    for(int i = 0; i < eventList.size(); i++) {
      Event curEvent = eventList.get(i);
      if (i == 0) {
        opt[i+1][1] = curEvent.value;
        result = Math.max(opt[i+1][1], result);
        continue;
      }
      opt[i+1][1] = curEvent.value;
      result = Math.max(opt[i+1][1], result);
      for(int j = 0; j < i; j++) {
        Event preEvent = eventList.get(j);
        if (preEvent.end < curEvent.start) {
          for(int z = 1; z < k; z++) {
            if (opt[j+1][z] != 0) {
              opt[i+1][z+1] = Math.max(opt[i+1][z+1], opt[j+1][z] + curEvent.value);
              result = Math.max(opt[i+1][z+1], result);
            }
          }
        }
      }
    }

    return result;
  }
}
