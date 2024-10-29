package string.easy;

import java.util.*;

public class FirstNonRepeatingCharacter {
    public int firstNonRepeatingCharacter(String string) {
        //SC O(C)
        Map<Character, Integer> uniqueCharacters = new HashMap<Character, Integer>();
        //SC O(C)
        List<Character> removedCharacters = new ArrayList<Character>();
        //TC O(N)
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (uniqueCharacters.containsKey(c)) {
                uniqueCharacters.remove(c);
                removedCharacters.add(c);
            } else if (!removedCharacters.contains(c)) {
                uniqueCharacters.put(c, i);
            }
        }
        Iterator<Character> iterator = uniqueCharacters.keySet().iterator();
        if (iterator.hasNext()) {
            return uniqueCharacters.get(iterator.next());
        } else {
            return -1;
        }
    }
}
