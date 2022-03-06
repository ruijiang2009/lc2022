package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question79WordSearchTest {
  Question79WordSearch solution = new Question79WordSearch();

  @Test
  public void test1() {
    char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    String word = "ABCCED";
    Assert.assertEquals(true, solution.exist(board, word));
  }
}
