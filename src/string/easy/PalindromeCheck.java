package string.easy;

class PalindromeCheck {
    //SOLUTION 1 - O(n) and o(n) space and time complexity
    public static boolean isPalindrome2(String str) {
        // o(n) sc
        StringBuilder s = new StringBuilder();
        // O(n) tc
        for (int i = str.length() - 1; i >= 0; i--) {
            s.append(str.charAt(i));
        }
        // O(n) tc
        return str.contentEquals(s);
    }

    //SOLUTION 2 - //O(n) Time Complexity and O(1) Space Complexity
    public static boolean isPalindrome1(String str) {
        int startIndex = 0;
        int endIndex = str.length() - 1;
        while (startIndex < endIndex) {
            if ((str.charAt(startIndex) != str.charAt(endIndex))) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}