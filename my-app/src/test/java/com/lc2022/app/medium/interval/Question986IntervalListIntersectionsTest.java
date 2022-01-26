package com.lc2022.app.medium.interval;

import com.lc2022.app.util.PrintUtil;
import org.junit.Test;

public class Question986IntervalListIntersectionsTest {
  Question986IntervalListIntersections solution = new Question986IntervalListIntersections();
  @Test
  public void test1() {
    int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
    int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
    int[][] result = solution.intervalIntersection(firstList, secondList);
    PrintUtil.print2DIntArray(result);
  }
}
