package stack.medium;

import java.util.Stack;

// O(n) & O(n)
public class BestDigits {
  public String bestDigits(String number, int numDigits) {
    Stack<Character> topDigitStack = new Stack<Character>();

    for (int i = 0; i < number.length(); i++) {
      char currentCharacter = number.charAt(i);
      while (numDigits > 0 && !topDigitStack.isEmpty() && currentCharacter > topDigitStack.peek()) {
        numDigits--;
        topDigitStack.pop();
      }
      topDigitStack.push(currentCharacter);
    }
    while (numDigits > 0) {
      numDigits--;
      topDigitStack.pop();
    }

    StringBuilder bestDigitString = new StringBuilder();
    while (!topDigitStack.isEmpty()) {
      bestDigitString.append(topDigitStack.pop());
    }
    bestDigitString.reverse();
    return bestDigitString.toString();
  }
}
