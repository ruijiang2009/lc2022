package com.lc2022.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question358RearrangeStringKDistanceApartTest {
  Question358RearrangeStringKDistanceApart solution = new Question358RearrangeStringKDistanceApart();

  @Test
  public void test1() {
    String s = "aabbcc";
    int k = 3;
    Assert.assertEquals("abcabc", solution.rearrangeString(s, k));
  }

  @Test
  public void test2() {
    String s = "aaabc";
    int k = 3;
    Assert.assertEquals("", solution.rearrangeString(s, k));
  }

  @Test
  public void test3() {
    String s = "aaabc";
    int k = 2;
    Assert.assertEquals("abaca", solution.rearrangeString(s, k));
  }
}
