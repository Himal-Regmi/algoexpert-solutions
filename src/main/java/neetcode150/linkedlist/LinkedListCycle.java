package neetcode150.linkedlist;

public class LinkedListCycle {

  /** Definition for singly-linked list. */
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  // O(n) & O(1)
  class Solution {
    public boolean hasCycle(ListNode head) {
      ListNode fastNode = head;
      while (fastNode != null && fastNode.next != null) {
        if (head.next == fastNode.next.next) {
          return true;
        }
        head = head.next;
        fastNode = fastNode.next.next;
      }
      return false;
    }
  }
}
