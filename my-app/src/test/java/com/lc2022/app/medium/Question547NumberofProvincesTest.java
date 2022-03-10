package com.lc2022.app.medium;

import com.lc2022.app.interval.Question547NumberofProvinces;
import org.junit.Assert;
import org.junit.Test;

public class Question547NumberofProvincesTest {
  Question547NumberofProvinces solution = new Question547NumberofProvinces();

  @Test
  public void test1() {
    int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
    Assert.assertEquals(1, solution.findCircleNum(isConnected));
  }
}
