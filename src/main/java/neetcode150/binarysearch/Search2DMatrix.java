package neetcode150.binarysearch;

public class Search2DMatrix {
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      int row = getTargetRow(matrix, target);
      return row != -1 && isTargetInRow(matrix, target, row);
    }

    public int getTargetRow(int[][] matrix, int target) {
      int leftIndex = 0;
      int rightIndex = matrix.length - 1;

      while (rightIndex >= leftIndex) {

        int centralIndex = (leftIndex + rightIndex) / 2;
        if (target < matrix[centralIndex][0]) {
          rightIndex = centralIndex - 1;
        } else if (target > matrix[centralIndex][matrix[0].length - 1]) {
          leftIndex = centralIndex + 1;
        } else {
          return centralIndex;
        }
      }
      return -1;
    }

    public Boolean isTargetInRow(int[][] matrix, int target, int row) {
      int leftIndex = 0;
      int rightIndex = matrix[0].length - 1;
      while (rightIndex >= leftIndex) {
        int centralIndex = (leftIndex + rightIndex) / 2;
        if (target < matrix[row][centralIndex]) {
          rightIndex = centralIndex - 1;
        } else if (target > matrix[row][centralIndex]) {
          leftIndex = centralIndex + 1;
        } else {
          return true;
        }
      }
      return false;
    }
  }
}
