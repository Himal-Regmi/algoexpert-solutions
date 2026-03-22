package neetcode150.binarysearch;

public class SearchInRotatedSortedArray {
  // O(logn) & O(n)
  class Solution {
    public int search(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;

      while (l < r) {
        int mid = l + (r - l) / 2;

        if (nums[mid] > nums[r]) {
          l = mid + 1;
        } else {
          r = mid;
        }
      }
      int pivotPoint = l;

      System.out.println(pivotPoint);

      l = 0 + pivotPoint;
      r = nums.length - 1 + pivotPoint;

      while (l <= r) {
        int mid = l + (r - l) / 2;

        if (nums[mid % nums.length] == target) {
          return mid % nums.length;
        }

        if (target > nums[mid % nums.length]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      return -1;
    }
  }
}
