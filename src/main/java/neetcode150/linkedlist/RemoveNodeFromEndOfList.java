package neetcode150.linkedlist;

public class RemoveNodeFromEndOfList {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      int length = 0;
      ListNode node = head;
      while (node != null) {
        length++;
        node = node.next;
      }
      int nodeToRemoveFromStart = length - n;

      if (nodeToRemoveFromStart == 0) {
        head = head.next;
        return head;
      }

      ListNode previousNode = null;
      ListNode currentNode = head;

      while (nodeToRemoveFromStart != 0) {
        ListNode temp = currentNode;
        currentNode = currentNode.next;
        previousNode = temp;
        nodeToRemoveFromStart--;
      }

      ListNode temp = currentNode;
      previousNode.next = currentNode.next;
      temp.next = null;

      return head;
    }
  }

  // O(n) & O(1)
  class Solution2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(0, head);
      ListNode leftNode = dummy;
      ListNode rightNode = head;

      for (int i = 0; i < n; i++) {
        rightNode = rightNode.next;
      }

      while (rightNode != null) {
        leftNode = leftNode.next;
        rightNode = rightNode.next;
      }

      leftNode.next = leftNode.next.next;

      return dummy.next;
    }
  }
}
