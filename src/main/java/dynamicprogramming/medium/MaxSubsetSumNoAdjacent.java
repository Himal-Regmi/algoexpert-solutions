package dynamicprogramming.medium;

// O(n) & O(n)
public class MaxSubsetSumNoAdjacent {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    int[] maxSums = new int[array.length];
    int maxSum = 0;

    for (int i = 0; i < array.length; i++) {
      if (i < 2) {
        maxSums[i] = Math.max(array[i], maxSum);
      } else {
        maxSums[i] = Math.max(maxSum, maxSums[i - 2] + array[i]);
      }
      maxSum = maxSums[i];
    }

    return maxSum;
  }
}
