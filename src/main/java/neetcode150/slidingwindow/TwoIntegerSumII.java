package neetcode150.slidingwindow;

public class TwoIntegerSumII {
  class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int leftIdx = 0;
      int rightIdx = numbers.length - 1;

      while (rightIdx > leftIdx) {
        if (numbers[leftIdx] + numbers[rightIdx] == target) {
          return new int[] {leftIdx + 1, rightIdx + 1};
        } else if (numbers[leftIdx] + numbers[rightIdx] < target) {
          leftIdx++;
        } else {
          rightIdx--;
        }
      }
      return new int[0];
    }
  }
}
