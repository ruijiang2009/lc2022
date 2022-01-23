package com.lc2022.app.util;

public class PrintUtil {
  public static void print2DIntArray(int[][] array) {
    for(int[] row : array) {
      for(int data : row) {
        System.out.print(String.format("%d\t", data));
      }
      System.out.print("\n");
    }
  }
}
