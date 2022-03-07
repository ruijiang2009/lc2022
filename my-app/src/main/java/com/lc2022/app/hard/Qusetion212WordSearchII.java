package com.lc2022.app.hard;

import com.lc2022.app.util.TreeNode;


import java.util.*;

public class Qusetion212WordSearchII {
  class TrieNode {
    Character value;
    HashMap<Character, TrieNode> children = new HashMap<>();
    List<String> words = new ArrayList<>();

    public TrieNode() {
      this.value = null;
    }

    public TrieNode(char c) {
      this.value = c;
    }
  }


  public List<String> findWords(char[][] board, String[] words) {
    TrieNode trie = constructTrie(words);
    int height = board.length;
    int width = board[0].length;
    Set<String> result = new HashSet<>();

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        Set<String> tmps = trace(board, trie, row, col);
        result.addAll(tmps);
      }
    }

    return new ArrayList<>(result);
  }

  private TrieNode constructTrie(String[] words) {
    TrieNode root = new TrieNode();

    for(String word : words) {
      TrieNode p = root;
      for(int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        TrieNode child = p.children.getOrDefault(c, new TrieNode(c));
        p.children.put(c, child);
        if (i == word.length()-1) {
          child.words.add(word);
        }
        p = child;
      }
    }
    return root;
  }

  private Set<String> trace(char[][] board, TrieNode parent, int row, int col) {
    int height = board.length;
    int width = board[0].length;
    char c = board[row][col];
    TrieNode child = parent.children.get(c);
    Set<String> result = new HashSet<>();
    if (child == null) {
      return result;
    }
    result.addAll(child.words);
    child.words.clear(); // remove words to reduce duplicates
    int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right

    board[row][col] = '#';

    for(int[] direction : directions) {
      int newRow = row + direction[0];
      int newCol = col + direction[1];
      if ((newRow >= 0 && newRow < height) && (newCol >= 0 && newCol < width)) {
        Set<String> tmp = trace(board, child, newRow, newCol);
        result.addAll(tmp);
      }
    }

    board[row][col] = c;
    return result;
  }
}
