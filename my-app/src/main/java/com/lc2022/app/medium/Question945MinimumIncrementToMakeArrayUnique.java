package com.lc2022.app.medium;

import java.util.Arrays;

public class Question945MinimumIncrementToMakeArrayUnique {
  public int minIncrementForUnique(int[] nums) {
    Arrays.sort(nums);
    int result = 0;
    int pre = nums[0];
    for(int i = 1; i < nums.length; i++) {
      int cur = nums[i];
      if (cur <= pre) {
        int newValue = pre+1;
        result += newValue - cur;
        nums[i] = newValue;
      }
      pre = nums[i];
    }
    return result;
  }
}
