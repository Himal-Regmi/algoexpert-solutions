package binarytrees.medium;

// O(n) && O(h)
public class LeetCodeBinaryTreeTilt {
  static class TreeNode {
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

  private int totalTilt = 0;

  public int findTilt(TreeNode root) {
    valueSum(root);
    return totalTilt;
  }

  public int valueSum(TreeNode treeNode) {
    if (treeNode == null) {
      return 0;
    }

    int leftSum = valueSum(treeNode.left);
    int rightSum = valueSum(treeNode.right);

    int tilt = Math.abs(leftSum - rightSum);

    totalTilt += tilt;

    return treeNode.val + leftSum + rightSum;
  }
}
