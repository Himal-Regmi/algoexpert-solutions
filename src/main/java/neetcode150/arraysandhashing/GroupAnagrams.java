package neetcode150.arraysandhashing;

import java.util.*;

public class GroupAnagrams {
  // O(n ^ 2 * m ) && O(n * m) - n -> length of strs and m -> length of longest string
  class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      List<List<String>> groupAnagrams = new ArrayList<>();

      for (String s : strs) {
        boolean anagramFound = false;
        for (List<String> anagrams : groupAnagrams) {
          if (isAnagram(s, anagrams.get(0))) {
            anagrams.add(s);
            anagramFound = true;
            break;
          }
        }
        if (!anagramFound) {
          groupAnagrams.add(new ArrayList<>(List.of(s)));
        }
      }

      return groupAnagrams;
    }

    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
        return false;
      }

      int[] alphabetsCount = new int[26];

      for (int i = 0; i < s.length(); i++) {
        alphabetsCount[s.charAt(i) - 'a']++;
        alphabetsCount[t.charAt(i) - 'a']--;
      }

      for (int i : alphabetsCount) {
        if (i != 0) {
          return false;
        }
      }

      return true;
    }
  }

  // O(n * m) & O(n)
  class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String, List<String>> anagramsMap = new HashMap<>();
      for (String s : strs) {
        int[] freqArray = new int[26];
        for (char c : s.toCharArray()) {
          freqArray[c - 'a']++;
        }
        String key = Arrays.toString(freqArray);
        anagramsMap.putIfAbsent(key, new ArrayList<>());
        anagramsMap.get(key).add(s);
      }
      return new ArrayList<>(anagramsMap.values());
    }
  }
}
