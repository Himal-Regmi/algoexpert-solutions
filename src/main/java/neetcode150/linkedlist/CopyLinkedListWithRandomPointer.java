package neetcode150.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyLinkedListWithRandomPointer {

  // Definition for a Node.
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

  class Solution {
    public Node copyRandomList(Node head) {
      Map<Node, Node> copyMap = new HashMap<>();
      Node currentNode = head;
      while (currentNode != null) {
        copyMap.put(currentNode, new Node(currentNode.val));
        currentNode = currentNode.next;
      }

      currentNode = head;
      while (currentNode != null) {
        Node copyOfCurrentNode = copyMap.get(currentNode);
        Node nextOfCurrentNode = currentNode.next;
        Node randomOfCurrentNode = currentNode.random;

        if (nextOfCurrentNode != null) {
          copyOfCurrentNode.next = copyMap.get(nextOfCurrentNode);
        }

        if (randomOfCurrentNode != null) {
          copyOfCurrentNode.random = copyMap.get(randomOfCurrentNode);
        }

        currentNode = currentNode.next;
      }

      return copyMap.get(head);
    }
  }
}
