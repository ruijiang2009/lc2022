package com.lc2022.app.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Question773SlidingPuzzle {
  class Status {
    String up;
    String down;
    int steps;

    public Status(String up, String down, int steps) {
      this.up = up;
      this.down = down;
      this.steps = steps;
    }

    @Override
    public boolean equals(Object other) {
      Status o = (Status)other;
      return this.up.equals(o.up) && this.down.equals(o.down);
    }

    @Override
    public int hashCode() {
      return Integer.parseInt(this.up+this.down);
    }
  }

  public int slidingPuzzle(int[][] board) {
    Queue<Status> queue = new LinkedList<>();
    Set<Status> visited = new HashSet<>();
    Status finalStatus = new Status("123", "450", -1);
    Status start = new Status(
            String.format("%d%d%d", board[0][0], board[0][1], board[0][2]),
            String.format("%d%d%d", board[1][0], board[1][1], board[1][2]),
            0);
    visited.add(start);
    queue.add(start);
    int result = Integer.MAX_VALUE;
    while(!queue.isEmpty()) {
      Status cur = queue.poll();
      if (cur.equals(finalStatus)) {
        result = Math.min(result, cur.steps);
      }
      Status up = goUp(cur);
      if (up != null && !visited.contains(up)) {
        visited.add(up);
        queue.add(up);
      }
      Status down = goDown(cur);
      if (down != null && !visited.contains(down)) {
        visited.add(down);
        queue.add(down);
      }
      Status left = goLeft(cur);
      if (left != null && !visited.contains(left)) {
        visited.add(left);
        queue.add(left);
      }
      Status right = goRight(cur);
      if (right != null && !visited.contains(right)) {
        visited.add(right);
        queue.add(right);
      }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private Status goUp(Status status) {
    if(status.up.contains("0")) {
      return null;
    }
    int zeroIdx = status.down.indexOf('0');
    char[] upArray = status.up.toCharArray();
    char[] downArray = status.down.toCharArray();
    downArray[zeroIdx] = upArray[zeroIdx];
    upArray[zeroIdx] = '0';
    return new Status(new String(upArray), new String(downArray), status.steps+1);
  }

  private Status goDown(Status status) {
    if(status.down.contains("0")) {
      return null;
    }
    int zeroIdx = status.up.indexOf('0');
    char[] upArray = status.up.toCharArray();
    char[] downArray = status.down.toCharArray();
    upArray[zeroIdx] = downArray[zeroIdx];
    downArray[zeroIdx] = '0';
    return new Status(new String(upArray), new String(downArray), status.steps+1);
  }

  private Status goLeft(Status status) {
    if(status.down.charAt(0) == '0' || status.up.charAt(0) == '0') {
      return null;
    }
    char[] upArray = status.up.toCharArray();
    char[] downArray = status.down.toCharArray();
    if (status.down.contains("0")) {
      int zeroIdx = status.down.indexOf('0');
      downArray[zeroIdx] = downArray[zeroIdx-1];
      downArray[zeroIdx-1] = '0';
    } else {
      int zeroIdx = status.up.indexOf('0');
      upArray[zeroIdx] = upArray[zeroIdx-1];
      upArray[zeroIdx-1] = '0';
    }
    return new Status(new String(upArray), new String(downArray), status.steps+1);
  }

  private Status goRight(Status status) {
    if(status.down.charAt(2) == '0' || status.up.charAt(2) == '0') {
      return null;
    }
    char[] upArray = status.up.toCharArray();
    char[] downArray = status.down.toCharArray();
    if (status.down.contains("0")) {
      int zeroIdx = status.down.indexOf('0');
      downArray[zeroIdx] = downArray[zeroIdx+1];
      downArray[zeroIdx+1] = '0';
    } else {
      int zeroIdx = status.up.indexOf('0');
      upArray[zeroIdx] = upArray[zeroIdx+1];
      upArray[zeroIdx+1] = '0';
    }
    return new Status(new String(upArray), new String(downArray), status.steps+1);
  }
}
