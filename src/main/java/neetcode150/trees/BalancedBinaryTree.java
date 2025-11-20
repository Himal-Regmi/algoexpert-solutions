package neetcode150.trees;

public class BalancedBinaryTree {
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
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
      dfs(root);
      return isBalanced;
    }

    public int dfs(TreeNode node) {
      if (node == null) {
        return 0;
      }
      int leftHeight = dfs(node.left);
      int rightHeight = dfs(node.right);

      isBalanced = isBalanced && Math.abs(leftHeight - rightHeight) <= 1;

      return 1 + Math.max(leftHeight, rightHeight);
    }
  }
}
