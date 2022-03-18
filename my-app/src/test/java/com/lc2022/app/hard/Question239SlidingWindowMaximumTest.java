package com.lc2022.app.hard;

import com.lc2022.app.util.PrintUtil;
import org.junit.Test;

public class Question239SlidingWindowMaximumTest {
  Question239SlidingWindowMaximum solution = new Question239SlidingWindowMaximum();

  @Test
  public void test1() {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int k = 3;
    int[] result = solution.maxSlidingWindow(nums, k);
    PrintUtil.printIntArray(result);
  }

  @Test
  public void test2() {
    int[] nums = {1};
    int k = 1;
    int[] result = solution.maxSlidingWindow(nums, k);
    PrintUtil.printIntArray(result);
  }

  @Test
  public void test3() {
    int[] nums = {1, -1};
    int k = 1;
    int[] result = solution.maxSlidingWindow(nums, k);
    PrintUtil.printIntArray(result);
  }
}
