package com.lc2022.app.hard;

import java.util.HashMap;

public class Question76MinimumWindowSubstring {

  public String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }
    HashMap<Character, Integer> targetMap = new HashMap<>();
    for (char c : t.toCharArray()) {
      targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
    }

    HashMap<Character, Integer> curMap = new HashMap<>();
    String result = "";
    int resultLength = Integer.MAX_VALUE;
    int left = 0;
    int right = 0;
    while(right < s.length()) {
      char c = s.charAt(right);
      if (targetMap.containsKey(c)) {
        curMap.put(c, curMap.getOrDefault(c, 0) + 1);
        if (covered(curMap, targetMap)) {
          while (covered(curMap, targetMap) && left < s.length()) {
            int newLength = right - left + 1;
            if (newLength < resultLength) {
              result = s.substring(left, right + 1);
              resultLength = result.length();
            }
            if (targetMap.containsKey(s.charAt(left))) {
              curMap.put(s.charAt(left), curMap.get(s.charAt(left)) - 1);
            }
            left++;
          }
          while(!targetMap.containsKey(s.charAt(left))) {
            left++;
          }
        }
      }
      right++;
    }
    return result;
  }

  private boolean covered(HashMap<Character, Integer> curMap, HashMap<Character, Integer> targetMap) {
    for(Character key : targetMap.keySet()) {
      if (targetMap.containsKey(key) && curMap.getOrDefault(key, 0) < targetMap.get(key)) {
        return false;
      }
    }
    return true;
  }
}
