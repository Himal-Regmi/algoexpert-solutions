package linkedlist.hard;

// O(n) && O(1)
public class ReverseLinkedList {
  public static LinkedList reverseLinkedList(LinkedList head) {
    LinkedList currentNode = head;
    LinkedList nextNode = head.next;

    while (nextNode != null) {
      currentNode.next = nextNode.next;
      nextNode.next = head;
      head = nextNode;
      nextNode = currentNode.next;
    }
    return head;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
