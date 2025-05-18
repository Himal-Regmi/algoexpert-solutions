package binarytrees.easy;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    ArrayList<Integer> sumOfBranch = new ArrayList<>();
    addSumOfBranch(root, 0, sumOfBranch);
    return sumOfBranch;
  }

  public static void addSumOfBranch(BinaryTree root, int currentSum, List<Integer> sumOfBranch) {
    if (root.left != null) {
      addSumOfBranch(root.left, currentSum + root.value, sumOfBranch);
    }
    if (root.right != null) {
      addSumOfBranch(root.right, currentSum + root.value, sumOfBranch);
    }
    if (root.left == null && root.right == null) {
      sumOfBranch.add(currentSum + root.value);
    }
  }
}
