package com.lc2022.app.medium;

public class Question875KokoEatingBananas {
  public int minEatingSpeed(int[] piles, int h) {
    int low = 1;
    int high = findMax(piles);
    int mid = 0;
    while(low < high) {
      mid = low + (high - low) / 2;
      int time = getEatingTime(piles, mid);
      if (time == h) {
        high = mid;
      } else if (time > h) {
        low = mid+1;
      } else {
        high = mid;
      }
    }
    return high;
  }

  private int getEatingTime(int[] piles, int speed) {
    int sum = 0;
    for(int num : piles) {
      sum += (num % speed == 0) ? (num / speed) : (num / speed + 1);
    }
    return sum;
  }

  private int findMax(int[] piles) {
    int x = Integer.MIN_VALUE;
    for(int num : piles) {
      x = Math.max(x, num);
    }
    return x;
  }
}
