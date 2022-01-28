package com.lc2022.app.twopointer;


import org.junit.Assert;
import org.junit.Test;

public class Question42TrappingRainWaterTest {
  Question42TrappingRainWater solution = new Question42TrappingRainWater();

  @Test
  public void test1() {
    int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
    int result = solution.trap(input);
    Assert.assertEquals(result, 6);

  }
}
