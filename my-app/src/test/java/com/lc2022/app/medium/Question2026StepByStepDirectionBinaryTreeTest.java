package com.lc2022.app.medium;

import com.lc2022.app.util.TreeNode;
import org.junit.Test;

public class Question2026StepByStepDirectionBinaryTreeTest {
  Question2026StepByStepDirectionBinaryTree solution = new Question2026StepByStepDirectionBinaryTree();

  @Test
  public void test1() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(3);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(4);
    String result = solution.getDirections(root, 3, 6);
    System.out.println("result " + result);
  }
}
