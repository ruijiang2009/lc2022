package com.lc2022.app.medium;

import java.util.Arrays;

public class Question300LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int[] opt = new int[nums.length];
    Arrays.fill(opt, 1);
    int max = 1;
    for(int i = 0; i < nums.length; i++) {
      for(int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          opt[i] = Math.max(opt[i], opt[j] + 1);
          max = Math.max(opt[i], max);
        }
      }
    }
    return max;
  }
}
