package searching.easy;

// O(logn) && O(1)
public class BinarySearch2 {
  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;

    while (left < right) {
      int middle = (left + right) / 2;
      if (target == array[middle]) {
        return middle;
      } else if (target < array[middle]) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }
    return -1;
  }
}
