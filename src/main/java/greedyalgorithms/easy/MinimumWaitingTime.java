package greedyalgorithms.easy;

import java.util.Arrays;

// O(n) and O(1)
public class MinimumWaitingTime {
  public int minimumWaitingTime(int[] queries) {
    Arrays.sort(queries);
    int minimumWaitingTime = 0;
    int currentWaitingTime = 0;
    for (int i = 1; i < queries.length; i++) {
      currentWaitingTime += queries[i - 1];
      minimumWaitingTime += currentWaitingTime;
    }
    return minimumWaitingTime;
  }
}
