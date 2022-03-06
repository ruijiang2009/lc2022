package com.lc2022.app.medium;

public class Question79WordSearch {
  public boolean exist(char[][] board, String word) {
    int height = board.length;
    int width = board[0].length;
    for(int row = 0; row < height; row++) {
      for(int col = 0; col < width; col++) {
        if (find(board, word, 0, row, col)) {
          return true;
        }
      }
    }
    return false;
  }

  static int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
  private boolean find(char[][] board, String word, int start, int row, int col) {
    int height = board.length;
    int width = board[0].length;
    if (board[row][col] != word.charAt(start)) {
      return false;
    }
    if (board[row][col] == word.charAt(start) && start == word.length()-1) {
      return true;
    }
    board[row][col] = '#';
    for(int[] direction : directions) {
      int newRow = row + direction[0];
      int newCol = col + direction[1];
      if ((newRow >=0 && newRow < height) && (newCol >= 0 && newCol < width) && start < word.length()-1) {
        if (find(board, word, start+1, newRow, newCol)) {
          return true;
        }
      }
    }
    board[row][col] = word.charAt(start);
    return false;
  }
}
