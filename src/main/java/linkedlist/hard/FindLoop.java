package linkedlist.hard;

// O(n) && O(1)
public class FindLoop {
  public static LinkedList findLoop(LinkedList head) {
    LinkedList fastPointer = head.next.next;
    LinkedList slowPointer = head.next;

    while (fastPointer != slowPointer) {
      fastPointer = fastPointer.next.next;
      slowPointer = slowPointer.next;
    }

    slowPointer = head;

    while (fastPointer != slowPointer) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next;
    }

    return slowPointer;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
