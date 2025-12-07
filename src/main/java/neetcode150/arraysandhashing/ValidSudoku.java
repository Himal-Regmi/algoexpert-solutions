package neetcode150.arraysandhashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
  class Solution {
    public boolean isValidSudoku(char[][] board) {
      Map<Integer, Set<Character>> uniqueRowData = new HashMap<>();
      Map<Integer, Set<Character>> uniqueColData = new HashMap<>();
      Map<String, Set<Character>> uniqueSquareData = new HashMap<>();

      for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
          if (board[row][col] == '.') {
            continue;
          }
          String squareKey = row / 3 + "." + col / 3;
          if (uniqueRowData.computeIfAbsent(row, k -> new HashSet<>()).contains(board[row][col])
              || uniqueColData.computeIfAbsent(col, k -> new HashSet<>()).contains(board[row][col])
              || uniqueSquareData
                  .computeIfAbsent(squareKey, k -> new HashSet<>())
                  .contains(board[row][col])) {
            return false;
          }
          uniqueRowData.get(row).add(board[row][col]);
          uniqueColData.get(col).add(board[row][col]);
          uniqueSquareData.get(squareKey).add(board[row][col]);
        }
      }
      return true;
    }
  }
}
