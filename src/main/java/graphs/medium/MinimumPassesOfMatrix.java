package graphs.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// O(w * h) && O(w * h)
public class MinimumPassesOfMatrix {
  public int minimumPassesOfMatrix(int[][] matrix) {
    Queue<Integer[]> positiveNumberQueue = new LinkedList<>();
    int passes = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] > 0) {
          positiveNumberQueue.add(new Integer[] {i, j});
        }
      }
    }
    int currentPositiveNumbersToExplore = positiveNumberQueue.size();
    while (positiveNumberQueue.peek() != null) {
      if (currentPositiveNumbersToExplore > 0) {
        Integer[] currentNodeIndex = positiveNumberQueue.poll();
        int i = currentNodeIndex[0];
        int j = currentNodeIndex[1];
        List<Integer[]> nodesConvertedToPositive = getNeighborsConvertedToPositive(i, j, matrix);
        positiveNumberQueue.addAll(nodesConvertedToPositive);
        currentPositiveNumbersToExplore--;
      } else {
        passes += 1;
        currentPositiveNumbersToExplore = positiveNumberQueue.size();
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] < 0) {
          return -1;
        }
      }
    }
    return passes;
  }

  public List<Integer[]> getNeighborsConvertedToPositive(int i, int j, int[][] matrix) {
    List<Integer[]> convertedNeighbors = new ArrayList<>();
    if (i > 0 && matrix[i - 1][j] < 0) {
      matrix[i - 1][j] *= -1;
      convertedNeighbors.add(new Integer[] {i - 1, j});
    }
    if (i < matrix.length - 1 && matrix[i + 1][j] < 0) {
      matrix[i + 1][j] *= -1;
      convertedNeighbors.add(new Integer[] {i + 1, j});
    }
    if (j > 0 && matrix[i][j - 1] < 0) {
      matrix[i][j - 1] *= -1;
      convertedNeighbors.add(new Integer[] {i, j - 1});
    }
    if (j < matrix[0].length - 1 && matrix[i][j + 1] < 0) {
      matrix[i][j + 1] *= -1;
      convertedNeighbors.add(new Integer[] {i, j + 1});
    }
    return convertedNeighbors;
  }
}
