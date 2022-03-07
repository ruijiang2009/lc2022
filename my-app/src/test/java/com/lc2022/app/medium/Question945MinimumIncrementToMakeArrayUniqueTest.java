package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question945MinimumIncrementToMakeArrayUniqueTest {
  Question945MinimumIncrementToMakeArrayUnique solution = new Question945MinimumIncrementToMakeArrayUnique();

  @Test
  public void test1() {
    int[] nums = {3,2,1,2,1,7};
    Assert.assertEquals(6, solution.minIncrementForUnique(nums));
  }

}
