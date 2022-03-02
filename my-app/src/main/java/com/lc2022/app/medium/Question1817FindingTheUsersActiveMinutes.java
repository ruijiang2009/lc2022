package com.lc2022.app.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question1817FindingTheUsersActiveMinutes {
  public int[] findingUsersActiveMinutes(int[][] logs, int k) {
    HashMap<Integer, Set<Integer>> userIdToMinutesMap = new HashMap<>();
    for(int[] log : logs) {
      int user = log[0];
      int minute = log[1];
      Set<Integer> activeMinutes = userIdToMinutesMap.getOrDefault(user, new HashSet<>());
      activeMinutes.add(minute);
      userIdToMinutesMap.put(user, activeMinutes);
    }
    int[] result = new int[k];
    for(Integer userId : userIdToMinutesMap.keySet()) {
      Set<Integer> minutes = userIdToMinutesMap.get(userId);
      result[minutes.size()-1]++;
    }
    return result;
  }
}
