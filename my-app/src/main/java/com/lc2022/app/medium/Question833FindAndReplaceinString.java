package com.lc2022.app.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question833FindAndReplaceinString {
  public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
    Map<Integer, String> sourceMap = new HashMap<>();
    Map<Integer, String> targetMap = new HashMap<>();
    int n = indices.length;

    for(int i = 0; i < n; i++) {
      sourceMap.put(indices[i], sources[i]);
      targetMap.put(indices[i], targets[i]);
    }
    Arrays.sort(indices);
    StringBuilder sb = new StringBuilder();
    int pre = 0;
    String sStr = null;
    String tStr = null;
    for(int i : indices) {
      if (pre != i) {
        sb.append(s.substring(pre, i));
      }
      sStr = sourceMap.get(i);
      tStr = targetMap.get(i);
      if (s.substring(i, i + sStr.length()).equals(sStr)) {
        sb.append(tStr);
        pre = i + sStr.length();
      } else {
        pre = i;
      }
    }
    if (pre < s.length()) {
      sb.append(s.substring(pre));
    }

    return sb.toString();
  }
}
