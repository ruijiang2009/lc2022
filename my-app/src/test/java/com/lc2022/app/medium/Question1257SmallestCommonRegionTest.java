package com.lc2022.app.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Question1257SmallestCommonRegionTest {
  Question1257SmallestCommonRegion solution = new Question1257SmallestCommonRegion();

  @Test
  public void test1() {
    String [][] inputArray = {
            {"Earth","North America","South America"},
            {"North America","United States","Canada"},
            {"United States","New York","Boston"},
            {"Canada","Ontario","Quebec"},
            {"South America","Brazil"}};
    List<List<String>> input = new ArrayList<>();
    for(String[] row : inputArray) {
      List<String> rowList = new ArrayList<>();
      for(String str : row) {
        rowList.add(str);
      }
      input.add(rowList);
    }
    String r1 = "Quebec";
    String r2 = "New York";
    String result = solution.findSmallestRegion(input, r1, r2);
    Assert.assertEquals("North America", result);
  }
}
