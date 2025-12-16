package neetcode150.arraysandhashing;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
  // O(n) & O(n)
  class Solution {
    public int longestConsecutive(int[] nums) {
      Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
      int longestConsecutive = 0;
      for (int num : nums) {
        if (numsSet.contains(num - 1)) {
          continue;
        }
        int consecutiveNumLength = 1;
        while (numsSet.contains(num + 1)) {
          consecutiveNumLength++;
          num += 1;
        }
        longestConsecutive = Math.max(longestConsecutive, consecutiveNumLength);
      }
      return longestConsecutive;
    }
  }

  // O(nlogn)
  class Solution2 {
    public int longestConsecutive(int[] nums) {
      if (nums.length == 0) return 0;

      Arrays.sort(nums);

      int currentNum = nums[0];
      int currentConsecutive = 1;
      int maxConsecutive = 1;

      for (int i = 1; i < nums.length; i++) {
        if (currentNum + 1 == nums[i]) {
          currentConsecutive += 1;
          maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
        } else if (currentNum == nums[i]) {
          continue;
        } else {
          currentConsecutive = 1;
        }
        currentNum = nums[i];
      }

      return maxConsecutive;
    }
  }
}
