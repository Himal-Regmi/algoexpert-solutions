package neetcode150.trees;

public class SubtreeOfAnotherTree {

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if (root == null) {
        return false;
      }

      if (areSameTree(root, subRoot)) {
        return true;
      }

      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean areSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
        return true;
      } else if (p == null || q == null || p.val != q.val) {
        return false;
      }
      return areSameTree(p.left, q.left) && areSameTree(p.right, q.right);
    }
  }
}
