package string.medium;

public class LongestPalindromicSubstring2 {
  // O(n ^ 2) time complexity || O(n) space complexity
  public static String longestPalindromicSubstring(String str) {
    int[] longestPalindromeIndex = new int[] {0, 1};
    // O(n) time complexity
    for (int i = 1; i < str.length(); i++) {
      int[] longestEvenPalindrome = getLongestPalindrome(str, i - 1, i);
      int[] longestOddPalindrome = getLongestPalindrome(str, i - 1, i + 1);
      int[] currentLongestPalindrome =
          longestEvenPalindrome[1] - longestEvenPalindrome[0]
                  > longestOddPalindrome[1] - longestOddPalindrome[0]
              ? longestEvenPalindrome
              : longestOddPalindrome;
      if (currentLongestPalindrome[1] - currentLongestPalindrome[0]
          > longestPalindromeIndex[1] - longestPalindromeIndex[0]) {
        longestPalindromeIndex = currentLongestPalindrome;
      }
    }
    // O(n) space complexity
    return str.substring(longestPalindromeIndex[0], longestPalindromeIndex[1]);
  }

  // O(n) time complexity
  public static int[] getLongestPalindrome(String s, int leftIndex, int rightIndex) {
    while (leftIndex >= 0 && rightIndex < s.length()) {
      if (s.charAt(leftIndex) != s.charAt(rightIndex)) {
        break;
      }
      leftIndex--;
      rightIndex++;
    }
    return new int[] {leftIndex + 1, rightIndex};
  }
}
