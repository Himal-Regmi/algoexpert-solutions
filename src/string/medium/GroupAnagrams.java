package string.medium;

import java.util.*;

public class GroupAnagrams {
    // O(n^2 * k log k) Time Complexity
    // O(n * k) Space Complexity
    public static List<List<String>> groupAnagrams(List<String> words) {
        // O(n * k) Space Complexity
        List<List<String>> groupedAnagrams = new ArrayList<>();
        // O(n * k) Space Complexity
        Set<String> usedWords = new HashSet<String>();
        // O(n^2 * k log k) Time Complexity
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            // O(n) Space Complexity
            List<String> currentAnagrams = new ArrayList<String>();
            if (!usedWords.contains(word)) {
                currentAnagrams.add(word);
                usedWords.add(word);
                // O(k log k) Time Complexity
                String sortedWord = getSortedWord(word);
                // O(n * k log k) Time Complexity
                for (int j = i + 1; j < words.size(); j++) {
                    String checkingWord = words.get(j);
                    // O(k log k) Time Complexity
                    String sortedCheckingWord = getSortedWord(checkingWord);
                    if (sortedWord.equals(sortedCheckingWord)) {
                        currentAnagrams.add(checkingWord);
                        usedWords.add(checkingWord);
                    }
                }
                groupedAnagrams.add(currentAnagrams);
            }

        }
        return groupedAnagrams;
    }

    // O(k log k) Time Complexity
    // O(k) Space Complexity
    public static String getSortedWord(String word) {
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        return new String(wordChars);
    }
}
