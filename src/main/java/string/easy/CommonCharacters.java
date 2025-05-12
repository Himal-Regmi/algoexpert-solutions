package string.easy;

import java.util.HashSet;
import java.util.Set;

public class CommonCharacters {
  public String[] commonCharacters(String[] strings) {
    // SC O(C) -> c -> maximum number of characters..
    Set<Character> commonChars = new HashSet<Character>();
    // TC -> O(m1) -> length of 1st string
    for (Character c : strings[0].toCharArray()) {
      commonChars.add(c);
    }
    // TC -> O(n-1)
    // TOTAL -> O(n) * O(m) -> O(n*m) -> m is length of string with maximum characters..
    for (int i = 1; i < strings.length; i++) {
      Set<Character> currentCommonChar = new HashSet<Character>();
      // TC -> O(mx) -> length of string at x position
      for (char c : strings[i].toCharArray()) {
        if (commonChars.contains(c)) {
          currentCommonChar.add(c);
        }
      }
      commonChars = currentCommonChar;
    }

    String[] arr = new String[commonChars.size()];
    int arrIndex = 0;

    for (Character c : commonChars) {
      arr[arrIndex++] = c.toString();
    }

    return arr;
  }
}
