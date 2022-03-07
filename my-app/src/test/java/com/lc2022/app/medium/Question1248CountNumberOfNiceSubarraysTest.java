package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question1248CountNumberOfNiceSubarraysTest {
  Question1248CountNumberOfNiceSubarrays solution = new Question1248CountNumberOfNiceSubarrays();

  @Test
  public void test1() {
    int[] nums = {1,1,2,1,1};
    int k = 3;
    Assert.assertEquals(2, solution.numberOfSubarrays(nums, k));
  }

  @Test
  public void test2() {
    int[] nums = {2,2,2,1,2,2,1,2,2,2};
    int k = 2;
    Assert.assertEquals(16, solution.numberOfSubarrays(nums, k));
  }
}
