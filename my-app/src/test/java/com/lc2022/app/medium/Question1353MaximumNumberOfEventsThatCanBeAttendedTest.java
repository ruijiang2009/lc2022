package com.lc2022.app.medium;

import com.lc2022.app.interval.Question1353MaximumNumberOfEventsThatCanBeAttended;
import org.junit.Assert;
import org.junit.Test;

public class Question1353MaximumNumberOfEventsThatCanBeAttendedTest {
  Question1353MaximumNumberOfEventsThatCanBeAttended solution = new Question1353MaximumNumberOfEventsThatCanBeAttended();

  @Test
  public void test1() {
    int[][] events = {{1,2},{2,3},{3,4}};
    Assert.assertEquals(3, solution.maxEvents(events));
  }
}
