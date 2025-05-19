package binarytrees.medium;

// O(n) and O(h)
public class InvertBinaryTree {
  public static void invertBinaryTree(BinaryTree tree) {
    if (tree == null) return;

    BinaryTree left = tree.left;
    tree.left = tree.right;
    tree.right = left;

    invertBinaryTree(tree.left);

    invertBinaryTree(tree.right);
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
