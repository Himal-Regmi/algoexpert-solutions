package graphs.medium;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    // O(V + E) & O(V)
    public List<String> breadthFirstSearch(List<String> array) {
      ArrayList<Node> nodeListToExplore = new ArrayList<>();
      nodeListToExplore.add(this);

      while (!nodeListToExplore.isEmpty()) {
        Node nodeToAdd = nodeListToExplore.get(0);
        array.add(nodeToAdd.name);
        nodeListToExplore.addAll(nodeToAdd.children);
        nodeListToExplore.remove(0);
      }

      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
