package string.medium;

public class LongestPalindromicSubstring {
  public static String longestPalindromicSubstring(String str) {
    String longestPalindrome = "";
    for (int i = 0; i < str.length(); i++) {
      for (int j = str.length(); j > i; j--) {
        String substring = str.substring(i, j);
        if (longestPalindrome.length() < substring.length() && isPalindrome(substring)) {
          longestPalindrome = substring;
        }
      }
    }
    return longestPalindrome;
  }

  public static boolean isPalindrome(String s) {
    int startIndex = 0;
    int endIndex = s.length() - 1;

    while (startIndex < endIndex) {
      if (s.charAt(startIndex) != (s.charAt(endIndex))) {
        return false;
      }
      startIndex++;
      endIndex--;
    }
    return true;
  }
}
