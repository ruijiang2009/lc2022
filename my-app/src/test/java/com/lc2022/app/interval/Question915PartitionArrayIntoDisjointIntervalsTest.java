package com.lc2022.app.interval;

import org.junit.Assert;
import org.junit.Test;

public class Question915PartitionArrayIntoDisjointIntervalsTest {
  Question915PartitionArrayIntoDisjointIntervals solution = new Question915PartitionArrayIntoDisjointIntervals();

  @Test
  public void test1() {
    int[] input = {5,0,3,8,6};
    int output = solution.partitionDisjoint(input);
    Assert.assertEquals(3, output);
  }

  @Test
  public void test2() {
    int[] input = {32,57,24,19,0,24,49,67,87,87};
    int output = solution.partitionDisjoint(input);
    Assert.assertEquals(7, output);
  }

  @Test
  public void test3() {
    int[] input = {24,11,49,80,63,8,61,22,73,85};
    int output = solution.partitionDisjoint(input);
    Assert.assertEquals(9, output);
  }

  @Test
  public void test4() {
    int[] input = {1,1,1,0,6,12};
    int output = solution.partitionDisjoint(input);
    Assert.assertEquals(4, output);
  }
}
