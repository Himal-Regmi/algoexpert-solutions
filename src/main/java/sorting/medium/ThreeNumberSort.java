package sorting.medium;

// O(n) & O(1) but two loops i.e 2 * O(n)
public class ThreeNumberSort {
  public int[] threeNumberSort(int[] array, int[] order) {
    int[] valueCount = new int[3];

    for (int i = 0; i < array.length; i++) {
      int index = getIndex(order, array[i]);
      valueCount[index] += 1;
    }

    int currentIndex = 0;

    for (int i = 0; i < array.length; i++) {
      while (valueCount[currentIndex] == 0) {
        currentIndex += 1;
      }
      array[i] = order[currentIndex];
      valueCount[currentIndex] -= 1;
    }
    return array;
  }

  public int getIndex(int[] array, int element) {
    for (int i = 0; i < array.length; i++) {
      if (element == array[i]) return i;
    }
    return -1;
  }
}
