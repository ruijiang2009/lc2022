package com.lc2022.app.interval;

public class Question915PartitionArrayIntoDisjointIntervals {
  public int partitionDisjoint(int[] nums) {
    if (nums == null) {
      return -1;
    }
    if (nums.length <= 1) {
      return 0;
    }
    int[] leftMax = new int[nums.length];
    leftMax[0] = nums[0];
    for(int i = 1; i < nums.length; i++) {
      leftMax[i] = Math.max(leftMax[i-1], nums[i]);
    }

    int len = nums.length;
    int[] rightMin = new int[nums.length];
    rightMin[len-1] = nums[len -1];
    for(int i = len-2; i >= 0; i--) {
      rightMin[i] = Math.min(rightMin[i+1], nums[i]);
    }

    for(int i = 0; i < nums.length-1; i++) {
      int left = leftMax[i];
      int right = rightMin[i+1];
      if(left <= right) {
        return i+1;
      }
    }
    return -1;
  }
}
