package com.lc2022.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question1751MaximuMumberOfEventsIITest {
  Question1751MaximuMumberOfEventsII solution = new Question1751MaximuMumberOfEventsII();

  @Test
  public void test1() {
    int[][] events = {{1,2,4},{3,4,3},{2,3,1}};
    int k = 2;
    Assert.assertEquals(7, solution.maxValue(events, k));
  }

  @Test
  public void test2() {
    int[][] events = {{1,2,4},{3,4,3},{2,3,10}};
    int k = 2;
    Assert.assertEquals(10, solution.maxValue(events, k));
  }

  @Test
  public void test3() {
    int[][] events = {{1,1,1},{2,2,2},{3,3,3}, {4,4,4}};
    int k = 3;
    Assert.assertEquals(9, solution.maxValue(events, k));
  }
}
