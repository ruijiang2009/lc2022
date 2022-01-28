package com.lc2022.app.medium.interval;

import com.lc2022.app.util.PrintUtil;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Question1851MinimumIntervalToIncludeEachQueryTest {
  Question1851MinimumIntervalToIncludeEachQuery solution = new Question1851MinimumIntervalToIncludeEachQuery();

  @Test
  public void test1() {
    int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
    int[] queries = {2,3,4,5};
    int[] output = solution.minInterval(intervals, queries);
    PrintUtil.printIntArray(output);
  }

  @Test
  public void test2() throws Exception {
    BufferedReader reader = new BufferedReader(
        new FileReader("/Users/ruijiang/Programming/my-git/lc2022/my-app/src/test/data/question1851/intervals.txt"));
    String intervalLine = reader.readLine();
    String queryLine = reader.readLine();
    int[][] intervals = parseIntervals(intervalLine);
    int[] queries = parseQueries(queryLine);
    int[] output = solution.minInterval(intervals, queries);
    PrintUtil.printIntArray(output);
  }

  private int[][] parseIntervals(String intervalLine) {
    intervalLine = intervalLine.substring(2, intervalLine.length()-2);
    String[] data = intervalLine.split("],\\[");
    int[][] result = new int[data.length][2];
    for(int i = 0; i < data.length; i++) {
      String[] values = data[i].split(",");
      result[i][0] = Integer.parseInt(values[0]);
      result[i][1] = Integer.parseInt(values[1]);
    }
    return result;
  }

  private int[] parseQueries(String rowLine) {
    rowLine = rowLine.substring(1, rowLine.length()-1);
    String[] data = rowLine.split(",");
    int[] result = new int[data.length];
    for(int i = 0; i < data.length; i++) {
      result[i] = Integer.parseInt(data[i]);
    }
    return result;
  }

}
