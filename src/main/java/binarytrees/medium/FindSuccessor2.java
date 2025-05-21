package binarytrees.medium;

// O(h) and O(1)
public class FindSuccessor2 {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public FindSuccessor.BinaryTree left = null;
    public FindSuccessor.BinaryTree right = null;
    public FindSuccessor.BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public FindSuccessor.BinaryTree findSuccessor(
      FindSuccessor.BinaryTree tree, FindSuccessor.BinaryTree node) {
    FindSuccessor.BinaryTree nextNode = null;
    if (node.right != null) {
      nextNode = node.right;
      while (nextNode.left != null) {
        nextNode = nextNode.left;
      }
    } else {
      FindSuccessor.BinaryTree currentNode = node;
      while (currentNode.parent != null && currentNode.equals(currentNode.parent.right)) {
        currentNode = currentNode.parent;
      }
      nextNode = currentNode.parent;
    }
    return nextNode;
  }
}
