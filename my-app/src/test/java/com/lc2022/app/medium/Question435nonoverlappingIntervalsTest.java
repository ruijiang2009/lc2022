package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question435nonoverlappingIntervalsTest {
  Question435NonOverlappingIntervals solution = new Question435NonOverlappingIntervals();

  @Test
  public void test1() {
    int[][] input = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
    int output = solution.eraseOverlapIntervals(input);
    Assert.assertEquals(1, output);
  }

  @Test
  public void test2() {
    int[][] input = {{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
    int output = solution.eraseOverlapIntervals(input);
    Assert.assertEquals(2, output);
  }
}