package stack.medium;

import java.util.ArrayList;

public class MinMaxStackSolution {
  static class MinMaxStack {
    ArrayList<Integer> stack = new ArrayList<>();
    ArrayList<Integer> maxStack = new ArrayList<>();
    ArrayList<Integer> minStack = new ArrayList<>();

    public int peek() {
      return stack.get(stack.size() - 1);
    }

    public int pop() {
      int top = stack.get(stack.size() - 1);
      stack.remove(stack.size() - 1);
      maxStack.remove(maxStack.size() - 1);
      minStack.remove(minStack.size() - 1);
      return top;
    }

    public void push(Integer number) {
      stack.add(number);
      int max = number;
      int min = number;
      if (stack.size() > 1) {
        max = max > maxStack.get(maxStack.size() - 1) ? max : maxStack.get(maxStack.size() - 1);
        min = min < minStack.get(minStack.size() - 1) ? min : minStack.get(maxStack.size() - 1);
      }
      maxStack.add(max);
      minStack.add(min);
    }

    public int getMin() {
      return minStack.get(minStack.size() - 1);
    }

    public int getMax() {
      return maxStack.get(maxStack.size() - 1);
    }
  }
}
