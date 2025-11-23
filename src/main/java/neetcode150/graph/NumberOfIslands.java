package neetcode150.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumberOfIslands {
  class Solution {
    public int numIslands(char[][] grid) {
      int islandFound = 0;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] == '0' || grid[i][j] == '2') {
            grid[i][j] = '2';
            continue;
          } else {
            exploreIsland(grid, i, j);
            islandFound++;
          }
        }
      }
      return islandFound;
    }

    public void exploreIsland(char[][] grid, int x, int y) {
      Stack<int[]> currentIsland = new Stack<>();
      currentIsland.add(new int[] {x, y});
      while (!currentIsland.isEmpty()) {
        int[] currentLand = currentIsland.pop();
        x = currentLand[0];
        y = currentLand[1];
        grid[x][y] = '2';
        List<int[]> neighbouringLands = getNeighbouringLands(grid, x, y);
        for (int[] land : neighbouringLands) {
          currentIsland.push(land);
        }
      }
    }

    public List<int[]> getNeighbouringLands(char[][] grid, int x, int y) {
      List<int[]> directions = new ArrayList<>();
      directions.add(new int[] {1, 0});
      directions.add(new int[] {-1, 0});
      directions.add(new int[] {0, 1});
      directions.add(new int[] {0, -1});

      List<int[]> neighbouringLands = new ArrayList<>();
      for (int[] direction : directions) {
        int i = x + direction[0];
        int j = y + direction[1];
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
          neighbouringLands.add(new int[] {i, j});
        }
      }
      return neighbouringLands;
    }
  }
}
