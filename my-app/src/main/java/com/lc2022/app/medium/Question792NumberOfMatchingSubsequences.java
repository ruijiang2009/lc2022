package com.lc2022.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question792NumberOfMatchingSubsequences {
  public int numMatchingSubseq(String s, String[] words) {
    Map<Character, List<String>> map = new HashMap<>();

    for(String word : words) {
      char firstChar= word.charAt(0);
      List<String> list = map.getOrDefault(firstChar, new ArrayList<>());
      list.add(word);
      map.put(firstChar, list);
    }

    int count = 0;
    for(int i = 0; i < s.length();i++) {
      char curChar = s.charAt(i);
      List<String> candidates = map.get(curChar);
      map.remove(curChar);
      if (candidates != null) {
        for(String str : candidates) {
          str = str.substring(1);
          if (str.equals("")) {
            count++;
          } else {
            char firstChar = str.charAt(0);
            List<String> list = map.getOrDefault(firstChar, new ArrayList<>());
            list.add(str);
            map.put(firstChar, list);
          }
        }
      }
    }
    return count;
  }

}
