package binarytrees.medium;

public class BinaryTreeDiameter {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  static class TreeDetails {
    public int diameter;
    public int height;

    public TreeDetails(int diameter, int height) {
      this.diameter = diameter;
      this.height = height;
    }
  }

  public int binaryTreeDiameter(BinaryTree tree) {
    return getTreeDetails(tree).diameter;
  }

  public TreeDetails getTreeDetails(BinaryTree tree) {
    if (tree == null) {
      return new TreeDetails(0, 0);
    }

    TreeDetails leftTreeDetails = getTreeDetails(tree.left);
    TreeDetails rightTreeDetails = getTreeDetails(tree.right);

    int height = 1 + Math.max(leftTreeDetails.height, rightTreeDetails.height);

    int maxDiameterOfSubTree = Math.max(leftTreeDetails.diameter, rightTreeDetails.diameter);
    int currentNodeDiameter = leftTreeDetails.height + rightTreeDetails.height;
    int maxDiameter = Math.max(maxDiameterOfSubTree, currentNodeDiameter);

    return new TreeDetails(maxDiameter, height);
  }
}
