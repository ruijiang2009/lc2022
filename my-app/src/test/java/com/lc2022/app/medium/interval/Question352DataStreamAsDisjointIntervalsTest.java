package com.lc2022.app.medium.interval;


import com.lc2022.app.util.PrintUtil;
import org.junit.Test;

public class Question352DataStreamAsDisjointIntervalsTest {
  Question352DataStreamAsDisjointIntervals solution = new Question352DataStreamAsDisjointIntervals();

  @Test
  public void test1() {
    Question352DataStreamAsDisjointIntervals.SummaryRanges sol =
        new Question352DataStreamAsDisjointIntervals.SummaryRanges();
    sol.addNum(1);
    sol.addNum(3);
    sol.addNum(7);
    sol.addNum(2);
    sol.addNum(6);
    PrintUtil.print2DIntArray(sol.getIntervals());
  }

  @Test
  public void test2() {
    Question352DataStreamAsDisjointIntervals.SummaryRanges sol =
        new Question352DataStreamAsDisjointIntervals.SummaryRanges();
    sol.addNum(6);
    PrintUtil.print2DIntArray(sol.getIntervals());
    sol.addNum(6);
    PrintUtil.print2DIntArray(sol.getIntervals());
    sol.addNum(0);
    PrintUtil.print2DIntArray(sol.getIntervals());
    sol.addNum(4);
    PrintUtil.print2DIntArray(sol.getIntervals());
    sol.addNum(8);
    PrintUtil.print2DIntArray(sol.getIntervals());
    sol.addNum(7);
    PrintUtil.print2DIntArray(sol.getIntervals());
    sol.addNum(6);
    PrintUtil.print2DIntArray(sol.getIntervals());
    sol.addNum(4);
    PrintUtil.print2DIntArray(sol.getIntervals());
    sol.addNum(7);
    PrintUtil.print2DIntArray(sol.getIntervals());
    sol.addNum(5);
    PrintUtil.print2DIntArray(sol.getIntervals());
  }

}
