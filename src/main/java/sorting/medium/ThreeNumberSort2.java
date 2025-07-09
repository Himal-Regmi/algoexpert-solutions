package sorting.medium;

// O(n) & O(1)
public class ThreeNumberSort2 {
  public int[] threeNumberSort(int[] array, int[] order) {
    int firstValueIndex = 0;
    int secondValueIndex = 0;
    int lastValueIndex = array.length - 1;

    while (secondValueIndex <= lastValueIndex) {
      int value = array[secondValueIndex];
      if (value == order[0]) {
        swapData(array, secondValueIndex, firstValueIndex);
        firstValueIndex += 1;
        secondValueIndex += 1;
      } else if (value == order[1]) {
        swapData(array, secondValueIndex, secondValueIndex);
        secondValueIndex += 1;
      } else {
        swapData(array, secondValueIndex, lastValueIndex);
        lastValueIndex -= 1;
      }
    }

    return array;
  }

  public void swapData(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
