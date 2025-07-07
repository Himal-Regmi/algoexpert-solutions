package sorting.easy;

// Best     - O(n) && O(1)
// Average  - O(n ^ 2) && O(1)
// Worst    - O(n ^ 2) && O(1)
public class InsertionSort {
  public static int[] insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      for (int j = i; j > 0; j--) {
        if (array[j] < array[j - 1]) {
          swapData(array, j, j - 1);
        } else {
          break;
        }
      }
    }
    return array;
  }

  public static void swapData(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
