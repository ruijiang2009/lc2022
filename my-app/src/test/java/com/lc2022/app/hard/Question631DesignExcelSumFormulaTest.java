package com.lc2022.app.hard;

import org.junit.Assert;
import org.junit.Test;

public class Question631DesignExcelSumFormulaTest {
  Question631DesignExcelSumFormula solution = new Question631DesignExcelSumFormula();

  @Test
  public void test1() {
    Question631DesignExcelSumFormula.Excel excel = new Question631DesignExcelSumFormula.Excel(3, 'C');
    excel.set(1, 'A', 2);
    String[] nums = {"A1", "A1:B2"};
    Assert.assertEquals(4, excel.sum(3, 'C', nums));
    excel.set(2, 'B', 2);
    Assert.assertEquals(6, excel.get(3, 'C'));
  }

  @Test
  public void test2() {
    Question631DesignExcelSumFormula.Excel excel = new Question631DesignExcelSumFormula.Excel(3, 'C');
    Assert.assertEquals(0, excel.get(1, 'A'));
    excel.set(1, 'A', 1);
    Assert.assertEquals(1, excel.get(1, 'A'));
  }

  @Test
  public void test3() {
    Question631DesignExcelSumFormula.Excel excel = new Question631DesignExcelSumFormula.Excel(3, 'C');
    String[] nums = {"A2"};
    Assert.assertEquals(0, excel.sum(1, 'A', nums));
    excel.set(2, 'A', 1);

    String[] nums2 = {"A1"};
    Assert.assertEquals(1, excel.sum(3, 'A', nums2));
    Assert.assertEquals(1, excel.get(1, 'A'));
  }

  @Test
  public void test4() {
    Question631DesignExcelSumFormula.Excel excel = new Question631DesignExcelSumFormula.Excel(5, 'E');
    Assert.assertEquals(0, excel.get(1, 'A'));
    excel.set(1, 'A', 1);
    Assert.assertEquals(1, excel.get(1, 'A'));

    String[] nums = {"A1", "A1"};
    Assert.assertEquals(2, excel.sum(2, 'B', nums));


    String[] nums2 = {"A1"};
    Assert.assertEquals(1, excel.sum(2, 'B', nums2));
    Assert.assertEquals(1, excel.get(2, 'B'));
  }
}
