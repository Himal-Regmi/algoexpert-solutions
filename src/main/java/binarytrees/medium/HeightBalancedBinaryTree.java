package binarytrees.medium;

// O(n ^ 2) and O(h)
public class HeightBalancedBinaryTree {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    return isTheHeightOfNodeBalanced(tree, true);
  }

  public boolean isTheHeightOfNodeBalanced(BinaryTree tree, boolean isTreeBalanced) {
    if (!isTreeBalanced) {
      return false;
    }
    isTreeBalanced =
        Math.abs(getHeightOfBinaryTree(tree.left) - getHeightOfBinaryTree(tree.right)) <= 1;
    if (tree.left != null) {
      isTreeBalanced = isTheHeightOfNodeBalanced(tree.left, isTreeBalanced);
    }

    if (tree.right != null) {
      isTreeBalanced = isTheHeightOfNodeBalanced(tree.right, isTreeBalanced);
    }

    return isTreeBalanced;
  }

  public int getHeightOfBinaryTree(BinaryTree tree) {
    if (tree == null) return 0;
    return 1 + Math.max(getHeightOfBinaryTree(tree.left), getHeightOfBinaryTree(tree.right));
  }
}
