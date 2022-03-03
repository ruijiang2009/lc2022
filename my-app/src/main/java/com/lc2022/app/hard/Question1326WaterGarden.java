package com.lc2022.app.hard;

import java.util.Arrays;

public class Question1326WaterGarden {
  public int minTaps(int n, int[] ranges) {
    int[] opt = new int[n+1];
    Arrays.fill(opt, n + 2);
    opt[0] = 0;
    for(int i = 0; i <= n; i++) {
      int leftMost = Math.max(0, i - ranges[i] + 1);
      int rightMost = Math.min(i + ranges[i], n);
      int leftMostMinus1 = Math.max(0, i - ranges[i]);
      for(int j = leftMost; j <= rightMost; j++) {
        opt[j] = Math.min(opt[j], opt[leftMostMinus1]+1);
      }
    }
    return opt[n]  < n + 2 ? opt[n] : -1;
  }
}
