package binarysearchtree.medium;

import java.util.Stack;

// O(h + k) and O(h)
public class KthLargestValueInBst2 {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public int findKthLargestValueInBst(BST tree, int k) {
    Stack<BST> stack = new Stack<>();
    BST current = tree;
    int count = 0;

    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.right;
      }

      current = stack.pop();
      count += 1;

      if (count == k) {
        return current.value;
      }

      current = current.left;
    }

    return -1;
  }
}
