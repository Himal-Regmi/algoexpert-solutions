package neetcode150.arraysandhashing;

import java.util.HashSet;

public class ContainsDuplicate {
  // O(n) & O(n)
  class Solution {
    public boolean hasDuplicate(int[] nums) {
      HashSet<Integer> visitedNumbers = new HashSet<>();
      for (int num : nums) {
        if (visitedNumbers.contains(num)) {
          return true;
        }
        visitedNumbers.add(num);
      }
      return false;
    }
  }
}
