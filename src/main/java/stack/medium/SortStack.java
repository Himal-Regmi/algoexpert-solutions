package stack.medium;

import java.util.ArrayList;

// O(n^2) && O(n)
public class SortStack {
  public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
    if (stack.isEmpty()) {
      return stack;
    }
    int poppedItem = pop(stack);

    sortStack(stack);

    addItemToSortedStack(stack, poppedItem);

    return stack;
  }

  public void addItemToSortedStack(ArrayList<Integer> stack, int itemToAdd) {
    if (!stack.isEmpty()) {
      if (stack.get(stack.size() - 1) <= itemToAdd) {
        stack.add(itemToAdd);
      } else {
        int poppedItem = pop(stack);
        addItemToSortedStack(stack, itemToAdd);
        stack.add(poppedItem);
      }
    } else {
      stack.add(itemToAdd);
      return;
    }
  }

  public int pop(ArrayList<Integer> stack) {
    int lastItem = stack.get(stack.size() - 1);
    stack.remove(stack.size() - 1);
    return lastItem;
  }
}
