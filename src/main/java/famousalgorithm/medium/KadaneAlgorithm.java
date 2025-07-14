package famousalgorithm.medium;

// Algorithm to find maximum sum of sub-array.
// O(n) and O(1);
public class KadaneAlgorithm {
  public static int kadanesAlgorithm(int[] array) {
    int sum = array[0];
    int maxSum = array[0];
    for (int i = 1; i < array.length; i++) {
      int num = array[i];

      sum = Math.max(num, sum + num);
      maxSum = Math.max(maxSum, sum);
    }
    return maxSum;
  }
}
