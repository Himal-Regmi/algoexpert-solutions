package graphs.medium;

import java.util.Stack;

// O(v + e) && O(v)
public class TwoColorable {
  public boolean twoColorable(int[][] edges) {
    int[] vertexColours = new int[edges.length];
    vertexColours[0] = 1;
    Stack<Integer> vertexStack = new Stack<>();
    vertexStack.add(0);

    while (!vertexStack.empty()) {
      int vertex = vertexStack.pop();
      for (int edge : edges[vertex]) {
        if (vertexColours[edge] == 0) {
          vertexColours[edge] = vertexColours[vertex] == 1 ? 2 : 1;
          vertexStack.add(edge);
        } else {
          if (vertexColours[edge] == vertexColours[vertex]) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
