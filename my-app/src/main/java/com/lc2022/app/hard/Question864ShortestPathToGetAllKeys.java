package com.lc2022.app.hard;

import java.util.*;

public class Question864ShortestPathToGetAllKeys {
  class Status {
    Set<Character> keys = new HashSet<>();
    int row = -1;
    int col = -1;
    int steps = 0;

    public Status(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public boolean equals(Object status) {
      Status other = (Status)status;
      for (Character k : other.keys) {
        if (!this.keys.contains(k)) {
          return false;
        }
      }
      for (Character k : this.keys) {
        if (!other.keys.contains(k)) {
          return false;
        }
      }

      return this.row == other.row && this.col == other.col;
    }

    @Override
    public int hashCode() {
      Character[] keys = new Character[this.keys.size()];
      this.keys.toArray(keys);
      Arrays.sort(keys);
      int hash = row * 30 + col;
      int sum = 0;
      for(Character k : keys) {
        sum *= 10;
        sum += (k - 'a') + 1;
      }
      return sum + hash;
    }
  }

  private boolean isKey(char c) {
    return c >= 'a' && c <= 'f';
  }

  private boolean isDoor(char c) {
    return c >= 'A' && c <= 'F';
  }

  private char toKey(char door) {
    return (char)(door - 'A' + 'a');
  }

  public int shortestPathAllKeys(String[] grid) {
    final char WALL = '#';
    final char EMPTY = '.';
    final char START = '@';

    int height = grid.length;
    int width = grid[0].length();

    // 1 find start
    int startRow = -1;
    int startCol = -1;
    char[][] matrix = new char[height][width];
    Set<Character> keys = new HashSet<>();
    for (int row = 0; row < grid.length; row++) {
      char[] rowArray = grid[row].toCharArray();
      for (int col = 0; col < grid[row].length(); col++) {
        if (rowArray[col] == START) {
          startRow = row;
          startCol = col;
        } else if (isKey(rowArray[col])) {
          keys.add(rowArray[col]);
        }
        matrix[row][col] = rowArray[col];
      }
    }

    Set<Status> visited = new HashSet<>();
    Queue<Status> queue = new LinkedList<>();
    int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int result = Integer.MAX_VALUE;
    Status s = new Status(startRow, startCol);
    queue.add(s);
    visited.add(s);
    Status nextStatus;
    while(!queue.isEmpty()) {
      s = queue.poll();
      System.out.println(String.format("row: %d col: %d", s.row, s.col));
      if (s.keys.size() == keys.size()) {
        result = Math.min(result, s.steps);
      }
      char next;
      for(int[] direction : directions) {
        int newRow = s.row + direction[0];
        int newCol = s.col + direction[1];
        if ((newRow >= 0 && newRow < height) && (newCol >= 0 && newCol < width)) {
          next = matrix[newRow][newCol];
        } else {
          continue;
        }
        if (next == WALL) {
          continue;
        }
        nextStatus = new Status(newRow, newCol);
        nextStatus.keys.addAll(s.keys);
        nextStatus.steps = s.steps+1;
        if (isKey(next)) {
          if (!s.keys.contains(next)) {
            nextStatus.keys.add(next);
          }
        } else if (isDoor(next)) {
          char keyNeeded = toKey(next);
          if (!s.keys.contains(keyNeeded)) {
            continue;
          }
        }
        if (!visited.contains(nextStatus)) {
          visited.add(nextStatus);
          queue.add(nextStatus);
        }
      }
    }

    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
