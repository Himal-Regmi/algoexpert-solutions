package binarysearchtree.medium;

import java.util.ArrayList;

// O(n) and O(n)
public class KthLargestValueInBst {
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
    ArrayList<Integer> sortedBstArray = getSortedArrayFromBst(tree, new ArrayList<Integer>());
    return sortedBstArray.get(sortedBstArray.size() - k);
  }

  public ArrayList<Integer> getSortedArrayFromBst(BST node, ArrayList<Integer> array) {
    if (node == null) return array;
    getSortedArrayFromBst(node.left, array);
    array.add(node.value);
    getSortedArrayFromBst(node.right, array);
    return array;
  }
}
