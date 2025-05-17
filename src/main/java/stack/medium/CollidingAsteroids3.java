package stack.medium;

import java.util.Stack;

// O(n) and O(n)
public class CollidingAsteroids3 {
  public int[] collidingAsteroids(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();

    for (int asteroid : asteroids) {
      handleCollision(stack, asteroid);
    }

    return stackToArray(stack);
  }

  private void handleCollision(Stack<Integer> stack, int asteroid) {
    while (!stack.isEmpty() && willCollide(stack.peek(), asteroid)) {
      int top = stack.peek();

      if (top == -asteroid) { // Equal size, both explode
        stack.pop();
        return;
      } else if (Math.abs(top) < Math.abs(asteroid)) { // Top explodes
        stack.pop();
      } else { // Current asteroid explodes
        return;
      }
    }
    stack.push(asteroid);
  }

  private boolean willCollide(int a, int b) {
    return a > 0 && b < 0; // Only collides if moving towards each other
  }

  private int[] stackToArray(Stack<Integer> stack) {
    int[] result = new int[stack.size()];
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = stack.pop();
    }
    return result;
  }
}
