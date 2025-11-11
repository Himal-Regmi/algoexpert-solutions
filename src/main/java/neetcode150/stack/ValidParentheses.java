package neetcode150.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
  class Solution {
    public boolean isValid(String s) {
      Map<Character, Character> parenthesesMap = new HashMap<>();
      parenthesesMap.put('(', ')');
      parenthesesMap.put('{', '}');
      parenthesesMap.put('[', ']');

      Stack<Character> parenthesesStack = new Stack<>();

      for (char c : s.toCharArray()) {
        if (parenthesesMap.containsKey(c)) {
          parenthesesStack.push(c);
        } else if (!parenthesesStack.isEmpty()
            && c == parenthesesMap.get(parenthesesStack.peek())) {
          parenthesesStack.pop();
        } else {
          return false;
        }
      }

      return parenthesesStack.isEmpty();
    }
  }
}
