package com.lc2022.app.medium;

import java.util.HashMap;
import java.util.Map;

public class Question1166DesignFileSystem {
  static class FileSystem {
    class FileNode {
      Map<String, FileNode> children = new HashMap<>();
      Integer value = null;
      public FileNode() {
      }
    }

    FileNode root;
    public FileSystem() {
      root = new FileNode();
    }

    public boolean createPath(String path, int value) {
      String[] segments = path.split("/");
      FileNode p = root;
      for(int i = 1; i < segments.length; i++) {
          if (p.children.containsKey(segments[i])) {
            p = p.children.get(segments[i]);
            if (i == segments.length-1) {
              if(p.value != null) {
                return false;
              } else {
                p.value = value;
              }
            }
          } else {
            if (i == segments.length-1) {
              FileNode newNode = new FileNode();
              newNode.value = value;
              p.children.put(segments[i], newNode);
              return true;
            } else {
              return false;
            }
          }
      }
      return false;
    }

    public int get(String path) {
      String[] segments = path.split("/");
      FileNode p = root;
      for(int i = 1; i < segments.length; i++) {
        if (p.children.containsKey(segments[i])) {
          p = p.children.get(segments[i]);
          if (i == segments.length-1) {
            if (p.value == null) {
              return -1;
            } else {
              return p.value;
            }
          }
        } else {
          return -1;
        }
      }
      return -1;
    }
  }
}
