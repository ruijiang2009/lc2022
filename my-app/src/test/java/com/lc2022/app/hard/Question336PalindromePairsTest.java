package com.lc2022.app.hard;

import org.junit.Test;

import java.util.List;

public class Question336PalindromePairsTest {
  Question336PalindromePairs solution = new Question336PalindromePairs();

  @Test
  public void test1() {
    String[] words = {"TAC","BAN","ON","NOON","BAT","LOLCAT","BIGCAT","LILCAT","OLCAT","STAC","ACAT","MACAT"};
    List<List<Integer>> result = solution.palindromePairs(words);
  }
}


