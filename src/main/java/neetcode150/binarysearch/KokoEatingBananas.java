package neetcode150.binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {
  // O(nlogm) & O(n)
  class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int minSpeed = 1;
      int maxSpeed = Arrays.stream(piles).max().getAsInt();
      int result = maxSpeed;

      while (maxSpeed >= minSpeed) {
        int speed = minSpeed + ((maxSpeed - minSpeed) / 2);

        long eatingTime = 0;
        for (int pile : piles) {
          eatingTime += (long) Math.ceil((double) pile / speed);
        }

        if (eatingTime > h) {
          minSpeed = speed + 1;
        } else {
          result = Math.min(result, speed);
          maxSpeed = speed - 1;
        }
      }

      return result;
    }
  }
}
