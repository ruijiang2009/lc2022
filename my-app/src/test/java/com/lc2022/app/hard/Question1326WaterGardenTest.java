package com.lc2022.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question1326WaterGardenTest {
  Question1326WaterGarden solution = new Question1326WaterGarden();
  @Test
  public void test1() {
    int n = 5;
    int[] ranges = {3,4,1,1,0,0};
    Assert.assertEquals(1, solution.minTaps(n, ranges));

  }
}
