package neetcode150.arraysandhashing;

import java.util.*;

public class TopKFrequentElements {
  // O(n * logn) + O(n)
  class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      int numberOfUniqueItems = 0;

      Map<Integer, Integer> numsFrequency = new HashMap<>();
      for (int num : nums) {
        numsFrequency.put(num, numsFrequency.getOrDefault(num, 0) + 1);
      }

      List<int[]> sortedFrequency = new ArrayList<>();

      for (Map.Entry<Integer, Integer> entry : numsFrequency.entrySet()) {
        sortedFrequency.add(new int[] {entry.getValue(), entry.getKey()});
      }

      Collections.sort(sortedFrequency, (a, b) -> b[0] - a[0]);

      int[] res = new int[k];

      for (int i = 0; i < k; i++) {
        res[i] = sortedFrequency.get(i)[1];
      }

      return res;
    }
  }

  // O( n * logk) + O(n + k)
  class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
      int numberOfUniqueItems = 0;

      Map<Integer, Integer> numsFrequency = new HashMap<>();
      for (int num : nums) {
        numsFrequency.put(num, numsFrequency.getOrDefault(num, 0) + 1);
      }

      PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

      for (Map.Entry<Integer, Integer> entry : numsFrequency.entrySet()) {
        heap.offer(new int[] {entry.getValue(), entry.getKey()});
        if (heap.size() > k) {
          heap.poll();
        }
      }

      int[] res = new int[k];

      for (int i = 0; i < k; i++) {
        res[i] = heap.poll()[1];
      }

      return res;
    }
  }

  // O(n) & O(n)
  class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> numFrequency = new HashMap<>();
      for (int num : nums) {
        numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
      }

      List<Integer>[] freq = new List[nums.length + 1];

      for (int i = 0; i < freq.length; i++) {
        freq[i] = new ArrayList<>();
      }

      for (Map.Entry<Integer, Integer> entry : numFrequency.entrySet()) {
        freq[entry.getValue()].add(entry.getKey());
      }

      int[] topKFrequent = new int[k];
      int currentIndex = 0;

      for (int i = freq.length - 1; i > 0 && currentIndex < k; i--) {
        for (int n : freq[i]) {
          topKFrequent[currentIndex++] = n;
          if (currentIndex == k) {
            break;
          }
        }
      }

      return topKFrequent;
    }
  }
}
