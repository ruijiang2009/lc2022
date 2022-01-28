package com.lc2022.app.medium.interval;

import java.util.ArrayList;
import java.util.List;

public class Question986IntervalListIntersections {
  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    int firstIdx = 0;
    int secondIdx = 0;
    List<int[]> intersections = new ArrayList<>();

    while(firstIdx < firstList.length && secondIdx < secondList.length) {
      int[] firstInterval = firstList[firstIdx];
      int[] secondInterval = secondList[secondIdx];
      int[] overlap = generateOverlap(firstInterval, secondInterval);
      if (overlap != null) {
        intersections.add(overlap);
      }
      if (firstInterval[1] < secondInterval[1]) {
        firstIdx++;
      } else {
        secondIdx++;
      }
    }

    int[][] result = new int[intersections.size()][2];

    for(int i = 0; i < intersections.size(); i++) {
      result[i][0] = intersections.get(i)[0];
      result[i][1] = intersections.get(i)[1];
    }
    return result;
  }

  private boolean isOverlap(int[] first, int[] second) {
    if (first[0] < second[0]) {
      if (first[1] >= second[0]) {
        return true;
      }
      return false;
    } else if (first[0] > second[0]){
      if (second[1] >= first[0]) {
        return true;
      }
      return false;
    } else {
      return true;
    }
  }

  private int[] generateOverlap(int[] first, int[] second) {
    if(isOverlap(first, second)) {
      int[] overlap = new int[2];
      overlap[0] = Math.max(first[0], second[0]);
      overlap[1] = Math.min(first[1], second[1]);
      return overlap;
    }
    return null;
  }


}
