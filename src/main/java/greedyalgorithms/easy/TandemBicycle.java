package greedyalgorithms.easy;

import java.util.Arrays;

// O(nlogn) && O(1)
public class TandemBicycle {
  public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
    Arrays.sort(redShirtSpeeds);
    Arrays.sort(blueShirtSpeeds);

    int totalSpeed = 0;

    for (int i = 0; i < redShirtSpeeds.length; i++) {
      if (fastest) {
        totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[blueShirtSpeeds.length - i - 1]);
      } else {
        totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
      }
    }

    return totalSpeed;
  }
}
