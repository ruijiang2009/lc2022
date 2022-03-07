package com.lc2022.app.medium;

import java.util.ArrayList;
import java.util.List;

public class Question1248CountNumberOfNiceSubarrays {
  public int numberOfSubarrays(int[] nums, int k) {
    int count = 0;
    ArrayList<Integer> oddIndex = new ArrayList<>();
    oddIndex.add(-1); // always assume there's odd number before.
    for(int i = 0; i < nums.length; i++) {
      if (isOdd(nums[i])) {
        oddIndex.add(i);
      }
      if (oddIndex.size() == k+2) {
        oddIndex.remove(0);
      }
      if (oddIndex.size() == k+1) {
        if (oddIndex.size() > 1) {
          count += oddIndex.get(1) - oddIndex.get(0);
        } else {
          count += i - oddIndex.get(0);
        }
      }

    }

    return count;
  }

  private boolean isOdd(int num) {
    return (num % 2) == 1;
  }
}
