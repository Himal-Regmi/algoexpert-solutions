package graphs.medium;

import java.util.HashSet;

// O(n) and O(n)
public class hasSingleCycle {
  public static boolean hasSingleCycle(int[] array) {
    HashSet<Integer> indexVisited = new HashSet<>();

    int currentIndex = 0;

    currentIndex = (currentIndex + array[currentIndex]) % array.length;

    while (indexVisited.size() < array.length) {
      currentIndex = currentIndex < 0 ? array.length + currentIndex : currentIndex;
      System.out.println(currentIndex);
      if (indexVisited.contains(currentIndex)) {
        return false;
      }
      indexVisited.add(currentIndex);
      currentIndex = (currentIndex + array[currentIndex]) % array.length;
    }

    return true;
  }
}
