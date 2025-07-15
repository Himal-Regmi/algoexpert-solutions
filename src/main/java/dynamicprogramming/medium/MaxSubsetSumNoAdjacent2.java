package dynamicprogramming.medium;

// O(n) & O(1)
public class MaxSubsetSumNoAdjacent2 {
  public static int maxSubsetSumNoAdjacent(int[] array) {
    if (array.length == 0) {
      return 0;
    } else if (array.length == 1) {
      return array[0];
    }

    int firstMaxSum = array[0];
    int secondMaxSum = Math.max(array[0], array[1]);

    for (int i = 2; i < array.length; i++) {
      int currentMaxSum = Math.max(secondMaxSum, firstMaxSum + array[i]);
      firstMaxSum = secondMaxSum;
      secondMaxSum = currentMaxSum;
    }

    return secondMaxSum;
  }
}
