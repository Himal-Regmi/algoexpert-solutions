package stack.medium;

import java.util.ArrayList;

// O(n) & O(n)
public class SunsetViews {
  public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
    ArrayList<Integer> buildingWithSunsetView = new ArrayList<>();
    if (buildings.length == 0) {
      return buildingWithSunsetView;
    }

    int maxHeight = 0;
    for (int i = 0; i < buildings.length; i++) {
      if (direction.equals("EAST")) {
        if (buildings[buildings.length - (i + 1)] > maxHeight) {
          buildingWithSunsetView.add(0, buildings.length - (i + 1));
          maxHeight = buildings[buildings.length - (i + 1)];
        }
      } else {
        if (buildings[i] > maxHeight) {
          buildingWithSunsetView.add(i);
          maxHeight = buildings[i];
        }
      }
    }
    return buildingWithSunsetView;
  }
}
