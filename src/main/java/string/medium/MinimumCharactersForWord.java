package string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCharactersForWord {
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

        List<Character> listOfMaximumCharacter = new ArrayList<>();

        for(char c: maximumCharacterCount.keySet()){
            for(int i = 0; i < maximumCharacterCount.get(c); i++){
                listOfMaximumCharacter.add(c);
            }
        }

        char[] arrayOfMaximumCharacter = new char[listOfMaximumCharacter.size()];

        for(int i = 0; i < listOfMaximumCharacter.size(); i++){
            arrayOfMaximumCharacter[i] = listOfMaximumCharacter.get(i);
        }

        return arrayOfMaximumCharacter;
    }

}
