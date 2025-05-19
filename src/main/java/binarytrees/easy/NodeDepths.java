package binarytrees.easy;

import java.util.ArrayList;

// O(n) and O(h)
public class NodeDepths {
  public static int nodeDepths(BinaryTree root) {
    ArrayList<Integer> depths = new ArrayList<>();
    if (root == null) {
      return 0;
    }
    addAllDepthsToList(root.left, 0, depths);
    addAllDepthsToList(root.right, 0, depths);

    int sumOfDepths = 0;
    for (int depth : depths) {
      sumOfDepths += depth;
    }
    return sumOfDepths;
  }

  public static void addAllDepthsToList(
      BinaryTree node, int currentDepth, ArrayList<Integer> depths) {
    if (node != null) {
      currentDepth = currentDepth + 1;
      depths.add(currentDepth);
      addAllDepthsToList(node.left, currentDepth, depths);
      addAllDepthsToList(node.right, currentDepth, depths);
    }
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
