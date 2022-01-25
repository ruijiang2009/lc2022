package com.lc2022.app.medium;

import java.util.ArrayList;
import java.util.List;

public class Question1272RemoveInterval {
  public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
    List<List<Integer>> result = new ArrayList<>();
    for(int[] interval : intervals) {
      List<Integer> item = new ArrayList<>();
      if (hasOverlap(interval, toBeRemoved)) {

        /**
         *  3 cases:
         *  1. removed is later than interval => remaining is null
         *  2. interval has one part left
         *  3. interval has 2 parts left
         */
        if (toBeRemovedContainsInterval(interval, toBeRemoved)) {
          continue;
        } else if (intervalContainsToBeRemoved(interval, toBeRemoved)) {
            if (toBeRemoved[0] > interval[0] ) {
              item.add(interval[0]);
              item.add(toBeRemoved[0]);
              result.add(item);
              item = new ArrayList<>();
            }
            if (interval[1] > toBeRemoved[1]) {
              item.add(toBeRemoved[1]);
              item.add(interval[1]);
            }
        } else {
          // find the remaining piece for the interval
          int iStart = Math.max(interval[0], toBeRemoved[0]);
          int iEnd = Math.min(interval[1], toBeRemoved[1]);
          if (iStart > interval[0]) {
            item.add(interval[0]);
            item.add(iStart);
          } else { // iStart < interval[0]
            item.add(iEnd);
            item.add(interval[1]);
          }
        }

      } else {
        item.add(interval[0]);
        item.add(interval[1]);
      }
      if (!item.isEmpty()) {
        result.add(item);
      }
    }

    return result;
  }

  private boolean hasOverlap(int[] interval1, int[] interval2) {
    int[] first = null;
    int[] second = null;
    if (interval1[0] < interval2[0]) {
      first = interval1;
      second = interval2;
    } else if (interval1[0] == interval2[0]) {
      return true;
    } else {
      first = interval2;
      second = interval1;
    }
    if (first[1] > second[0]) {
      return true;
    }
    return false;
  }

  private boolean toBeRemovedContainsInterval(int[] interval, int[] toBeRemoved) {
    if(toBeRemoved[0] <= interval[0] && toBeRemoved[1] >= interval[1]) {
      return true;
    }
    return false;
  }

  private boolean intervalContainsToBeRemoved(int[] interval, int[] toBeRemoved) {
    if(toBeRemoved[0] >= interval[0] && toBeRemoved[1] <= interval[1]) {
      return true;
    }
    return false;
  }
}
