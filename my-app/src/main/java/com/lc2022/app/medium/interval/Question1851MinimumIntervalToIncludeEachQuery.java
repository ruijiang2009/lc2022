package com.lc2022.app.medium.interval;

import java.util.*;

public class Question1851MinimumIntervalToIncludeEachQuery {
  public int[] minInterval(int[][] A, int[] queries) {
    Arrays.sort(A, new MyComparator());
    int[] sortedQueries = queries.clone();
    Arrays.sort(sortedQueries);
    HashMap<Integer, Integer> queryToSizeMap = new HashMap<>();

    TreeMap<Integer, Integer> sizeToEndMap = new TreeMap<>();
    int idx = 0;
    for(int query : sortedQueries) {
      while(idx < A.length && A[idx][0] <= query) {
        if (A[idx][1] >= query) {
          sizeToEndMap.put(A[idx][1] - A[idx][0] + 1, A[idx][1]);
        }
        idx++;
      }

      while(!sizeToEndMap.isEmpty() && sizeToEndMap.firstEntry().getValue() < query) {
        sizeToEndMap.pollFirstEntry();
      }

      if (!sizeToEndMap.isEmpty()) {
        queryToSizeMap.put(query, sizeToEndMap.firstEntry().getKey());
      } else {
        queryToSizeMap.put(query, -1);
      }
    }

    int[] result = new int[queries.length];
    for(int i = 0; i < queries.length; i++) {
      result[i] = queryToSizeMap.get(queries[i]);
    }

    return result;
  }

  class MyComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
      return a[0] - b[0];
    }
  }
}
