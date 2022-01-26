package com.lc2022.app.medium.interval;

import com.lc2022.app.util.PrintUtil;
import org.junit.Test;

public class Question56MergeIntervalsTest {
  Question56MergeIntervals solution = new Question56MergeIntervals();

  @Test
  public void test1() {
    int[][] input = {{1,3},{2,6},{8,10},{15,18}};
    int[][] output = solution.merge(input);
    PrintUtil.print2DIntArray(output);
  }

  @Test
  public void test2() {
    int[][] input = {{1,4},{4,5}};
    int[][] output = solution.merge(input);
    PrintUtil.print2DIntArray(output);
  }
}
