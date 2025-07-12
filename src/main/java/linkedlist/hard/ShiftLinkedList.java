package linkedlist.hard;

// O(n) & O(1)
public class ShiftLinkedList {
  public static LinkedList shiftLinkedList(LinkedList head, int k) {
    LinkedList tail = head;
    int length = 1;
    while (tail.next != null) {
      tail = tail.next;
      length++;
    }
    k = k % length;
    k = k > 0 ? k - length : k;

    while (k < 0) {
      LinkedList newHead = head.next;
      tail.next = head;
      head.next = null;
      tail = head;
      head = newHead;
      k += 1;
    }
    return head;
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}
