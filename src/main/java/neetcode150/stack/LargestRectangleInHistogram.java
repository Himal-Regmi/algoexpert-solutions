package neetcode150.stack;

import java.util.Stack;

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

  // O(n) & O(n);
  class Solution2 {
    public int largestRectangleArea(int[] heights) {
      Stack<Integer> monotonicStack = new Stack<>();

      int maxArea = 0;

      for (int i = 0; i < heights.length; i++) {
        while (!monotonicStack.isEmpty() && heights[i] < heights[monotonicStack.peek()]) {
          int currentItem = monotonicStack.pop();
          int rightWall = i;
          int leftWall = monotonicStack.isEmpty() ? -1 : monotonicStack.peek();
          int currentWidth = rightWall - leftWall - 1;
          int currentArea = heights[currentItem] * currentWidth;
          maxArea = Math.max(maxArea, currentArea);
        }
        monotonicStack.push(i);
      }

      while (!monotonicStack.isEmpty()) {
        int currentItem = monotonicStack.pop();
        int rightWall = heights.length;
        int leftWall = monotonicStack.isEmpty() ? -1 : monotonicStack.peek();
        int currentWidth = rightWall - leftWall - 1;
        int currentArea = heights[currentItem] * currentWidth;
        maxArea = Math.max(maxArea, currentArea);
      }
      return maxArea;
    }
  }
}
