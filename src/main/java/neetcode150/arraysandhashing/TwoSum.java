package neetcode150.arraysandhashing;

import java.util.HashMap;

public class TwoSum {
  // O(n) & O(n)
  class Solution {
    public int[] twoSum(int[] nums, int target) {

      HashMap<Integer, Integer> targetDifferenceMap = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
        if (targetDifferenceMap.containsKey(nums[i])) {
          return new int[] {targetDifferenceMap.get(nums[i]), i};
        } else {
          targetDifferenceMap.put(target - nums[i], i);
        }
      }
      return new int[] {0, 0};
    }
  }
}
