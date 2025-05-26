package binarytrees.medium;

import java.util.Stack;

// O(n) and O(h)
public class MergeBinaryTrees2 {
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
    if (tree1 == null) return tree2;

    Stack<BinaryTree> stack1 = new Stack<>();
    Stack<BinaryTree> stack2 = new Stack<>();

    stack1.push(tree1);
    stack2.push(tree2);

    while (!stack1.isEmpty()) {
      BinaryTree poppedTree1 = stack1.pop();
      BinaryTree poppedTree2 = stack2.pop();

      if (poppedTree2 == null) {
        continue;
      }

      poppedTree1.value += poppedTree2.value;

      if (poppedTree1.left == null) {
        poppedTree1.left = poppedTree2.left;
      } else {
        stack1.push(poppedTree1.left);
        stack2.push(poppedTree2.left);
      }

      if (poppedTree1.right == null) {
        poppedTree1.right = poppedTree2.right;
      } else {
        stack1.push(poppedTree1.right);
        stack2.push(poppedTree2.right);
      }
    }
    return tree1;
  }
}
