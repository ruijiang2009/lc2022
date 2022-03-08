package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question1197MinimumKnightMovesTest {
  Question1197MinimumKnightMoves solution = new Question1197MinimumKnightMoves();

  @Test
  public void test1() {
    Assert.assertEquals(100, solution.minKnightMoves(2, 112));
  }
}
