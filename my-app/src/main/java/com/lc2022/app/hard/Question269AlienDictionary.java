package com.lc2022.app.hard;

import java.util.*;

public class Question269AlienDictionary {
  class Node implements Comparable<Node>{
    Character value;
    Integer indegree = 0;
    Set<Character> neighbours = new HashSet<>();
    public Node(Character value) {
      this.value = value;
    }

    @Override
    public int compareTo(Node o) {
      return this.indegree.compareTo(o.indegree);
    }
  }

  private Map<Character, List<String>> updateEdges(List<String> words, Map<Character, Node> graph) {
    String pre = words.get(0);
    Map<Character, List<String>> newGroups = new HashMap<>();
    if(pre.length() > 1) {
      List<String> group = new ArrayList<>();
      group.add(pre.substring(1));
      newGroups.put(pre.charAt(0), group);
    }
    for(int i =1; i < words.size(); i++) {
      String cur = words.get(i);
      if(cur.length() > 1) {
        List<String> group = newGroups.getOrDefault(cur.charAt(0), new ArrayList<>());
        group.add(cur.substring(1));
        newGroups.put(cur.charAt(0), group);
      }
      if (pre.length() >= 1 && cur.length() >= 1) {
        if (pre.charAt(0) != cur.charAt(0)) {
          Node fromNode = graph.getOrDefault(pre.charAt(0), new Node(pre.charAt(0)));
          Node toNode = graph.getOrDefault(cur.charAt(0), new Node(cur.charAt(0)));
          fromNode.neighbours.add(cur.charAt(0));
          toNode.indegree++;
          graph.put(pre.charAt(0), fromNode);
          graph.put(cur.charAt(0), toNode);
        }
      }
    }
    return newGroups;
  }

  public String alienOrder(String[] words) {
    Map<Character, Node> graph = new HashMap<>();
    List<String> wordList = Arrays.asList(words);
    Queue<Map<Character, List<String>>> records = new LinkedList<>();
    Map<Character, List<String>> newGroups = updateEdges(wordList, graph);
    records.add(newGroups);
    while(!records.isEmpty()) {
      Map<Character, List<String>> group = records.poll();
      for(Character key : group.keySet()) {
        wordList = newGroups.get(key);
        Map<Character, List<String>> newGroup = updateEdges(wordList, graph);
        if(!newGroup.isEmpty()) {
          records.add(newGroup);
        }
      }
    }
    int nodeNumber = graph.keySet().size();
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.addAll(graph.values());

    StringBuilder sb = new StringBuilder();
    while(!pq.isEmpty()) {
      Node node = pq.poll();
      if (0 == node.indegree) {
        sb.append(node.value);
        for(Character c : node.neighbours) {
          Node p = graph.get(c);
          p.indegree--;
        }
      }
    }
    return sb.length() == nodeNumber ? sb.toString() : "";
  }
}
