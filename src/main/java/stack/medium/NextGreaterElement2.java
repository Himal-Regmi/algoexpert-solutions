package stack.medium;

import java.util.Arrays;
import java.util.Stack;

// O(n) and O(n)
public class NextGreaterElement2 {
  public int[] nextGreaterElement(int[] array) {
    int[] greaterElementArray = new int[array.length];
    Arrays.fill(greaterElementArray, -1);

    Stack<Integer> indexToBeFilled = new Stack<>();

    for (int i = 0; i < array.length * 2; i++) {
      int normalizedIndex = i % array.length;

      while (!indexToBeFilled.isEmpty() && array[normalizedIndex] > array[indexToBeFilled.peek()]) {
        greaterElementArray[indexToBeFilled.pop()] = array[normalizedIndex];
      }

      indexToBeFilled.push(normalizedIndex);
    }
    return greaterElementArray;
  }
}
