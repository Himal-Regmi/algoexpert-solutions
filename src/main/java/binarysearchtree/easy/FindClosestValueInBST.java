package binarysearchtree.easy;

// Average case - O(logn) & O(logn)
// Worst Case - O(n) & O(n)
public class FindClosestValueInBST {
  public static int findClosestValueInBst(BST tree, int target) {
    return findClosestValueInBst(tree, target, tree.value);
  }

  public static int findClosestValueInBst(BST tree, int target, int closestValue) {
    if (tree == null) {
      return closestValue;
    }

    if (Math.abs(target - tree.value) < Math.abs(target - closestValue)) {
      closestValue = tree.value;
    }

    if (target < tree.value) {
      return findClosestValueInBst(tree.left, target, closestValue);
    } else if (target > tree.value) {
      return findClosestValueInBst(tree.right, target, closestValue);
    } else {
      return closestValue;
    }
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
