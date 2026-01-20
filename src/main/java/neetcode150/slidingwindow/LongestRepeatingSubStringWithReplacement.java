package neetcode150.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestRepeatingSubStringWithReplacement {
  // O(n * m) && O(m) where m -> 26 characters
  class Solution {
    public int characterReplacement(String s, int k) {
      int res = 0;
      Set<Character> chars = new HashSet<>();
      for (Character c : s.toCharArray()) {
        chars.add(c);
      }
      for (Character c : chars) {
        int l = 0;
        int count = 0;
        for (int r = 0; r < s.length(); r++) {
          if (s.charAt(r) == c) {
            count++;
          }
          while ((r - l + 1) - count > k) {
            if (s.charAt(l) == c) {
              count--;
            }
            l++;
          }
          res = Math.max(res, (r - l + 1));
        }
      }
      return res;
    }
  }

  // O(n * m) && O(m)
  // here instead of calculating freq each time , we keep track of it and calculate max frequency as
  // needed.
  class Solution2 {
    public int characterReplacement(String s, int k) {
      int res = 0;
      Map<Character, Integer> charCount = new HashMap<>();
      int l = 0;
      for (int r = 0; r < s.length(); r++) {
        charCount.put(s.charAt(r), charCount.getOrDefault(s.charAt(r), 0) + 1);
        int maxFrequency = 0;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
          maxFrequency = Math.max(maxFrequency, entry.getValue());
        }
        while ((r - l + 1) - maxFrequency > k) {
          charCount.put(s.charAt(l), charCount.get(s.charAt(l)) - 1);
          l++;
        }
        res = Math.max(res, r - l + 1);
      }
      return res;
    }
  }

  // O(n) && O(m)
  // apparently, we don't have to update maxFrequency when removing character on left
  // decreasing max frequency doesn't help in increasing result
  class Solution3 {
    public int characterReplacement(String s, int k) {
      int res = 0;
      Map<Character, Integer> charCount = new HashMap<>();
      int l = 0, maxf = 0;
      for (int r = 0; r < s.length(); r++) {
        charCount.put(s.charAt(r), charCount.getOrDefault(s.charAt(r), 0) + 1);
        maxf = Math.max(maxf, charCount.get(s.charAt(r)));
        while ((r - l + 1) - maxf > k) {
          charCount.put(s.charAt(l), charCount.get(s.charAt(l)) - 1);
          l++;
        }
        res = Math.max(res, r - l + 1);
      }
      return res;
    }
  }
}
