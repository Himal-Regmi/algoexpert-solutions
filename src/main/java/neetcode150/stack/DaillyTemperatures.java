package neetcode150.stack;

import java.util.Stack;

public class DaillyTemperatures {
  // O(n ^ 2) & O(n)
  class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      int[] result = new int[temperatures.length];
      for (int i = 0; i < temperatures.length; i++) {
        for (int j = i + 1; j < temperatures.length; j++) {
          if (temperatures[j] > temperatures[i]) {
            result[i] = j - i;
            break;
          }
        }
      }
      return result;
    }
  }

  // O(n) & O(n)
  class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
      int[] result = new int[temperatures.length];
      Stack<Integer> indicesStack = new Stack<>();

      for (int i = 0; i < temperatures.length; i++) {
        while (!indicesStack.isEmpty() && temperatures[indicesStack.peek()] < temperatures[i]) {
          int smallerValueIndex = indicesStack.pop();
          result[smallerValueIndex] = i - smallerValueIndex;
        }
        indicesStack.push(i);
      }
      return result;
    }
  }
}
