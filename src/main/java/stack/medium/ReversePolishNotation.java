package stack.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// O(n) and O(n)
public class ReversePolishNotation {
  public int reversePolishNotation(String[] tokens) {
    Set<String> operators = new HashSet<>(Set.of("*", "+", "-", "/"));
    Stack<Integer> operationStack = new Stack<>();

    for (String token : tokens) {
      if (operators.contains(token)) {
        int latestItem = operationStack.pop();
        int previousItem = operationStack.pop();
        int result;
        switch (token) {
          case "+":
            result = previousItem + latestItem;
            break;
          case "-":
            result = previousItem - latestItem;
            break;
          case "*":
            result = previousItem * latestItem;
            break;
          case "/":
            result = previousItem / latestItem;
            break;
          default:
            throw new IllegalArgumentException("Unknown operator: " + token);
        }
        operationStack.push(result);
      } else {
        operationStack.push(Integer.parseInt(token));
      }
    }
    return operationStack.pop();
  }
}
