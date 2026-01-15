package neetcode150.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (s.length() <= 1) {
        return s.length();
      }
      int leftPointer = 0;
      Set<Character> characterSet = new HashSet<>();
      characterSet.add(s.charAt(leftPointer));
      int result = 1;
      for (int i = 1; i < s.length(); i++) {
        if (characterSet.contains(s.charAt(i))) {
          while (s.charAt(leftPointer) != s.charAt(i)) {
            characterSet.remove(s.charAt(leftPointer));
            leftPointer++;
          }
          leftPointer++;
        } else {
          result = Math.max(result, i - leftPointer + 1);
          characterSet.add(s.charAt(i));
        }
      }
      return result;
    }
  }

  // O(n) and O(m) but better as we have stored the index of the character that repeats
  class Solution2 {
    public int lengthOfLongestSubstring(String s) {
      int leftPointer = 0;
      int result = 0;
      Map<Character, Integer> characterLastSeenIndexMap = new HashMap<>();

      for (int i = 0; i < s.length(); i++) {
        if (characterLastSeenIndexMap.containsKey(s.charAt(i))) {
          leftPointer = Math.max(leftPointer, characterLastSeenIndexMap.get(s.charAt(i)) + 1);
        }
        result = Math.max(result, i - leftPointer + 1);
        characterLastSeenIndexMap.put(s.charAt(i), i);
      }
      return result;
    }
  }
}
