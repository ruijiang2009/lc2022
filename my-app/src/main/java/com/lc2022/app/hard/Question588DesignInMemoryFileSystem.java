package com.lc2022.app.hard;

import java.util.*;

public class Question588DesignInMemoryFileSystem {
  static class FileSystem {

    class Node {
      String value = null;
      Map<String, Node> children = new HashMap<String, Node>();

      public Node() {
      }

      public Node(String value) {
        this.value = value;
      }
    }

    Node root = new Node();
    public FileSystem() {

    }

    public List<String> ls(String path) {
      String[] paths = path.split("/");
      List<String> result = new ArrayList<>();
      Node p = root;
      if (paths.length == 0) {
        for(String key : p.children.keySet()) {
          result.add(key);
        }
        Collections.sort(result);
        return result;
      }
      for (int i = 1; i < paths.length; i++) {
        String segment = paths[i];
        Node child = p.children.get(segment);
        if (child == null) {
          return result;
        }
        if (i == paths.length-1) {
          if (child.value != null) {
            result.add(segment);
            return result;
          }
          List<String> keys = new ArrayList<>();
          keys.addAll(child.children.keySet());
          Collections.sort(keys);
          return keys;
        }
        p = child;
      }
      return result;
    }

    public void mkdir(String path) {
      String[] paths = path.split("/");
      Node p = root;
      for(int i = 1; i < paths.length; i++) {
        String segment = paths[i];
        Node child = p.children.getOrDefault(segment, new Node());
        p.children.put(segment, child);
        p = child;
      }
    }

    public void addContentToFile(String filePath, String content) {
      String[] paths = filePath.split("/");
      Node p = root;
      for (int i = 1; i < paths.length; i++) {
        String segment = paths[i];
        Node child = p.children.getOrDefault(segment, new Node());
        p.children.put(segment, child);
        if (i == paths.length-1) {
          child.value = child.value == null ? content: child.value + content;
        }
        p = child;
      }
    }

    public String readContentFromFile(String filePath) {
      String[] paths = filePath.split("/");
      Node p = root;
      for (int i = 1; i < paths.length; i++) {
        String segment = paths[i];
        Node child = p.children.get(segment);
        if (child == null) {
          return null;
        }
        if (i == paths.length-1) {
          return child.value;
        }
        p = child;
      }
      return null;
    }
  }

}
