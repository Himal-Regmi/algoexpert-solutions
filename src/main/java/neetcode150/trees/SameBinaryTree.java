package neetcode150.trees;

public class SameBinaryTree {
  /** Definition for a binary tree node. */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }
  }

  class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
        return true;
      } else if (p == null || q == null || p.val != q.val) {
        return false;
      }

      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
  }
}
