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
}
