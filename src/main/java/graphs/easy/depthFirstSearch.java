package graphs.easy;

import java.util.ArrayList;
import java.util.List;

public class depthFirstSearch {
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    // O(v + e) & O(V)
    public List<String> depthFirstSearch(List<String> array) {
      array.add(this.name);
      for (Node node : this.children) {
        node.depthFirstSearch(array);
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
