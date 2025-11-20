package neetcode150.trees;

public class DiameterOfBinaryTree {
  /** Definition for a binary tree node. */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  class Solution {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
      depthOfBinaryTreeNode(root);
      return maxDiameter;
    }

    public int depthOfBinaryTreeNode(TreeNode node) {
      if (node == null) {
        return 0;
      }
      int leftDepth = depthOfBinaryTreeNode(node.left);
      int rightDepth = depthOfBinaryTreeNode(node.right);

      maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
      return Math.max(leftDepth, rightDepth) + 1;
    }
  }
}
