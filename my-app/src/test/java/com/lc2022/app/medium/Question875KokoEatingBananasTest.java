package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question875KokoEatingBananasTest {
  Question875KokoEatingBananas solution = new Question875KokoEatingBananas();

  @Test
  public void test1() {
    int[] piles = {30, 11, 23, 4, 20};
    int h = 5;
    int result = solution.minEatingSpeed(piles, h);
    Assert.assertEquals(30, result);
  }

  @Test
  public void test2() {
    int[] piles = {3,6,7,11};
    int h = 8;
    int result = solution.minEatingSpeed(piles, h);
    Assert.assertEquals(4, result);
  }
}
