package com.lc2022.app.interval;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question547NumberofProvinces {
  public int findCircleNum(int[][] isConnected) {
      Set<Integer> provinceIdSet = new HashSet<>();
      Map<Integer, Set<Integer>> provinceIdToNodeMap = new HashMap<>();
      Map<Integer, Integer> nodeToProvinceIdMap = new HashMap<>();
      int setId = 1;
      for(int row = 0; row < isConnected.length; row++) {
        for(int col = 0; col < isConnected[0].length; col++){
          if (isConnected[row][col] == 1) {
            int node1 = row;
            int node2 = col;
            int provinceId2 = -1;
            if (nodeToProvinceIdMap.containsKey(node2)) {
              provinceId2 = nodeToProvinceIdMap.get(node2);
            }
            int provinceId1 = -1;
            if (nodeToProvinceIdMap.containsKey(node1)) {
              provinceId1 = nodeToProvinceIdMap.get(node1);
            }
            if (provinceId1 == -1 && provinceId2 == -1) {
              provinceId1 = setId;
              setId++;
              provinceIdSet.add(provinceId1);
              Set<Integer> nodeSet = new HashSet<>();
              nodeSet.add(node1);
              nodeSet.add(node2);
              provinceIdToNodeMap.put(provinceId1, nodeSet);
              nodeToProvinceIdMap.put(node1, provinceId1);
              nodeToProvinceIdMap.put(node2, provinceId1);
            } else if (provinceId1 == -1 && provinceId2 != -1) {
              nodeToProvinceIdMap.put(node1, provinceId2);
              provinceIdToNodeMap.get(provinceId2).add(node1);
            } else if (provinceId1 != -1 && provinceId2 == -1) {
              nodeToProvinceIdMap.put(node2, provinceId1);
              provinceIdToNodeMap.get(provinceId1).add(node2);
            } else {
              if (provinceId2 != provinceId1) {
                provinceIdToNodeMap.get(provinceId1).addAll(provinceIdToNodeMap.get(provinceId2));
                for (Integer node : provinceIdToNodeMap.get(provinceId2)) {
                  nodeToProvinceIdMap.put(node, provinceId1);
                }
                provinceIdToNodeMap.remove(provinceId2);
                provinceIdSet.remove(provinceId2);
              }
            }

          }
        }
      }

      return provinceIdSet.size();
  }
}
