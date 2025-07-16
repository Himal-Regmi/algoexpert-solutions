package binarytrees.medium;

// O(n) and O(h)
public class BinaryTreeDiameter2 {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public int maxDiameter = 0;

  public int binaryTreeDiameter(BinaryTree tree) {
    depthFirstSearch(tree);
    return maxDiameter;
  }

  public int depthFirstSearch(BinaryTree node) {
    if (node == null) {
      return 0;
    }

    int leftDiameter = depthFirstSearch(node.left);
    int rightDiameter = depthFirstSearch(node.right);

    maxDiameter = Math.max(maxDiameter, leftDiameter + rightDiameter);

    return Math.max(leftDiameter, rightDiameter) + 1;
  }
}
