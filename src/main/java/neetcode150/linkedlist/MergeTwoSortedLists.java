package neetcode150.linkedlist;

public class MergeTwoSortedLists {
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

  class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      if (list1 == null) {
        return list2;
      }
      if (list2 == null) {
        return list1;
      }
      ListNode smallestNode = list1.val < list2.val ? list1 : list2;
      ListNode waitingNode = list1.val < list2.val ? list2 : list1;

      ListNode currentNode = smallestNode;

      while (waitingNode != null) {
        if (currentNode.next == null || currentNode.next.val > waitingNode.val) {
          ListNode tempNode = currentNode.next;
          currentNode.next = waitingNode;
          waitingNode = tempNode;
        } else {
          currentNode = currentNode.next;
        }
      }

      return smallestNode;
    }
  }
}
