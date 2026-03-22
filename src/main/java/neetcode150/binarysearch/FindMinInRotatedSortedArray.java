package neetcode150.binarysearch;

public class FindMinInRotatedSortedArray {
  // O(logn) && O(1)
  class Solution {
    public int findMin(int[] nums) {
      int l = 0;
      int r = nums.length - 1;
      int result = nums[0];

      while (l <= r) {
        if (nums[l] < nums[r]) {
          result = Math.min(nums[l], result);
          break;
        }
        int mid = l + (r - l) / 2;
        result = Math.min(nums[mid], result);
        if (nums[l] > nums[mid]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
      return result;
    }
  }
}
