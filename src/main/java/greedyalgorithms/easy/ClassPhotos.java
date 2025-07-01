package greedyalgorithms.easy;

import java.util.ArrayList;
import java.util.Collections;

// O(nlogn) && O(1)
public class ClassPhotos {
  public boolean classPhotos(
      ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
    Collections.sort(redShirtHeights);
    Collections.sort(blueShirtHeights);

    ArrayList<Integer> tallerGroup =
        redShirtHeights.get(0) > blueShirtHeights.get(0) ? redShirtHeights : blueShirtHeights;
    ArrayList<Integer> shorterGroup =
        tallerGroup == redShirtHeights ? blueShirtHeights : redShirtHeights;

    for (int i = 0; i < tallerGroup.size(); i++) {
      if (tallerGroup.get(i) <= shorterGroup.get(i)) {
        return false;
      }
    }
    return true;
  }
}
