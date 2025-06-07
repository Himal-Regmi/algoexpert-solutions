package graphs.medium;

// O(n) and O(1)
public class hasSingleCycle2 {
  public static boolean hasSingleCycle(int[] array) {
    int currentIndex = 0;
    currentIndex = (currentIndex + array[currentIndex]) % array.length;

    int indexVisited = 1;

    while (indexVisited < array.length) {
      currentIndex = currentIndex < 0 ? array.length + currentIndex : currentIndex;
      if (currentIndex == 0) {
        return false;
      }
      indexVisited += 1;
      currentIndex = (currentIndex + array[currentIndex]) % array.length;
    }

    return currentIndex == 0;
  }
}
