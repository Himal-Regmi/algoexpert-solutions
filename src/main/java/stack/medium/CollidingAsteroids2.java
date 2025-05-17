package stack.medium;

import java.util.Stack;

// O(n) and O(n)
public class CollidingAsteroids2 {
  public int[] collidingAsteroids(int[] asteroids) {
    Stack<Integer> nonCollidingAsteroids = new Stack<>();

    for (int asteroid : asteroids) {
      if (nonCollidingAsteroids.isEmpty()) {
        nonCollidingAsteroids.push(asteroid);
        continue;
      }
      while (true) {
        if (nonCollidingAsteroids.peek() > 0 && asteroid < 0) {
          if (nonCollidingAsteroids.peek() + asteroid == 0) {
            nonCollidingAsteroids.pop();
            break;
          } else if (Math.abs(nonCollidingAsteroids.peek()) < Math.abs(asteroid)) {
            nonCollidingAsteroids.pop();
            if (nonCollidingAsteroids.isEmpty()) {
              nonCollidingAsteroids.push(asteroid);
              break;
            }
          } else {
            break;
          }
        } else {
          nonCollidingAsteroids.push(asteroid);
          break;
        }
      }
    }

    int[] remainingAsteroids = new int[nonCollidingAsteroids.size()];
    for (int i = nonCollidingAsteroids.size() - 1; i >= 0; i--) {
      remainingAsteroids[i] = nonCollidingAsteroids.pop();
    }
    return remainingAsteroids;
  }
}
