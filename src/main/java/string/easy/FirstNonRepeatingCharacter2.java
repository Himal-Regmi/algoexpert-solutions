package string.easy;

import java.util.*;

public class FirstNonRepeatingCharacter2 {
  public int firstNonRepeatingCharacter(String string) {
    // SC O(C)
    HashMap<Character, Integer> characterCount = new HashMap<Character, Integer>();
    // SC O(N)
    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);
      characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
    }

    for (int i = 0; i < string.length(); i++) {
      char c = string.charAt(i);
      if (characterCount.get(c) == 1) {
        return i;
      }
    }

    return -1;
  }
}
