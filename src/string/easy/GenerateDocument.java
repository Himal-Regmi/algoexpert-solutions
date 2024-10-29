package string.easy;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {
    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> charactersCharMap = new HashMap<Character, Integer>();
        Map<Character, Integer> documentCharMap = new HashMap<Character, Integer>();

        for (char c : characters.toCharArray()) {
            if (charactersCharMap.containsKey(c)) {
                int updatedCount = charactersCharMap.get(c) + 1;
                charactersCharMap.put(c, updatedCount);
            } else {
                charactersCharMap.put(c, 1);
            }
        }

        for (char c : document.toCharArray()) {
            if (documentCharMap.containsKey(c)) {
                int updatedCount = documentCharMap.get(c) + 1;
                documentCharMap.put(c, updatedCount);
            } else {
                documentCharMap.put(c, 1);
            }
        }

        for (char c : documentCharMap.keySet()) {
            if (!charactersCharMap.containsKey(c)) {
                return false;
            } else if (charactersCharMap.get(c) < documentCharMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
