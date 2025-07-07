package searching.easy;

import java.util.Arrays;

// O(n) & O(1)
public class FindThreeLargestNumbers {
  public static int[] findThreeLargestNumbers(int[] array) {
    int[] threeLargestNumbers = new int[3];
    Arrays.fill(threeLargestNumbers, Integer.MIN_VALUE);
    for (int x : array) {
      for (int i = threeLargestNumbers.length - 1; i >= 0; i--) {
        if (x > threeLargestNumbers[i]) {
          int idx = 0;
          while (idx < i) {
            threeLargestNumbers[idx] = threeLargestNumbers[idx + 1];
            idx++;
          }
          threeLargestNumbers[i] = x;
          break;
        }
      }
    }
    return threeLargestNumbers;
  }
}
