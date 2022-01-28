package com.lc2022.app.interval;

import org.junit.Assert;
import org.junit.Test;

public class Question253MeetingRoomsIITest {
  Question253MeetingRoomsII solution = new Question253MeetingRoomsII();
  @Test
  public void test1() {
    int[][] input = {{5,8},{6,8}};
    int result = solution.minMeetingRooms(input);
    Assert.assertEquals(2, result);
  }

  @Test
  public void test2() {
    int[][] input = {{6,17},{8,9},{11,12},{6,9}};
    int result = solution.minMeetingRooms(input);
    Assert.assertEquals(result, 3);
  }

  @Test
  public void test3() {
    int[][] input = {{0,30},{5,10},{15,20}};
    int result = solution.minMeetingRooms(input);
    Assert.assertEquals(result, 2);
  }
}
