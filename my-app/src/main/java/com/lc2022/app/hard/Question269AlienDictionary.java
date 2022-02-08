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

  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) {
      return "";
    }
    Map<Character, Node> graph = new HashMap<>();
    String pre = words[0];
    Node node = null;
    for(String word : words) {
      for(char c : word.toCharArray()) {
        graph.put(c, new Node(c));
      }
    }

    for(int i = 1; i < words.length; i++) {
      String cur = words[i];
      if (pre.length() > cur.length() && pre.startsWith(cur)) {
        return "";
      }
      for (int j = 0; j < Math.min(pre.length(), cur.length()); j++) {
        char preChar = pre.charAt(j);
        char curChar = cur.charAt(j);
        if (preChar == curChar) {
          node = graph.get (preChar);
          graph.put(preChar, node);
        } else {
          Node fromNode = graph.get(preChar);
          Node toNode = graph.get(curChar);
          if (!fromNode.neighbours.contains(curChar)) {
            fromNode.neighbours.add(curChar);
            toNode.indegree++;
          }
          graph.put(preChar, fromNode);
          graph.put(curChar, toNode);
          break;
        }
      }
      pre = cur;
    }

    StringBuilder sb = new StringBuilder();

    Queue<Node> queue = new LinkedList<>();

    int numberofNodes = graph.size();
    for(Node n : graph.values()) {
      if (n.indegree == 0) {
        node = n;
        queue.add(n);
      }
    }

    if (node == null) {
      return "";
    }

    while(!queue.isEmpty()) {
      node = queue.poll();
      sb.append(node.value);
      for(Character c : node.neighbours) {
        Node p = graph.get(c);
        p.indegree--;
        if (p.indegree == 0) {
          queue.add(p);
        }
      }
    }

    return sb.length() == numberofNodes ? sb.toString() : "";
  }
}
