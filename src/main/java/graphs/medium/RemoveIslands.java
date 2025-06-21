package graphs.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// O(wh) and O(wh)
public class RemoveIslands {
  public int[][] removeIslands(int[][] matrix) {
    boolean[][] exploredLand = new boolean[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (exploredLand[i][j] || matrix[i][j] == 0) {
          exploredLand[i][j] = true;
        } else {
          visitLand(i, j, matrix, exploredLand);
        }
      }
    }

    return matrix;
  }

  public void visitLand(int i, int j, int[][] matrix, boolean[][] exploredLand) {
    boolean isTouchingBorder = false;
    Stack<Integer[]> toExplore = new Stack<>();
    List<Integer[]> landExplored = new ArrayList<>();
    toExplore.add(new Integer[] {i, j});

    while (!toExplore.empty()) {
      Integer[] current = toExplore.pop();
      i = current[0];
      j = current[1];
      if (exploredLand[i][j]) {
        continue;
      }
      if (matrix[i][j] == 0) {
        exploredLand[i][j] = true;
        continue;
      }
      landExplored.add(current);
      exploredLand[i][j] = true;
      if (i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[0].length - 1) {
        isTouchingBorder = true;
      }
      List<Integer[]> unexploredNeighbors = getUnexploredNeighbors(i, j, matrix, exploredLand);
      for (Integer[] neighbor : unexploredNeighbors) {
        toExplore.push(neighbor);
      }
    }
    if (!isTouchingBorder) {
      for (Integer[] land : landExplored) {
        matrix[land[0]][land[1]] = 0;
      }
    }
  }

  public List<Integer[]> getUnexploredNeighbors(
      int i, int j, int[][] matrix, boolean[][] exploredLand) {
    List<Integer[]> unexploredNeighbors = new ArrayList<>();
    if (i > 0 && !exploredLand[i - 1][j]) {
      unexploredNeighbors.add(new Integer[] {i - 1, j});
    }
    if (i < matrix.length - 1 && !exploredLand[i + 1][j]) {
      unexploredNeighbors.add(new Integer[] {i + 1, j});
    }
    if (j > 0 && !exploredLand[i][j - 1]) {
      unexploredNeighbors.add(new Integer[] {i, j - 1});
    }
    if (j < matrix[0].length - 1 && !exploredLand[i][j + 1]) {
      unexploredNeighbors.add(new Integer[] {i, j + 1});
    }
    return unexploredNeighbors;
  }
}
