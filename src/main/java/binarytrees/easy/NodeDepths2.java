package binarytrees.easy;

// O(n) and O(h)
public class NodeDepths2 {
  public static int nodeDepths(BinaryTree root) {
    return getSumOfDepths(root, 0);
  }

  public static int getSumOfDepths(BinaryTree node, int currentDepth) {
    if (node == null) return 0;
    return currentDepth
        + getSumOfDepths(node.left, currentDepth + 1)
        + getSumOfDepths(node.right, currentDepth + 1);
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
