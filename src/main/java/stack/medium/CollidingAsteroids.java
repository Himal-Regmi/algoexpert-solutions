package stack.medium;

import java.util.ArrayList;

// O(n) and O(n)
public class CollidingAsteroids {
  public int[] collidingAsteroids(int[] asteroids) {
    ArrayList<Integer> nonCollidingAsteroids = new ArrayList<>();
    nonCollidingAsteroids.add(asteroids[0]);

    for (int i = 1; i < asteroids.length; i++) {
      int latestAsteroid = asteroids[i];
      int previousAsteroid = nonCollidingAsteroids.get(nonCollidingAsteroids.size() - 1);

      while (!nonCollidingAsteroids.isEmpty()
          && nonCollidingAsteroids.get(nonCollidingAsteroids.size() - 1) > 0
          && latestAsteroid < 0
          && Math.abs(latestAsteroid)
              > Math.abs(nonCollidingAsteroids.get(nonCollidingAsteroids.size() - 1))) {
        nonCollidingAsteroids.remove(nonCollidingAsteroids.size() - 1);
        if (!nonCollidingAsteroids.isEmpty()) {
          previousAsteroid = nonCollidingAsteroids.get(nonCollidingAsteroids.size() - 1);
        }
      }
      if (nonCollidingAsteroids.isEmpty() || !(previousAsteroid > 0 && latestAsteroid < 0)) {
        nonCollidingAsteroids.add(latestAsteroid);
      }
      if (previousAsteroid > 0 && latestAsteroid < 0 && previousAsteroid + latestAsteroid == 0) {
        nonCollidingAsteroids.remove(nonCollidingAsteroids.size() - 1);
      }
    }

    int[] remainingAsteroids = new int[nonCollidingAsteroids.size()];
    for (int i = 0; i < nonCollidingAsteroids.size(); i++) {
      remainingAsteroids[i] = nonCollidingAsteroids.get(i);
    }
    return remainingAsteroids;
  }
}
