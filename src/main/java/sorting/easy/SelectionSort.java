package sorting.easy;

// Best     - O(n ^ 2) && O(1)
// Average  - O(n ^ 2) && O(1)
// Worst    - O(n ^ 2) && O(1)
public class SelectionSort {
  public static int[] selectionSort(int[] array) {
    int startingIndex = 0;

    while (startingIndex < array.length - 1) {
      int indexOfCurrentSmallestNumber = startingIndex;
      for (int i = startingIndex + 1; i < array.length; i++) {
        if (array[i] < array[indexOfCurrentSmallestNumber]) {
          indexOfCurrentSmallestNumber = i;
        }
      }
      swapData(array, startingIndex, indexOfCurrentSmallestNumber);
      startingIndex++;
    }
    return array;
  }

  public static void swapData(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
