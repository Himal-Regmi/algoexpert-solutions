package binarysearchtree.medium;

// O(n) and O(h)
public class ValidateBST {
  public static boolean validateBst(BST tree) {
    return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean validateBst(BST tree, int minValue, int maxValue) {
    if (tree.value >= maxValue || tree.value < minValue) {
      return false;
    }
    boolean hasValidLeftTree = true;
    boolean hasValidRightTree = true;

    if (tree.left != null) {
      hasValidLeftTree = validateBst(tree.left, minValue, tree.value);
    }
    if (tree.right != null) {
      hasValidRightTree = validateBst(tree.right, tree.value, maxValue);
    }
    return hasValidLeftTree && hasValidRightTree;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
