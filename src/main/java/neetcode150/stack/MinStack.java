package neetcode150.stack;

import java.util.ArrayList;

public class MinStack {
  class MinStackSolution {
    ArrayList<Integer> stack;
    ArrayList<Integer> minStack;

    public MinStackSolution() {
      stack = new ArrayList<>();
      minStack = new ArrayList<>();
    }

    public void push(int val) {
      stack.add(val);
      if (!minStack.isEmpty()) {
        minStack.add(Math.min(minStack.getLast(), val));
      } else {
        minStack.add(val);
      }
    }

    public void pop() {
      stack.removeLast();
      minStack.removeLast();
    }

    public int top() {
      return stack.getLast();
    }

    public int getMin() {
      return minStack.get(stack.size() - 1);
    }
  }
}
