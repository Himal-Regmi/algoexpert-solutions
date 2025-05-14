package string.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumCharactersForWord2 {
    public char[] minimumCharactersForWords(String[] words){
        Map<Character, Integer> maximumCharacterCount = new HashMap<>();

        for(String word: words){
            char[] charInWord = word.toCharArray();
            Map<Character, Integer> characterCount = new HashMap<>();
            for(char c: charInWord){
                characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
            }
            for(Character c: characterCount.keySet()){
                if(maximumCharacterCount.containsKey(c)){
                    if(maximumCharacterCount.get(c) < characterCount.get(c)){
                        maximumCharacterCount.put(c, characterCount.get(c));
                    }
                } else {
                    maximumCharacterCount.put(c, characterCount.get(c));
                }

            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(char c: maximumCharacterCount.keySet()){
            for(int i = 0; i < maximumCharacterCount.get(c); i++){
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString().toCharArray();
    }

}
