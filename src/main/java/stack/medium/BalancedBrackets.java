package stack.medium;

import java.util.*;

// O(n) & O(n)
public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put('(', ')');
        bracketPairs.put('[', ']');
        bracketPairs.put('{', '}');

        Set<Character> brackets = new HashSet<>(Set.of('(', '[', '{', ')', ']', '}'));

        ArrayList<Character> bracketStack = new ArrayList<>();
        char[] givenStringChar = str.toCharArray();

        for (int i = 0; i <givenStringChar.length; i++ ) {
            if (!brackets.contains(givenStringChar[i])) {
                continue;
            }
            if (bracketPairs.containsKey(givenStringChar[i])){
                bracketStack.add(givenStringChar[i]);
            } else {
                if (bracketStack.size() == 0){
                    return false;
                } else if (givenStringChar[i] == bracketPairs.get(bracketStack.get(bracketStack.size() - 1))){
                    bracketStack.remove(bracketStack.size() - 1);
                } else {
                    return false;
                }

            }
        }
        return bracketStack.size() == 0;
    }
}
