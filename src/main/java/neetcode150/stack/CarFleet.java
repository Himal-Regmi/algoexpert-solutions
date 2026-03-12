package neetcode150.stack;

import java.util.Arrays;

public class CarFleet {
  record Car(int speed, int position) {}

  // O(nlogn) & O(n);
  class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
      Car[] cars = new Car[position.length];
      for (int i = 0; i < position.length; i++) {
        cars[i] = new Car(speed[i], position[i]);
      }
      Arrays.sort(cars, (a, b) -> Integer.compare(b.position(), a.position()));

      double maxTime = -1;
      int fleetCount = 0;

      for (int i = 0; i < cars.length; i++) {
        double timeTaken = (double) (target - cars[i].position()) / cars[i].speed();
        if (maxTime < timeTaken) {
          maxTime = timeTaken;
          fleetCount++;
        }
      }
      return fleetCount;
    }
  }
}
