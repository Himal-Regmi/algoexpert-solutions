package neetcode150.stack;

public class LargestRectangleInHistogram {
  // O(n ^ 2) & O(1)
  class Solution {
    public int largestRectangleArea(int[] heights) {
      int maxArea = 0;

      for (int i = 0; i < heights.length; i++) {
        int currentMaxArea = heights[i];
        int leftIdx = i - 1;
        while (leftIdx >= 0 && heights[leftIdx] >= heights[i]) {
          currentMaxArea += heights[i];
          leftIdx--;
        }
        int rightIdx = i + 1;
        while (rightIdx < heights.length && heights[rightIdx] >= heights[i]) {
          currentMaxArea += heights[i];
          rightIdx++;
        }
        maxArea = Math.max(maxArea, currentMaxArea);
      }

      return maxArea;
    }
  }
}
