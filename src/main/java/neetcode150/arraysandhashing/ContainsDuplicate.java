package neetcode150.arraysandhashing;

import java.util.HashSet;

public class ContainsDuplicate {
  class Solution {
    public boolean hasDuplicate(int[] nums) {
      HashSet<Integer> visitedNumbers = new HashSet<>();
      for (int i = 0; i < nums.length; i++) {
        if (visitedNumbers.contains(nums[i])) {
          return true;
        }
        visitedNumbers.add(nums[i]);
      }
      return false;
    }
  }
}
