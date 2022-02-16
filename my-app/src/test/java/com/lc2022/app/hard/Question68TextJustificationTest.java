package com.lc2022.app.hard;

import com.lc2022.app.util.PrintUtil;
import org.junit.Test;

import java.util.List;

public class Question68TextJustificationTest {
  Question68TextJustification solution = new Question68TextJustification();

  @Test
  public void test1() {
    String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    int maxWidth = 16;
    List<String> output = solution.fullJustify(words, maxWidth);
    PrintUtil.printStrList(output);
  }

  @Test
  public void test2() {
    String[] words = {"Listen","to","many,","speak","to","a","few."};
    int maxWidth = 6;
    List<String> output = solution.fullJustify(words, maxWidth);
    PrintUtil.printStrList(output);
  }

  @Test
  public void test3() {
    String[] words = {"a"};
    int maxWidth = 1;
    List<String> output = solution.fullJustify(words, maxWidth);
    PrintUtil.printStrList(output);
  }
}
