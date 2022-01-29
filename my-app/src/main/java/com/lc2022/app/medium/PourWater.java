package com.lc2022.app.medium;

public class PourWater {
  public int[] pourWater(int[] heights, int volume, int k) {
    if (k == 0) {
      return heights;
    }
    for(int i = 0; i < volume; i++) {
      int left = k;
      int right = k;
      boolean putLeft = false;
      boolean putRight = false;
      // check left first
      while(left > 1) {
        if (heights[left-1] == heights[left]) {
          left--; // continue to search left
        } else if (heights[left-1] < heights[left]) {
          left--;
          heights[left] ++;
          putLeft = true;
          break;
        } else { // heights[left-1] > heights[left]
          break;
        }
      }

      if (!putLeft) {
        // check right first

        while (right < heights.length - 1) {
          if (heights[right + 1] == heights[right]) {
            right++;
          } else if (heights[right + 1] < heights[right]) {
            right++;
            heights[right]++;
            putRight = true;
            break;
          } else { // heights[right-1] > heights[right]
            break;
          }
        }
      }
      if (!putLeft && !putRight) {
        heights[k]++;
      }
    }
    return heights;
  }
}
