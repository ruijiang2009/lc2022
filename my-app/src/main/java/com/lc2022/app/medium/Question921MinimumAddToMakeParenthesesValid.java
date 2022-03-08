package com.lc2022.app.medium;

import java.util.Stack;

public class Question921MinimumAddToMakeParenthesesValid {
  public int minAddToMakeValid(String s) {
    Stack<Character> stack = new Stack<>();
    int count = 0;
    for(char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          count++;
          continue;
        }
        if (stack.peek() == '(') {
          stack.pop();
        }
      }
    }
    count += stack.size();
    return count;
  }
}
