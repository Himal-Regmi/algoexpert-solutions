package neetcode150.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      Arrays.sort(nums);
      List<List<Integer>> results = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) break;
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        int leftIdx = i + 1;
        int rightIdx = nums.length - 1;
        while (leftIdx < rightIdx) {
          if (nums[i] + nums[leftIdx] + nums[rightIdx] == 0) {
            results.add(List.of(nums[i], nums[leftIdx], nums[rightIdx]));
            leftIdx++;
            rightIdx--;
            while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]) {
              leftIdx++;
            }
          } else if (nums[i] + nums[leftIdx] + nums[rightIdx] > 0) {
            rightIdx--;
          } else {
            leftIdx++;
          }
        }
      }

      return results;
    }
  }
}
