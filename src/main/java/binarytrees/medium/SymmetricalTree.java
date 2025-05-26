package binarytrees.medium;

// O(n) and O(h)
public class SymmetricalTree {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public boolean symmetricalTree(BinaryTree tree) {
    return checkTwoNodeSame(tree.left, tree.right);
  }

  public Boolean checkTwoNodeSame(BinaryTree tree1, BinaryTree tree2) {
    if (tree1 != null && tree2 != null && tree1.value == tree2.value) {
      boolean isLeftTreeSame = checkTwoNodeSame(tree1.left, tree2.right);
      boolean isRightTreeSame = checkTwoNodeSame(tree1.right, tree2.left);
      return isLeftTreeSame && isRightTreeSame;
    }
    return tree1 == tree2;
  }
}
