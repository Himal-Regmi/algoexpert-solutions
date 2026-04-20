package neetcode150.linkedlist;

import java.util.Stack;

public class ReorderLinkedList {
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

  // O(n) & O(n)
  class Solution {
    public void reorderList(ListNode head) {

      if (head == null || head.next == null) return;
      Stack<ListNode> stack = new Stack<>();
      ListNode currentNode = head;
      int length = 0;

      while (currentNode != null) {
        length++;
        stack.push(currentNode);
        currentNode = currentNode.next;
      }

      ListNode leftNode = head;

      int nodeAdded = 0;
      while (nodeAdded < length - 1) {
        ListNode tempNode = leftNode.next;
        ListNode rightNode = stack.pop();
        leftNode.next = rightNode;
        rightNode.next = tempNode;
        leftNode = tempNode;
        nodeAdded += 2;
      }
      leftNode.next = null;
    }
  }

  // O(n) & O(1)
  class Solution2 {
    public void reorderList(ListNode head) {

      if (head == null || head.next == null) return;

      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      ListNode secondHalf = slow.next;
      slow.next = null;
      ListNode firstHalf = head;

      ListNode prevNode = null;
      ListNode currentNode = secondHalf;

      while (currentNode != null) {
        ListNode nextNode = currentNode.next;
        currentNode.next = prevNode;
        prevNode = currentNode;
        currentNode = nextNode;
      }

      ListNode reversedSecondHalf = prevNode;

      ListNode p1 = firstHalf;
      ListNode p2 = reversedSecondHalf;

      while (p2 != null) {
        ListNode temp1 = p1.next;
        ListNode temp2 = p2.next;

        p1.next = p2;
        p2.next = temp1;

        p1 = temp1;
        p2 = temp2;
      }
    }
  }
}
