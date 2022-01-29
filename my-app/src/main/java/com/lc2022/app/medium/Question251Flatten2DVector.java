package com.lc2022.app.medium;

public class Question251Flatten2DVector {
  private class Vector2D {
    int row = 0;
    int col = 0;
    int[][] vec = null;

    public Vector2D(int[][] vec) {
      this.vec = vec;
      // move row and col to the first valid position
      while(row < vec.length) {
        if (vec[row].length == 0) {
          row++;
        } else {
          break;
        }
      }
    }

    public int next() {
      int val = vec[row][col];
      if(col == vec[row].length-1) {
        row++;
        while(row < vec.length) {
          col = 0;
          if (vec[row].length == 0) {
            row++;
          } else {
            break;
          }
        }
        return val;
      } else {
        col++;
      }
      return val;
    }

    public boolean hasNext() {
      if (row < vec.length && col < vec[row].length) {
        return true;
      }
      return false;
    }
  }
}
