package greedyalgorithms.medium;

// O(n^2) & O(1)
public class ValidStartingCity {
  public int validStartingCity(int[] distances, int[] fuel, int mpg) {
    for (int i = 0; i < distances.length; i++) {
      int remainingFuelAfterRide = getRemainingFuelAfterRide(i, distances, fuel, mpg);
      if (remainingFuelAfterRide >= 0) return i;
    }
    return -1;
  }

  public int getRemainingFuelAfterRide(
      int startingCityIndex, int[] distances, int[] fuel, int mpg) {
    int remainingFuel = (fuel[startingCityIndex] * mpg) - distances[startingCityIndex];

    for (int i = startingCityIndex + 1; i < distances.length + startingCityIndex; i++) {
      System.out.println(remainingFuel);
      if (remainingFuel < 0) return -1;
      int index = i % distances.length;
      remainingFuel = remainingFuel + (fuel[index] * mpg) - distances[index];
    }

    return remainingFuel;
  }
}
