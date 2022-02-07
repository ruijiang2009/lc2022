package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question322CoinChangeTest {
  Question322CoinChange solution = new Question322CoinChange();

  @Test
  public void test1() {
    int[] coins = {1,2,5};
    int amount = 11;
    int ret = solution.coinChange(coins, amount);
    Assert.assertEquals(3, ret);
  }

  @Test
  public void test2() {
    int[] coins = {2};
    int amount = 3;
    int ret = solution.coinChange(coins, amount);
    Assert.assertEquals(-1, ret);
  }

  @Test
  public void test3() {
    int[] coins = {2};
    int amount = 0;
    int ret = solution.coinChange(coins, amount);
    Assert.assertEquals(0, ret);
  }

  @Test
  public void test4() {
    int[] coins = {1};
    int amount = 0;
    int ret = solution.coinChange(coins, amount);
    Assert.assertEquals(-1, ret);
  }
}
