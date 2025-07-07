package searching.medium;

// O(n + m) && O(1)
public class SearchInSortedMatrix {
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    int row = matrix.length - 1;
    int col = 0;

    while (row >= 0 && col < matrix[0].length) {
      if (target == matrix[row][col]) {
        return new int[] {row, col};
      } else if (target > matrix[row][col]) {
        col++;
      } else {
        row--;
      }
    }
    return new int[] {-1, -1};
  }
}
