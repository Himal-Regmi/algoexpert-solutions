package linkedlist.hard;

// O(n + m) && O(1)
public class MergeLinkedList {
  // This is an input class. Do not edit.
  public static class LinkedList {
    int value;
    LinkedList next;

    LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
    LinkedList headNode = headOne.value < headTwo.value ? headOne : headTwo;

    LinkedList otherNode = headNode == headOne ? headTwo : headOne;

    LinkedList currentNode = headNode;

    while (currentNode.next != null) {
      if (currentNode.next.value < otherNode.value) {
        currentNode = currentNode.next;
      } else {
        LinkedList tempOtherNode = currentNode.next;
        currentNode.next = otherNode;
        currentNode = currentNode.next;
        otherNode = tempOtherNode;
      }
    }

    currentNode.next = otherNode;

    return headNode;
  }
}
