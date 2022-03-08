package com.lc2022.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1868ProductOfTwoRunLengthEncodedArrays {
  public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
    int len1 = encoded1.length;
    int len2 = encoded2.length;
    int p1 = 0;
    int p2 = 0;
    List<List<Integer>> result = new ArrayList<>();
    while(p1 < len1 && p2 < len2) {
      int[] item1 = encoded1[p1];
      int item1Value = item1[0];
      int item1Len = item1[1];
      int[] item2 = encoded2[p2];
      int item2Value = item2[0];
      int item2Len = item2[1];

      List<Integer> item = new ArrayList<>();
      if (item1Len == item2Len) {
        item.add(item1Value * item2Value);
        item.add(item1Len);
        p1++;
        p2++;
      } else if (item1Len < item2Len) {
        item.add(item1Value * item2Value);
        item.add(item1Len);
        item2[1] = item2Len - item1Len;
        p1++;
      } else { // item1 > item2Len
        item.add(item1Value * item2Value);
        item.add(item2Len);
        item1[1] = item1Len - item2Len;
        p2++;
      }
      if (result.isEmpty()) {
        result.add(item);
      } else {
        List<Integer> lastItem = result.get(result.size()-1);
        if (lastItem.get(0).equals(item.get(0))) {
          lastItem.set(1, lastItem.get(1) + item.get(1));
        } else {
          result.add(item);
        }
      }
    }
    return result;
  }

  public List<List<Integer>> findRLEArray2(int[][] encoded1, int[][] encoded2) {
    int p1 = 0, p2=0;
    List<List<Integer>> res = new ArrayList<>();

    while(p1 < encoded1.length) {
      int len = Math.min(encoded1[p1][1], encoded2[p2][1]);
      int mult = encoded1[p1][0] * encoded2[p2][0];

      if(res.size() > 0 && res.get(res.size()-1).get(0) == mult) //to handle cases like [[1,3],[2,3]] * [[6,3],[3,3]] --> [[6,6]]
        res.get(res.size()-1).set(1, res.get(res.size()-1).get(1)+len); //update previous mult in res instead of adding a new one
      else
        res.add(Arrays.asList(mult, len));

      encoded1[p1][1] -= len;
      encoded2[p2][1] -= len;
      if(encoded1[p1][1] == 0) p1++;
      if(encoded2[p2][1] == 0) p2++;
    }
    return res;
  }
}
