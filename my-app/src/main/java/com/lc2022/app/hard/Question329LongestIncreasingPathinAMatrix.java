package com.lc2022.app.hard;

public class Question329LongestIncreasingPathinAMatrix {
  int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  public int longestIncreasingPath(int[][] matrix) {
    int height = matrix.length;
    int width = matrix[0].length;
    int[][] opt = new int[height][width];

    int max = 0;
    for(int row = 0; row < height; row++) {
      for(int col = 0; col < width; col++) {
        if (opt[row][col] == 0) {
          opt[row][col] = dfs(matrix, opt, row, col, height, width);
        }
        max = Math.max(max, opt[row][col]);
      }
    }


    return max;
  }

  private int dfs(int[][] matrix, int[][] opt, int row, int col, int height, int width) {
    if (opt[row][col] != 0) {
      return opt[row][col];
    }
    int max = 0;
    for(int[] direction : directions) {
      int newRow = row + direction[0];
      int newCol = col + direction[1];

      if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width && matrix[newRow][newCol] > matrix[row][col]) {
        max = Math.max(max, 1 + dfs(matrix, opt, newRow, newCol, height, width));
      }
    }
    if (max == 0) {
      opt[row][col] = 1;
    } else {
      opt[row][col] = max;
    }
    return opt[row][col];
  }

}
