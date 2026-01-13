package neetcode150.twopointers;

public class TrappingRainWater {
  // O(n) & O(n)
  class Solution {
    public int trap(int[] height) {
      int[] leftBoundaryHeight = new int[height.length];
      int[] rightBoundaryHeight = new int[height.length];

      int currentLeftBoundaryHeight = 0;
      int currentRightBoundaryHeight = 0;
      for (int i = 0; i < height.length; i++) {
        leftBoundaryHeight[i] = currentLeftBoundaryHeight;
        currentLeftBoundaryHeight = Math.max(currentLeftBoundaryHeight, height[i]);
      }
      for (int i = height.length - 1; i >= 0; i--) {
        rightBoundaryHeight[i] = currentRightBoundaryHeight;
        currentRightBoundaryHeight = Math.max(currentRightBoundaryHeight, height[i]);
      }

      int totalWaterTrapped = 0;
      for (int i = 1; i < height.length - 1; i++) {
        int currentWaterTrapped =
            Math.min(leftBoundaryHeight[i], rightBoundaryHeight[i]) - height[i];
        if (currentWaterTrapped > 0) {
          totalWaterTrapped += currentWaterTrapped;
        }
      }
      return totalWaterTrapped;
    }
  }

  // O(n) & O(1)
  class Solution2 {
    public int trap(int[] height) {
      int leftIdx = 0;
      int rightIdx = height.length - 1;
      int leftMaximumHeight = height[leftIdx];
      int rightMaximumHeight = height[rightIdx];
      int totalWaterTrapped = 0;

      while (leftIdx <= rightIdx) {
        int currentIdxWaterTrapped = 0;
        if (leftMaximumHeight <= rightMaximumHeight) {
          currentIdxWaterTrapped =
              Math.max(currentIdxWaterTrapped, leftMaximumHeight - height[leftIdx]);
          leftMaximumHeight = Math.max(leftMaximumHeight, height[leftIdx]);
          leftIdx += 1;
        } else {
          currentIdxWaterTrapped =
              Math.max(currentIdxWaterTrapped, rightMaximumHeight - height[rightIdx]);
          rightMaximumHeight = Math.max(rightMaximumHeight, height[rightIdx]);
          rightIdx -= 1;
        }
        totalWaterTrapped += currentIdxWaterTrapped;
      }

      return totalWaterTrapped;
    }
  }
}
