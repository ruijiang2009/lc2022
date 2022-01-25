package com.lc2022.app.util;

import java.util.List;

public class PrintUtil {
  public static void print2DIntArray(int[][] array) {
    for(int[] row : array) {
      for(int data : row) {
        System.out.print(String.format("%d\t", data));
      }
      System.out.print("\n");
    }
  }

  public static void print2DIntList(List<List<Integer>> array) {
    for(List<Integer> row : array) {
      for(Integer data : row) {
        System.out.print(String.format("%d\t", data));
      }
      System.out.print("\n");
    }
  }
}
