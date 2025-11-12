package neetcode150.binarysearch;

public class BinarySearch {
  class Solution {
    public int search(int[] nums, int target) {
      int leftIndex = 0;
      int rightIndex = nums.length - 1;

      while (rightIndex >= leftIndex) {
        int middleIndex = (leftIndex + rightIndex) / 2;
        if (target < nums[middleIndex]) {
          rightIndex = middleIndex - 1;
        } else if (target > nums[middleIndex]) {
          leftIndex = middleIndex + 1;
        } else {
          return middleIndex;
        }
      }
      return -1;
    }
  }
}
