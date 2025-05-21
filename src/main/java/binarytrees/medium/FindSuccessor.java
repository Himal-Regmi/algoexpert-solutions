package binarytrees.medium;

import java.util.ArrayList;

// O(n) and O(n)
public class FindSuccessor {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    ArrayList<BinaryTree> traversalOrder = new ArrayList<>();

    inLineTraversal(tree, traversalOrder);

    for (int i = 0; i < traversalOrder.size(); i++) {
      if (traversalOrder.get(i).equals(node)) {
        if (i == traversalOrder.size() - 1) {
          return null;
        }
        return traversalOrder.get(i + 1);
      }
    }

    return null;
  }

  public void inLineTraversal(BinaryTree node, ArrayList<BinaryTree> traversalOrder) {
    if (node == null) {
      return;
    }
    inLineTraversal(node.left, traversalOrder);
    traversalOrder.add(node);
    inLineTraversal(node.right, traversalOrder);
  }
}
