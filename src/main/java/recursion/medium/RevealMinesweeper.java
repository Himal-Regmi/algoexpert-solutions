package recursion.medium;

import java.util.ArrayList;
import java.util.List;

// O(w * h) && O(w * h)
public class RevealMinesweeper {
  public String[][] revealMinesweeper(String[][] board, int row, int column) {
    if (board[row][column].equals("M")) {
      board[row][column] = "X";
    } else {
      revealHiddenSpaces(row, column, board);
    }
    return board;
  }

  public static void revealHiddenSpaces(int row, int column, String[][] board) {
    if (!board[row][column].equals("H")) {
      return;
    }
    List<Integer[]> neighbours = getNeighbours(row, column, board);

    List<Integer[]> hiddenNeighbours = new ArrayList<>();
    int neighbourMineCount = 0;

    for (Integer[] neighbour : neighbours) {
      if (board[neighbour[0]][neighbour[1]].equals("M")) {
        neighbourMineCount += 1;
      } else if (board[neighbour[0]][neighbour[1]].equals("H")) {
        hiddenNeighbours.add(neighbour);
      }
    }

    board[row][column] = String.valueOf(neighbourMineCount);

    if (neighbourMineCount == 0) {
      for (Integer[] neighbour : hiddenNeighbours) {
        revealHiddenSpaces(neighbour[0], neighbour[1], board);
      }
    }
  }

  public static List<Integer[]> getNeighbours(int row, int column, String[][] board) {
    List<Integer[]> neighbours = new ArrayList<>();
    int[][] directions =
        new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    for (int[] direction : directions) {
      int newRow = row + direction[0];
      int newColumn = column + direction[1];

      if (newRow >= 0 && newRow < board.length && newColumn >= 0 && newColumn < board[0].length) {
        neighbours.add(new Integer[] {newRow, newColumn});
      }
    }
    return neighbours;
  }
}
