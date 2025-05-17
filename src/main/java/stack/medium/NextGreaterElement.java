package stack.medium;

// O(n ^ 2) && O(n)
public class NextGreaterElement {
  public int[] nextGreaterElement(int[] array) {
    int[] greaterElementArray = new int[array.length];

    for (int i = 0; i < array.length; i++) {
      int currentItem = array[i];
      int nextIndex = i + 1;

      while (currentItem >= array[nextIndex % array.length] && nextIndex % array.length != i) {
        nextIndex++;
      }

      if (nextIndex % array.length != i) {
        System.out.println(i + "-" + nextIndex);
        greaterElementArray[i] = array[nextIndex % array.length];
      } else {
        greaterElementArray[i] = -1;
      }
    }
    return greaterElementArray;
  }
}
