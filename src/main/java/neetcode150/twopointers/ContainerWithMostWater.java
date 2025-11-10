package neetcode150.twopointers;

public class ContainerWithMostWater {
  class Solution {
    public int maxArea(int[] heights) {
      int leftIndex = 0;
      int rightIndex = heights.length - 1;
      int maxArea = 0;

      while (leftIndex < rightIndex) {
        int leftHeight = heights[leftIndex];
        int rightHeight = heights[rightIndex];
        int currentArea = (rightIndex - leftIndex) * Math.min(leftHeight, rightHeight);
        maxArea = Math.max(maxArea, currentArea);
        if (leftHeight < rightHeight) {
          leftIndex++;
        } else {
          rightIndex--;
        }
      }

      return maxArea;
    }
  }
}
