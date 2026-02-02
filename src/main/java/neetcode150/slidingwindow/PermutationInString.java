package neetcode150.slidingwindow;

import java.util.Arrays;

public class PermutationInString {
  // O(N * C) & O(C)
  class Solution {
    public boolean checkInclusion(String s1, String s2) {
      if (s2.length() < s1.length()) {
        return false;
      }
      int[] charCount1 = new int[26];
      int[] charCount2 = new int[26];
      for (int i = 0; i < s1.length(); i++) {
        charCount1[s1.charAt(i) - 'a']++;
        charCount2[s2.charAt(i) - 'a']++;
      }
      int l = 0;
      for (int r = s1.length(); r < s2.length(); r++) {
        if (Arrays.equals(charCount1, charCount2)) {
          return true;
        }
        charCount2[s2.charAt(l) - 'a']--;
        l++;
        charCount2[s2.charAt(r) - 'a']++;
      }
      return Arrays.equals(charCount1, charCount2);
    }
  }

  // O(N) & O(C)
  class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
      if (s2.length() < s1.length()) {
        return false;
      }
      int[] charCount1 = new int[26];
      int[] charCount2 = new int[26];
      for (int i = 0; i < s1.length(); i++) {
        charCount1[s1.charAt(i) - 'a']++;
        charCount2[s2.charAt(i) - 'a']++;
      }
      int matches = 0;
      for (int i = 0; i < 26; i++) {
        if (charCount1[i] == charCount2[i]) {
          matches++;
        }
      }
      int l = 0;
      for (int r = s1.length(); r < s2.length(); r++) {
        if (matches == 26) {
          return true;
        }
        int leftCharPosition = s2.charAt(l) - 'a';

        if (charCount1[leftCharPosition] == charCount2[leftCharPosition]) {
          matches--;
        }
        charCount2[leftCharPosition]--;

        if (charCount1[leftCharPosition] == charCount2[leftCharPosition]) {
          matches++;
        }

        int rightCharPosition = s2.charAt(r) - 'a';

        if (charCount1[rightCharPosition] == charCount2[rightCharPosition]) {
          matches--;
        }
        charCount2[rightCharPosition]++;

        if (charCount1[rightCharPosition] == charCount2[rightCharPosition]) {
          matches++;
        }
        l++;
      }
      return matches == 26;
    }
  }
}
