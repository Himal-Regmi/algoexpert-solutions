package binarysearchtree.medium;

import java.util.ArrayList;
import java.util.Stack;

// O(n) and O(h)
public class ReconstructBST {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
    Stack<BST> stack = new Stack<>();

    BST rootNode = new BST(preOrderTraversalValues.get(0));
    stack.add(rootNode);

    for (int i = 1; i < preOrderTraversalValues.size(); i++) {
      BST node = new BST(preOrderTraversalValues.get(i));
      BST parentNode = stack.peek();

      while (!stack.isEmpty() && node.value >= stack.peek().value) {
        parentNode = stack.pop();
      }

      if (node.value < parentNode.value) {
        parentNode.left = node;
      } else {
        parentNode.right = node;
      }

      stack.push(node);
    }

    return rootNode;
  }
}
