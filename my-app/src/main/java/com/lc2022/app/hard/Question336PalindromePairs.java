package com.lc2022.app.hard;

import java.util.*;

public class Question336PalindromePairs {
  class TrieNode {
    Character value;
    Map<Character, TrieNode> children = new HashMap<>();
    List<Integer> endIds = new ArrayList<>();
    List<Integer> palindromeSuffixIds = new ArrayList<>();
  }

  public boolean hasPalindromeRemaining(String s, int i) {
    int p1 = i;
    int p2 = s.length() - 1;
    while (p1 < p2) {
      if (s.charAt(p1) != s.charAt(p2)) return false;
      p1++;
      p2--;
    }
    return true;
  }

  public List<List<Integer>> palindromePairs(String[] words) {
    // construct TrieNode
    TrieNode root = new TrieNode();
    for(int wordId = 0; wordId < words.length; wordId++) {
      String word = words[wordId];
      String reverseWord = (new StringBuilder(word)).reverse().toString();
      TrieNode pre = root;
      for(int j = 0; j < reverseWord.length(); j++) {
        TrieNode cur = pre.children.getOrDefault(reverseWord.charAt(j), new TrieNode());
        cur.value = reverseWord.charAt(j);
        pre.children.put(cur.value, cur);
        if (j == reverseWord.length()-1) {
          cur.endIds.add(wordId);
        }
        if(hasPalindromeRemaining(reverseWord, j)) {
          pre.palindromeSuffixIds.add(wordId);
        }
        pre = cur;
      }
    }

    List<List<Integer>> result= new ArrayList<>();
    for(int wordId = 0; wordId < words.length; wordId++) {
      String word = words[wordId];
      if (word.length() == 0) {
        for(int id : root.palindromeSuffixIds) {
          if(id != wordId) {
            result.add(Arrays.asList(wordId, id));
            result.add(Arrays.asList(id, wordId));
          }
        }
        continue;
      }
      TrieNode pre = root;
      for(int j = 0; j < word.length(); j++) {
        if(pre == null) {
          continue;
        }
        TrieNode cur = pre.children.get(word.charAt(j));

        if (j == word.length()-1 && cur != null) {
          for(int id : cur.endIds) {
            if (id != wordId) {
              result.add(Arrays.asList(wordId, id));
            }
          }

          for(int id : cur.palindromeSuffixIds) {
            if (id != wordId) {
              result.add(Arrays.asList(wordId, id));
            }
          }
        }

        if (!pre.endIds.isEmpty() && hasPalindromeRemaining(word, j)) {
          for(int id : pre.endIds) {
            result.add(Arrays.asList(wordId, id));
          }
        }

        pre = cur;
      }
    }

    return result;
  }
}
