package com.lc2022.app.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class Question295FindMedianFromDataStream {
  static class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {

    }

    public void addNum(int num) {
      if (maxHeap.isEmpty() && minHeap.isEmpty()) {
        minHeap.add(num);
        return;
      }
      if (maxHeap.isEmpty()) {
        if (num < minHeap.peek()) {
          maxHeap.add(num);
        } else {
          maxHeap.add(minHeap.poll());
          minHeap.add(num);
        }
        return;
      }
      if (minHeap.isEmpty()) {
        if (num > maxHeap.peek()) {
          minHeap.add(num);
        } else {
          minHeap.add(maxHeap.poll());
          maxHeap.add(num);
        }
        return;
      }
      if (num > minHeap.peek()) {
        minHeap.add(num);
      } else {
        maxHeap.add(num);
      }
      if (minHeap.size() > maxHeap.size()+1) {
        maxHeap.add(minHeap.poll());
      } else if (maxHeap.size() > minHeap.size()+1) {
        minHeap.add(maxHeap.poll());
      }

    }

    public double findMedian() {
      if (minHeap.size() == maxHeap.size()) {
        return ((double)(minHeap.peek() + maxHeap.peek()))/2.0;
      } else if (minHeap.size() > maxHeap.size()) {
        return minHeap.peek();
      } else {
        return maxHeap.peek();
      }
    }
  }

}
