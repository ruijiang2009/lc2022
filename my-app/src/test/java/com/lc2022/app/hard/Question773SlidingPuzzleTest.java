package com.lc2022.app.hard;

import org.junit.Test;

public class Question773SlidingPuzzleTest {
  Question773SlidingPuzzle solution = new Question773SlidingPuzzle();

  @Test
  public void test1() {
    int[][] board = {{1,2,3},{4,0,5}};
    int result = solution.slidingPuzzle(board);
    System.out.println(result);
  }

}
