package com.lc2022.app.hard;

import java.util.*;

public class Question631DesignExcelSumFormula {

  static class Excel {
    Cell[][] table;

    public Excel(int height, char width) {
      table = new Cell[height+1][width+1];
    }

    public void set(int row, char column, int val) {
      if (table[row][column] == null) {
        table[row][column] = new Cell(val);
      } else {
        table[row][column].setValue(val);
      }
    }

    public int get(int row, char column) {
      return getValue(row, column);
    }

    public int sum(int row, char column, String[] numbers) {
      if (table[row][column] == null) {
        table[row][column] = new Cell(numbers);
      } else {
        table[row][column].setChildren(numbers);
      }
      return getValue(row, column);
    }

    private int getValue(int row, char column) {
      Cell cell = table[row][column];
      if (cell == null) {
        return 0;
      }
      if (cell.children.isEmpty()) {
        return cell.value;
      }
      HashMap<Point, Integer> record = new HashMap<>();
      List<Point> history = new ArrayList<>();

      Queue<Point> queue = new LinkedList<>();
      queue.add(new Point(row, column));
      while(!queue.isEmpty()) {
        Point p = queue.poll();
        history.add(p);
        Cell tCell = table[p.row][p.col];
        for(Point child : tCell.children) {
          Cell childCell = table[child.row][child.col];
          if (childCell == null) {
            record.put(child, 0);
          } else if (childCell.children.isEmpty()) {
            record.put(child, childCell.value);
          } else {
            queue.add(child);
          }
        }
      }

      int len = history.size();
      for(int i = len-1; i >= 0; i--) {
        Point p = history.get(i);
        int val = 0;
        for(Point child : table[p.row][p.col].children) {
          val += record.get(child);
        }
        record.put(p, val);
      }

      return record.get(new Point(row, column));
    }

    class Point {
      int row;
      char col;

      public Point(int row, char col) {
        this.row = row;
        this.col = col;
      }

      @Override
      public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
          return false;
        }
        Point other = (Point)obj;
        return other.row == this.row && other.col == this.col;
      }

      @Override
      public int hashCode() {
        return this.row * 26 + (int)this.col;
      }
    }

    class Cell {
      int value = 0;
      List<Point> children = new ArrayList<>();

      public Cell(int value) {
        this.value = value;
      }

      public Cell(String[] nums) {
        this.setChildren(nums);
      }

      public void setValue(int val) {
        this.children.clear();
        this.value = val;
      }

      public void setChildren(String[] nums) {
        this.children.clear();
        this.value = 0;
        for(String num : nums) {
          if (num.contains(":")) {
            int colonIdx = num.indexOf(':');
            String left = num.substring(0, colonIdx);
            char leftCol = left.charAt(0);
            int topRow = Integer.parseInt(left.substring(1));
            String right = num.substring(colonIdx+1);
            char rightCol = right.charAt(0);
            int bottomRow = Integer.parseInt(right.substring(1));
            for(int i = topRow; i <= bottomRow; i++) {
              for(char j = leftCol; j <= rightCol; j++) {
                children.add(new Point(i, j));
              }
            }

          } else {
            char col = num.charAt(0);
            int row = Integer.parseInt(num.substring(1));
            this.children.add(new Point(row, col));
          }
        }
      }
    }
  }

}
