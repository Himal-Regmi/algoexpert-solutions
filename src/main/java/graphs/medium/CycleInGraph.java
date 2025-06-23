package graphs.medium;

// O(v + e) && O(v)
public class CycleInGraph {
  public boolean cycleInGraph(int[][] edges) {
    boolean[] explored = new boolean[edges.length];
    boolean[] inCurrentVisitStack = new boolean[edges.length];

    for (int node = 0; node < edges.length; node++) {
      if (explored[node]) {
        continue;
      }

      boolean containsCycle = isNodeInCycle(node, edges, explored, inCurrentVisitStack);

      if (containsCycle) {
        return true;
      }
    }
    return false;
  }

  public boolean isNodeInCycle(
      int node, int[][] edges, boolean[] explored, boolean[] inCurrentVisitStack) {
    explored[node] = true;
    inCurrentVisitStack[node] = true;

    boolean containsCycle = false;
    for (int descendant : edges[node]) {
      if (!explored[descendant]) {
        containsCycle = isNodeInCycle(descendant, edges, explored, inCurrentVisitStack);
      }

      if (containsCycle) {
        return true;
      } else if (inCurrentVisitStack[descendant]) {
        return true;
      }
    }
    inCurrentVisitStack[node] = false;
    return false;
  }
}
