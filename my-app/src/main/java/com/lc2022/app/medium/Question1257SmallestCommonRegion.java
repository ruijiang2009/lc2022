package com.lc2022.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question1257SmallestCommonRegion {
  public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
    Map<String, String> childToParentMap = new HashMap<>();
    for(List<String> row : regions) {
      String parent = row.get(0);
      for(int i = 1; i < row.size(); i++) {
        childToParentMap.put(row.get(i), parent);
      }
    }
    List<String> region1Ancesters = new ArrayList<>();
    region1Ancesters.add(0, region1);
    List<String> region2Ancesters = new ArrayList<>();
    region2Ancesters.add(0, region2);
    String r1 = region1;
    while(r1 != null) {
      r1 = childToParentMap.get(r1);
      if (r1 != null) {
        region1Ancesters.add(0, r1);
      } else {
        break;
      }
    }

    String r2 = region2;
    while(r2 != null) {
      r2 = childToParentMap.get(r2);
      if (r2 != null) {
        region2Ancesters.add(0, r2);
      } else {
        break;
      }
    }

    int len = Math.min(region1Ancesters.size(), region2Ancesters.size());
    int i = 0;
    for(; i < len; i++) {
      if(!region1Ancesters.get(i).equals(region2Ancesters.get(i))) {
        break;
      }
    }
    if (i == 0) {
      return null;
    }
    return region1Ancesters.get(i-1);
  }
}
