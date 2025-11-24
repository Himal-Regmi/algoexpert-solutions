package neetcode150.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
  class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> subsets = new ArrayList<>();
      subsets.add(new ArrayList<>());

      for (int num : nums) {
        int subsetSize = subsets.size();
        for (int i = 0; i < subsetSize; i++) {
          List<Integer> newSubset = new ArrayList<>(subsets.get(i));
          newSubset.add(num);
          subsets.add(newSubset);
        }
      }

      return subsets;
    }
  }
}
