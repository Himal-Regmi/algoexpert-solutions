package neetcode150.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
  class Solution {
    public int evalRPN(String[] tokens) {

      Stack<Integer> stack = new Stack<>();

      for (String token : tokens) {

        switch (token) {
          case "+":
            stack.push(stack.pop() + stack.pop());
            break;
          case "-":
            int secondNumSub = stack.pop();
            int firstNumSub = stack.pop();
            stack.push(firstNumSub - secondNumSub);
            break;
          case "*":
            stack.push(stack.pop() * stack.pop());
            break;
          case "/":
            int secondNumDiv = stack.pop();
            int firstNumDiv = stack.pop();
            stack.push(firstNumDiv / secondNumDiv);
            break;
          default:
            stack.push(Integer.parseInt(token));
            break;
        }
      }

      return stack.pop();
    }
  }
}
