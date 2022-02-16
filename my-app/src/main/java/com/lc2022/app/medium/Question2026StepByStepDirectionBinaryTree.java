package com.lc2022.app.medium;

import com.lc2022.app.util.TreeNode;

public class Question2026StepByStepDirectionBinaryTree {
  public String getDirections(TreeNode root, int startValue, int destValue) {
    String startString = find(root, startValue, "");
    String destString = find(root, destValue, "");
    if (destString == null || startString == null) {
      return null;
    }
    int minLength = Math.min(startString.length(), destString.length());
    int rootIdx = 0;
    for(; rootIdx < minLength; rootIdx++) {
      if (destString.charAt(rootIdx) != startString.charAt(rootIdx)) {
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = rootIdx; i < startString.length(); i++) {
      sb.append("U");
    }
    sb.append(destString.substring(rootIdx));
    return sb.toString();
  }

  private String find(TreeNode node, int target, String records) {
    if (node.val == target) {
      return records;
    }
    String lResult = null;
    String rResult = null;
    if (node.left != null) {
      lResult = find(node.left, target, "L");
    }
    if (node.right != null) {
      rResult = find(node.right, target, "R");
    }
    if (lResult == null && rResult == null) {
      return null;
    }
    if (lResult == null) {
      return records+rResult;
    }
    if (rResult == null) {
      return records+lResult;
    }
    return null;
  }
}
