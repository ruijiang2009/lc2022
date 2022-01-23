package com.lc2022.app.medium;

import com.lc2022.app.util.PrintUtil;
import org.junit.Test;

public class Question57InsertIntervalTest {
  Question57InsertInterval solution = new Question57InsertInterval();

  @Test
  public void test1() {
    int[][] intervals = {{1, 3}, {6, 9}};
    int[] newInterval = {2, 5};

    int[][] output = solution.insert(intervals, newInterval);
    PrintUtil.print2DIntArray(output);
  }

  @Test
  public void test2() {
    int[][] intervals = {{1,2}, {3,5},{6,7},{8,10},{12,16}};
    int[] newInterval = {4, 8};

    int[][] output = solution.insert(intervals, newInterval);
    PrintUtil.print2DIntArray(output);
  }

  @Test
  public void test3() {
    int[][] intervals = {{1, 5}, {6, 8}};
    int[] newInterval = {5, 6};

    int[][] output = solution.insert(intervals, newInterval);
    PrintUtil.print2DIntArray(output);
  }
}
