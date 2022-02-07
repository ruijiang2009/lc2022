package com.lc2022.app.hard;

import com.lc2022.app.util.PrintUtil;
import org.junit.Test;

import java.util.List;

public class Question336PalindromePairsTest {
  Question336PalindromePairs solution = new Question336PalindromePairs();

  @Test
  public void test1() {
    String[] words = {"TAC","BAN","ON","NOON","BAT","LOLCAT","BIGCAT","LILCAT","OLCAT","STAC","ACAT","MACAT"};
    List<List<Integer>> result = solution.palindromePairs(words);
    PrintUtil.print2DIntList(result);
  }

  @Test
  public void test2() {
    String[] words = {"abcd","dcba","lls","s","sssll"};
    List<List<Integer>> result = solution.palindromePairs(words);
    PrintUtil.print2DIntList(result);
  }

  @Test
  public void test() {
    String[] words = {"a",""};
    List<List<Integer>> result = solution.palindromePairs(words);
    PrintUtil.print2DIntList(result);
  }

  @Test
  public void test3() {
    String[] words = {"a","abc","aba",""};
    List<List<Integer>> result = solution.palindromePairs(words);
    PrintUtil.print2DIntList(result);
  }
}
