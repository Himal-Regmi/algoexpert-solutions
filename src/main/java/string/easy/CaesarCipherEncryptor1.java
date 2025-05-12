package string.easy;

import java.util.Arrays;
import java.util.List;

public class CaesarCipherEncryptor1 {
  // Space Complexity - O(N) and Time Complexity - O(N)
  public static String caesarCypherEncryptor(String str, int key) {
    key = key % 26;
    // SC O(1)
    List<Character> alphabets =
        Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    // SC O(n)
    StringBuilder s = new StringBuilder();
    // O(n)
    for (int i = 0; i < str.length(); i++) {
      // tc O(26)=O(1)
      int indexOfChar = alphabets.indexOf(str.charAt(i));
      // tc O(1)
      int targetIndex = (indexOfChar + key) % 26;
      // tc O(1)
      s.append(alphabets.get(targetIndex));
    }
    return s.toString();
  }
}
