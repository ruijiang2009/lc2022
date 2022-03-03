package com.lc2022.app.hard;

import java.util.*;

public class Question358RearrangeStringKDistanceApart {
  public String rearrangeString(String s, int k) {
    HashMap<Character, Integer> charToNumMap = new HashMap<>();
    for(char c : s.toCharArray()) {
      int value = charToNumMap.getOrDefault(c, 0);
      value++;
      charToNumMap.put(c, value);
    }

    TreeMap<Integer, Set<Character>> frequencyToChars = new TreeMap<>();
    for(Character key : charToNumMap.keySet()) {
      Set<Character> chars = frequencyToChars.getOrDefault(charToNumMap.get(key), new HashSet<>());
      chars.add(key);
      frequencyToChars.put(charToNumMap.get(key), chars);
    }

    HashMap<Character, Integer> nextPos = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    int len = s.length();
    for(int i = 0; i < len; i++) {
      Character candidate = findCandidate(frequencyToChars, nextPos, i, k);
      if (candidate == null) {
        return "";
      } else {
        sb.append(candidate);
      }
    }
    return sb.toString();
  }

  private Character findCandidate(TreeMap<Integer, Set<Character>> frequencyToChars, HashMap<Character, Integer> nextPos, int curPos, int k) {
    Character candidate = null;
    Map<Integer, Set<Character>> records = new HashMap<>();
    while(!frequencyToChars.isEmpty()) {
      Integer key = frequencyToChars.lastKey();
      Map.Entry<Integer, Set<Character>> entry = frequencyToChars.pollLastEntry();
      for(Character c : entry.getValue()) {
        if (nextPos.containsKey(c)) {
          int next = nextPos.get(c);
          if (next <= curPos) {
            candidate = c;
            break;
          }
        } else {
          candidate = c;
          break;
        }
      }
      if (candidate != null) {
        entry.getValue().remove(candidate);
        if (!entry.getValue().isEmpty()) {
          frequencyToChars.put(key, entry.getValue());
        }
        if (key > 1) {
          Set<Character> newSet = frequencyToChars.getOrDefault(key-1, new HashSet<>());
          newSet.add(candidate);
          frequencyToChars.put(key - 1, newSet);
          nextPos.put(candidate, curPos + k);
        } else {
          nextPos.remove(candidate);
        }
        for(Integer item : records.keySet()) {
          frequencyToChars.put(item, records.get(item));
        }
        return candidate;
      }
      records.put(entry.getKey(), entry.getValue());
    }
    for(Integer key : records.keySet()) {
      frequencyToChars.put(key, records.get(key));
    }
    return null;
  }
}
