package binarytrees.medium;

// O(n) && O(h)
public class LeetCodeLongestUniValuePath2 {

  // Definition for a binary tree node.
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

  public int longestUniValuePath = 0;

  public int longestUnivaluePath(TreeNode root) {
    dfs(root, -1);
    return longestUniValuePath;
  }

  public int dfs(TreeNode node, int parentNodeValue) {
    if (node == null) {
      return 0;
    }

    int leftChain = dfs(node.left, node.val);
    int rightChain = dfs(node.right, node.val);

    longestUniValuePath = Math.max(longestUniValuePath, leftChain + rightChain);

    return node.val == parentNodeValue ? 1 + Math.max(leftChain, rightChain) : 0;
  }
}
