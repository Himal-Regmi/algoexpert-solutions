package sorting.easy;

// Best     - O(n) && O(1)
// Average  - O(n ^ 2) && O(1)
// Worst    - O(n ^ 2) && O(1)
public class BubbleSort {
  public static int[] bubbleSort(int[] array) {
    int counter = 0;
    boolean arraySorted = false;
    while (!arraySorted) {
      arraySorted = true;
      for (int i = 1; i < array.length - counter; i++) {
        if (array[i] < array[i - 1]) {
          swapData(array, i, i - 1);
          arraySorted = false;
        }
      }
      counter++;
    }
    return array;
  }

  public static void swapData(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
