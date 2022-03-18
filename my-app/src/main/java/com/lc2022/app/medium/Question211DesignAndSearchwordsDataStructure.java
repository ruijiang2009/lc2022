package com.lc2022.app.medium;

public class Question211DesignAndSearchwordsDataStructure {


  static class WordDictionary {
    class TrieNode {
      TrieNode[] children = new TrieNode[26];
      String text = "";

    }
    TrieNode root = null;
    public WordDictionary() {
      root = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode parent = root;
      for(int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (parent.children[c - 'a'] == null) {
          parent.children[c - 'a'] = new TrieNode();
        }
        parent = parent.children[c - 'a'];
        if (i == word.length()-1) {
          parent.text = word;
        }
      }
    }

    public boolean search(String word) {
      return search(word, root, 0);
    }

    private boolean search(String word, TrieNode parent, int startIdx) {
      if (startIdx >= word.length()) {
        return false;
      }
      char c = word.charAt(startIdx);
      if (c == '.') {
        if (startIdx == word.length()-1) {
          for(TrieNode node : parent.children) {
            if (node != null && !node.text.equals("")) {
              return true;
            }
          }
          return false;
        }
        for(TrieNode node : parent.children) {
          if (node != null && search(word, node, startIdx+1)) {
            return true;
          }
        }
      } else {
        if (parent.children[c - 'a'] == null) {
          return false;
        }
        if (startIdx == word.length()-1 && !parent.children[c - 'a'].text.equals("")) {
          return true;
        }
        return search(word, parent.children[c - 'a'], startIdx+1);
      }
      return false;
    }
  }

}
