package graphs.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// O(w*h) && O(w*h)
public class RiverSizes {
  public static List<Integer> riverSizes(int[][] matrix) {
    ArrayList<Integer> sizeOfUniqueRivers = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == -1) {
          continue;
        }
        addRiverSizeFromCurrentNode(i, j, matrix, sizeOfUniqueRivers);
      }
    }

    return sizeOfUniqueRivers;
  }

  public static void addRiverSizeFromCurrentNode(
      int i, int j, int[][] matrix, ArrayList<Integer> sizeOfUniqueRivers) {
    int currentRiverSize = 0;
    Stack<Integer[]> nodesToExplore = new Stack<>();
    nodesToExplore.add(new Integer[] {i, j});

    while (!nodesToExplore.empty()) {
      Integer[] currentNode = nodesToExplore.pop();
      i = currentNode[0];
      j = currentNode[1];
      if (matrix[i][j] == -1) {
        continue;
      }
      if (matrix[i][j] == 0) {
        matrix[i][j] = -1;
        continue;
      }
      matrix[i][j] = -1;
      currentRiverSize += 1;
      List<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix);
      for (Integer[] neighbor : unvisitedNeighbors) {
        nodesToExplore.push(neighbor);
      }
    }
    if (currentRiverSize > 0) {
      sizeOfUniqueRivers.add(currentRiverSize);
    }
  }

  public static List<Integer[]> getUnvisitedNeighbors(int i, int j, int[][] matrix) {
    List<Integer[]> unvisitedNeighbors = new ArrayList<>();
    if (i > 0 && matrix[i - 1][j] != -1) {
      unvisitedNeighbors.add(new Integer[] {i - 1, j});
    }
    if (i < matrix.length - 1 && matrix[i + 1][j] != -1) {
      unvisitedNeighbors.add(new Integer[] {i + 1, j});
    }
    if (j > 0 && matrix[i][j - 1] != -1) {
      unvisitedNeighbors.add(new Integer[] {i, j - 1});
    }
    if (j < matrix[0].length - 1 && matrix[i][j + 1] != -1) {
      unvisitedNeighbors.add(new Integer[] {i, j + 1});
    }
    return unvisitedNeighbors;
  }
}
