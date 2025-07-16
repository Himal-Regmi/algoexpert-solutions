package binarytrees.hard;

// O(n) && O(h)
public class MaxPathSum {
  static int maxPathSum = Integer.MIN_VALUE;

  public static int maxPathSum(BinaryTree tree) {
    maxPathSum = Integer.MIN_VALUE;
    dfs(tree);
    return maxPathSum;
  }

  public static int dfs(BinaryTree node) {
    if (node == null) return 0;

    // Get left and right max path sum; ignore negative paths
    int leftMaxPath = Math.max(dfs(node.left), 0);
    int rightMaxPath = Math.max(dfs(node.right), 0);

    int currentPathSum = node.value + leftMaxPath + rightMaxPath;

    maxPathSum = Math.max(maxPathSum, currentPathSum);

    return node.value + Math.max(leftMaxPath, rightMaxPath);
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
