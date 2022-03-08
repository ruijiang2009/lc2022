package com.lc2022.app.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Question1197MinimumKnightMoves {
  class Point {
    int x;
    int y;
    int count = 0;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public Point(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }

    @Override
    public int hashCode() {
      return this.x * 300 + y;
    }

  }

  int[][] directions = { {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

  public int minKnightMoves(int x, int y) {
    Point p = new Point(0, 0);
    Queue<Point> queue = new LinkedList();
    queue.add(p);

    Set<Point> visited = new HashSet<>();
    visited.add(p);

    while(!queue.isEmpty()) {
      p = queue.poll();
      if (p.x == x && p.y == y) {
        return p.count;
      }
      for(int[] direction : directions) {
        Point newP = new Point(p.x + direction[0], p.y + direction[1], p.count+1);
        if (!visited.contains(newP)) {
          queue.add(newP);
          visited.add(newP);
        }
      }
    }
    return 0;
  }
}
