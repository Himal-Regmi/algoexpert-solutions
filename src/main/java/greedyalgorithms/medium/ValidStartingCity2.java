package greedyalgorithms.medium;

// O(n) & O(1)
public class ValidStartingCity2 {
  public int validStartingCity(int[] distances, int[] fuel, int mpg) {
    int milageCapacityRemaining = 0;
    int lowestMilageCapacityReachingACity = 0;
    int indexOfCityWithLowestMilageCapacity = 0;

    for (int i = 1; i < distances.length; i++) {
      milageCapacityRemaining = milageCapacityRemaining + ((fuel[i - 1] * mpg) - distances[i - 1]);

      if (milageCapacityRemaining < lowestMilageCapacityReachingACity) {
        lowestMilageCapacityReachingACity = milageCapacityRemaining;
        indexOfCityWithLowestMilageCapacity = i;
      }
    }

    return indexOfCityWithLowestMilageCapacity;
  }
}
