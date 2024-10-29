package string.medium;

import java.util.*;

public class GroupAnagrams2 {
    // O(n * k log k) Time Complexity
    // O(n * k) Space Complexity
    public static List<List<String>> groupAnagrams(List<String> words) {
        // O(n * k) Space Complexity
        Map<String, List<String>> anagramsHashTable = new HashMap<>();
        // O(n * k log k) Time Complexity
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            //O(k logk) Time Complexity
            String sortedWord = getSortedString(word);
            if (anagramsHashTable.containsKey(sortedWord)) {
                // O(n) Space Complexity
                List<String> anagramList = anagramsHashTable.get(sortedWord);
                anagramList.add(word);
                anagramsHashTable.put(sortedWord, anagramList);
            } else {
                // O(1) Space Complexity
                List<String> anagramList = new ArrayList<>();
                anagramList.add(word);
                anagramsHashTable.put(sortedWord, anagramList);
            }
        }
        // O(n * k) Space Complexity

        return new ArrayList<>(anagramsHashTable.values());

    }

    // O(k log k) Time Complexity
    // O(k) Space Complexity
    public static String getSortedString(String str) {
        char[] charsInString = str.toCharArray();
        Arrays.sort(charsInString);
        return new String(charsInString);
    }
}
