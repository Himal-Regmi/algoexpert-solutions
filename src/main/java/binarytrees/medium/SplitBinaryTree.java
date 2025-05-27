package binarytrees.medium;

// O(n) && O(h)
public class SplitBinaryTree {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public int splitBinaryTree(BinaryTree tree) {
    int totalSumOfTree = getSumOfTree(tree);

    if (totalSumOfTree % 2 == 0) {
      if (getPossibleHalfSum(tree, totalSumOfTree / 2) == totalSumOfTree / 2) {
        return totalSumOfTree / 2;
      }
    }
    return 0;
  }

  public int getPossibleHalfSum(BinaryTree tree, int halfSum) {
    if (tree == null) {
      return 0;
    }

    int leftSum = getPossibleHalfSum(tree.left, halfSum);

    int rightSum = getPossibleHalfSum(tree.right, halfSum);

    if (leftSum == halfSum || rightSum == halfSum) {
      return halfSum;
    }

    return tree.value + leftSum + rightSum;
  }

  public int getSumOfTree(BinaryTree tree) {
    if (tree == null) {
      return 0;
    }
    return tree.value + getSumOfTree(tree.left) + getSumOfTree(tree.right);
  }
}
