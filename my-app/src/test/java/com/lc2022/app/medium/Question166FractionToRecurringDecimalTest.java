package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question166FractionToRecurringDecimalTest {
  Question166FractionToRecurringDecimal solution = new Question166FractionToRecurringDecimal();

  @Test
  public void test1() {
    int numerator = 4;
    int denominator = 333;
    String result = solution.fractionToDecimal(numerator, denominator);
    Assert.assertEquals("0.(012)", result);
  }

  @Test
  public void test2() {
    int numerator = 2;
    int denominator = 1;
    String result = solution.fractionToDecimal(numerator, denominator);
    Assert.assertEquals("2", result);
  }

  @Test
  public void test3() {
    int numerator = 1;
    int denominator = 2;
    String result = solution.fractionToDecimal(numerator, denominator);
    Assert.assertEquals("0.5", result);
  }

  @Test
  public void test4() {
    int numerator = 1;
    int denominator = 333;
    String result = solution.fractionToDecimal(numerator, denominator);
    Assert.assertEquals("0.(003)", result);
  }

  @Test
  public void test5() {
    int numerator = 1;
    int denominator = 6;
    String result = solution.fractionToDecimal(numerator, denominator);
    Assert.assertEquals("0.1(6)", result);
  }

  @Test
  public void test6() {
    int numerator = -50;
    int denominator = 8;
    String result = solution.fractionToDecimal(numerator, denominator);
    Assert.assertEquals("-6.25", result);
  }

  @Test
  public void test7() {
    int numerator = -1;
    int denominator = -2147483648;
    String result = solution.fractionToDecimal(numerator, denominator);
    Assert.assertEquals("0.0000000004656612873077392578125", result);
  }

  @Test
  public void test8() {
    int numerator = -2147483648;
    int denominator = 1;
    String result = solution.fractionToDecimal(numerator, denominator);
    Assert.assertEquals("-2147483648", result);
  }

  @Test
  public void test9() {
    int numerator = 7;
    int denominator = -12;
    String result = solution.fractionToDecimal(numerator, denominator);
    Assert.assertEquals("-0.58(3)", result);
  }
}
