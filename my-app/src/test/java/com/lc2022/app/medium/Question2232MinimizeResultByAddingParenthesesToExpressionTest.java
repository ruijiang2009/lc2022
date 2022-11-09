package com.lc2022.app.medium;

import org.junit.Test;

public class Question2232MinimizeResultByAddingParenthesesToExpressionTest {
  Question2232MinimizeResultByAddingParenthesesToExpression solution =
      new Question2232MinimizeResultByAddingParenthesesToExpression();

  @Test
  public void test1() {
    String input = "247+38";
    String output = solution.minimizeResult(input);
    System.out.println(output);
  }

  @Test
  public void test2() {
    String input = "999+999";
    String output = solution.minimizeResult(input);
    System.out.println(output);
  }
}
