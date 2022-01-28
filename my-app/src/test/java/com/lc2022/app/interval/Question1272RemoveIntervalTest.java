package com.lc2022.app.medium.interval;

import com.lc2022.app.medium.interval.Question1272RemoveInterval;
import com.lc2022.app.util.PrintUtil;
import org.junit.Test;

import java.util.List;

public class Question1272RemoveIntervalTest {
  Question1272RemoveInterval solution = new Question1272RemoveInterval();

  @Test
  public void test1() {
    int[][] input= {{0,2},{3,4},{5,7}};
    int[] toBeRemoved = {1, 6};

    List<List<Integer>> result = solution.removeInterval(input, toBeRemoved);

    PrintUtil.print2DIntList(result);
  }

  @Test
  public void test2() {
    int[][] input= {{0,5}};
    int[] toBeRemoved = {2, 3};

    List<List<Integer>> result = solution.removeInterval(input, toBeRemoved);

    PrintUtil.print2DIntList(result);
  }
}
