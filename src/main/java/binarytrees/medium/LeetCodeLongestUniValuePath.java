package binarytrees.medium;

// O(n) && O(h)
public class LeetCodeLongestUniValuePath {

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
    dfs(root);
    return longestUniValuePath;
  }

  public int[] dfs(TreeNode node) {
    if (node == null) {
      return new int[2];
    }

    int[] leftChain = dfs(node.left);
    int[] rightChain = dfs(node.right);

    int currentNodeValueCount = 0;

    if (leftChain[0] == node.val && rightChain[0] == node.val) {
      currentNodeValueCount = leftChain[1] + rightChain[1];
      longestUniValuePath = Math.max(longestUniValuePath, currentNodeValueCount);
      return new int[] {node.val, Math.max(leftChain[1], rightChain[1]) + 1};
    } else if (leftChain[0] == node.val) {
      currentNodeValueCount += leftChain[1];
    } else if (rightChain[0] == node.val) {
      currentNodeValueCount += rightChain[1];
    }
    longestUniValuePath = Math.max(longestUniValuePath, currentNodeValueCount);
    return new int[] {node.val, currentNodeValueCount + 1};
  }
}
