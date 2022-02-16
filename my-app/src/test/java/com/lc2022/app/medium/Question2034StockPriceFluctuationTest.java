package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

public class Question2034StockPriceFluctuationTest {
  Question2034StockPriceFluctuation solution = new Question2034StockPriceFluctuation();

  @Test
  public void test1() {
    Question2034StockPriceFluctuation.StockPrice stockPrice = new Question2034StockPriceFluctuation.StockPrice();
    stockPrice.update(1,10);
    stockPrice.update(2,5);
    Assert.assertEquals(5, stockPrice.current());
    Assert.assertEquals(10, stockPrice.maximum());
    stockPrice.update(1,3);
    Assert.assertEquals(5, stockPrice.maximum());
    stockPrice.update(4,2);
    Assert.assertEquals(2, stockPrice.minimum());
  }

}
