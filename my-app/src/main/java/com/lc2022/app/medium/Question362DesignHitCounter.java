package com.lc2022.app.medium;

import java.util.LinkedList;

public class Question362DesignHitCounter {
  class HitCounter {
    LinkedList<Integer> records = new LinkedList<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
      records.add(timestamp);
    }

    public int getHits(int timestamp) {
      while(!records.isEmpty() && timestamp >= records.peekFirst() + 300) {
        records.removeFirst();
      }
      return records.size();
    }
  }
}
