package com.lc2022.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question864ShortestPathToGetAllKeysTest {
  Question864ShortestPathToGetAllKeys solution = new Question864ShortestPathToGetAllKeys();

  @Test
  public void test1() {
    String[] grid = {"@.a.#","###.#","b.A.B"};
    int result = solution.shortestPathAllKeys(grid);
    Assert.assertEquals(8, result);
  }

  @Test
  public void test2() {
    String[] grid = {"@..aA","..B#.","....b"};
    int result = solution.shortestPathAllKeys(grid);
    Assert.assertEquals(6, result);
  }

  @Test
  public void test3() {
    String[] grid = {"@Aa"};
    int result = solution.shortestPathAllKeys(grid);
    Assert.assertEquals(-1, result);
  }


  @Test
  public void test4() {
    String[] grid = {"@...a",".###A","b.BCc"};
    int result = solution.shortestPathAllKeys(grid);
    Assert.assertEquals(10, result);
  }

}
