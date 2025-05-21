package binarytrees.medium;

// O(n) and O(h)
public class HeightBalancedBinaryTree2 {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  static class TreeInfo {
    int height;
    boolean isBalanced;

    public TreeInfo(int height, boolean isBalanced) {
      this.height = height;
      this.isBalanced = isBalanced;
    }
  }

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    return getTreeInfo(tree).isBalanced;
  }

  public TreeInfo getTreeInfo(BinaryTree tree) {
    if (tree == null) {
      return new TreeInfo(-1, true);
    }

    TreeInfo leftTreeInfo = getTreeInfo(tree.left);
    TreeInfo rightTreeInfo = getTreeInfo(tree.right);

    int treeHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);
    boolean isBalanced =
        leftTreeInfo.isBalanced
            && rightTreeInfo.isBalanced
            && Math.abs(leftTreeInfo.height - rightTreeInfo.height) <= 1;

    return new TreeInfo(treeHeight, isBalanced);
  }
}
