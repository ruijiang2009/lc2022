package com.lc2022.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question269AlienDictionaryTest {
  Question269AlienDictionary solution = new Question269AlienDictionary();

  @Test
  public void test1() {
    String[] words = {"wrt","wrf","er","ett","rftt"};
    String output = solution.alienOrder(words);
    Assert.assertEquals("wertf", output);
  }

  @Test
  public void test2() {
    String[] words = {"z","x"};
    String output = solution.alienOrder(words);
    Assert.assertEquals("zx", output);
  }

  @Test
  public void test3() {
    String[] words = {"z","x", "z"};
    String output = solution.alienOrder(words);
    Assert.assertEquals("", output);
  }

  @Test
  public void test4() {
    String[] words = {"z", "z"};
    String output = solution.alienOrder(words);
    Assert.assertEquals("z", output);
  }

  @Test
  public void test5() {
    String[] words = {"zy", "zx"};
    String output = solution.alienOrder(words);
    Assert.assertEquals("yzz", output);
  }

  @Test
  public void test6() {
    String[] words = {"ab", "adc"};
    String output = solution.alienOrder(words);
    Assert.assertEquals("abcd", output);
  }

  @Test
  public void test7() {
    String[] words = {"ozvcdpgfq","mridvkklqj","dpwecbwor","xxtistijm","xxuon","tudbazpggu","hnuumktbjy","bogbcoi"};
    String output = solution.alienOrder(words);
    Assert.assertEquals("acefgijklnomdpqrsvwxthbuyz", output);
  }
}