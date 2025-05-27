package binarysearchtree.easy;

// Average case - O(logn) & O(1)
// Worst Case - O(n) & O(1)
public class FindClosestValueInBST2 {
  public static int findClosestValueInBst(BST tree, int target) {
    return findClosestValueInBst(tree, target, tree.value);
  }

  public static int findClosestValueInBst(BST tree, int target, int closest) {
    BST currentNode = tree;
    while (currentNode != null) {
      if (Math.abs(target - currentNode.value) < Math.abs(target - closest)) {
        closest = currentNode.value;
      }
      if (target < currentNode.value) {
        currentNode = currentNode.left;
      } else if (target > currentNode.value) {
        currentNode = currentNode.right;
      } else {
        break;
      }
    }
    return closest;
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
