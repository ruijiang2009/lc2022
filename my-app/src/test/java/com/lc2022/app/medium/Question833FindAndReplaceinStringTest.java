package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question833FindAndReplaceinStringTest {
  Question833FindAndReplaceinString solution = new Question833FindAndReplaceinString();

  @Test
  public void test1() {
    int[] indices = {0, 2};
    String[] sources = {"a", "cd"};
    String[] targets = {"eee", "ffff"};
    String s = "abcd";
    String output = solution.findReplaceString(s, indices, sources, targets);
    Assert.assertEquals("eeebffff", output);
  }

  @Test
  public void test2() {
    int[] indices = {0, 2};
    String[] sources = {"ab", "ec"};
    String[] targets = {"eee", "ffff"};
    String s = "abcd";
    String output = solution.findReplaceString(s, indices, sources, targets);
    Assert.assertEquals("eeecd", output);
  }

  @Test
  public void test3() {
    String s = "reauaqyxle";
    int[] indices = {4,6,2};
    String[] sources = {"aq","yxl","au"};
    String[] targets = {"c","dh","ev"};
    String output = solution.findReplaceString(s, indices, sources, targets);
    Assert.assertEquals("reevcdhe", output);
  }
}
