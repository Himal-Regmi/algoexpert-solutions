package neetcode150.arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
  // O(n + m) and O(1)
  class Solution1 {
    public boolean isAnagram(String s, String t) {
      HashMap<Character, Integer> charCount = new HashMap<>();

      for (char c : s.toCharArray()) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
      }

      for (char c : t.toCharArray()) {
        if (charCount.getOrDefault(c, 0) > 0) {
          charCount.put(c, charCount.get(c) - 1);
        } else {
          return false;
        }
      }

      for (char c : charCount.keySet()) {
        if (charCount.get(c) > 0) {
          return false;
        }
      }
      return true;
    }
  }

  // O(n * logn + m * Logm) && O(1)
  class Solution2 {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }

      char[] firstStringSorted = s.toCharArray();
      char[] secondStringSorted = t.toCharArray();

      Arrays.sort(firstStringSorted);
      Arrays.sort(secondStringSorted);

      return Arrays.equals(firstStringSorted, secondStringSorted);
    }
  }

  // O(n + m) && O(1)
  class Solution3 {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }

      Map<Character, Integer> firstStringCharMap = new HashMap<>();
      Map<Character, Integer> secondStringCharMap = new HashMap<>();

      for (int i = 0; i < s.length(); i++) {
        firstStringCharMap.put(s.charAt(i), firstStringCharMap.getOrDefault(s.charAt(i), 0) + 1);
        secondStringCharMap.put(t.charAt(i), secondStringCharMap.getOrDefault(t.charAt(i), 0) + 1);
      }

      return firstStringCharMap.equals(secondStringCharMap);
    }
  }
}
