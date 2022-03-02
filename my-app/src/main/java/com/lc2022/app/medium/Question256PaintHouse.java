package com.lc2022.app.medium;

public class Question256PaintHouse {
  public int minCost(int[][] costs) {
    int n = costs.length;
    int[][] opt = new int[n][3];
    for(int i = 0; i < n; i++) {
      if (i == 0) {
        opt[0][0] = costs[0][0];
        opt[0][1] = costs[0][1];
        opt[0][2] = costs[0][2];
      } else {
        // first
        if (opt[i-1][1] > opt[i-1][2]) {
          opt[i][0] = costs[i][0] + opt[i-1][2];
        } else {
          opt[i][0] = costs[i][0] + opt[i-1][1];
        }
        // second
        if (opt[i-1][0] > opt[i-1][2]) {
          opt[i][1] = costs[i][1] + opt[i-1][2];
        } else {
          opt[i][1] = costs[i][1] + opt[i-1][0];
        }
        // third
        if (opt[i-1][0] > opt[i-1][1]) {
          opt[i][2] = costs[i][2] + opt[i-1][1];
        } else {
          opt[i][2] = costs[i][2] + opt[i-1][0];
        }
      }
    }
    return Math.min(Math.min(opt[n-1][0], opt[n-1][1]), opt[n-1][2]);
  }
}
