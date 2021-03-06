package com.lc2022.app.twopointer;

public class Question42TrappingRainWater {
  public int trap(int[] height) {
    int n = height.length;
    int[] leftMax = new int[n];
    int[] rightMax = new int[n];
    leftMax[0] = 0;
    for(int i = 1; i < n; i++) {
      leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
    }
    rightMax[n-1] = 0;
    for(int i = n-2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
    }

    int result = 0;
    for(int i = 0; i < n; i++) {
      result += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
    }

    return result;
  }
}
