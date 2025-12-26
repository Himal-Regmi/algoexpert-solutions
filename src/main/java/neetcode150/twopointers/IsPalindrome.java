package neetcode150.twopointers;

public class IsPalindrome {
  class Solution {
    public boolean isPalindrome(String s) {
      int leftIdx = 0;
      int rightIdx = s.length() - 1;

      while (leftIdx < rightIdx) {
        while (leftIdx < rightIdx && !isAlphaNumeric(s.charAt(leftIdx))) {
          leftIdx++;
        }
        while (leftIdx < rightIdx && !isAlphaNumeric(s.charAt(rightIdx))) {
          rightIdx--;
        }
        if (Character.toLowerCase(s.charAt(leftIdx)) != Character.toLowerCase(s.charAt(rightIdx))) {
          return false;
        }
        leftIdx++;
        rightIdx--;
      }
      return true;
    }

    public boolean isAlphaNumeric(char c) {
      return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9');
    }
  }
}
