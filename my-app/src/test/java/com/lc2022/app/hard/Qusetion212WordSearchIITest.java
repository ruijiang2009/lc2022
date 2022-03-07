package com.lc2022.app.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Qusetion212WordSearchIITest {
  Qusetion212WordSearchII solution = new Qusetion212WordSearchII();

  @Test
  public void test1() {
    char[][] board = {{'a'}};
    String[] words = {"a"};
    List<String> result = solution.findWords(board, words);
    Assert.assertEquals(1, result.size());
  }

  @Test
  public void test2() {
    char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
    String[] words = {"oath","pea","eat","rain"};
    List<String> result = solution.findWords(board, words);
    Assert.assertEquals(2, result.size());
  }
}
