package com.lc2022.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question76MinimumWindowSubstringTest {
  Question76MinimumWindowSubstring solution = new Question76MinimumWindowSubstring();

  @Test
  public void test1() {
    String s = "ADOBECODEBANC";
    String t = "ABC";
    Assert.assertEquals("BANC", solution.minWindow(s, t));
  }

  @Test
  public void test2() {
    String s = "a";
    String t = "a";
    Assert.assertEquals("a", solution.minWindow(s, t));
  }

  @Test
  public void test3() {
    String s = "a";
    String t = "aa";
    Assert.assertEquals("", solution.minWindow(s, t));
  }

  @Test
  public void test4() {
    String s = "cabwefgewcwaefgcf";
    String t = "cae";
    Assert.assertEquals("cwae", solution.minWindow(s, t));
  }

}

