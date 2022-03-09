package com.lc2022.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question895MaximumFrequencyStackTest {
  Question895MaximumFrequencyStack solution = new Question895MaximumFrequencyStack();

  @Test
  public void test1() {
    Question895MaximumFrequencyStack.FreqStack stack = new Question895MaximumFrequencyStack.FreqStack();
    stack.push(5);
    stack.push(7);
    stack.push(5);
    stack.push(7);
    stack.push(4);
    stack.push(5);
    Assert.assertEquals(5, stack.pop());
    Assert.assertEquals(7, stack.pop());
    Assert.assertEquals(5, stack.pop());
    Assert.assertEquals(4, stack.pop());
  }
}
