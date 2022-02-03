package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question1387SortIntegersByThePowerValueTest {
  Question1387SortIntegersByThePowerValue solution = new Question1387SortIntegersByThePowerValue();

  @Test
  public void test1() {
    int low = 7;
    int high = 11;
    int k = 4;

    Assert.assertEquals(7, solution.getKth(low, high, k));
  }

  @Test
  public void test2() {
    int low = 10;
    int high = 20;
    int k = 5;

    Assert.assertEquals(13, solution.getKth(low, high, k));
  }
}
