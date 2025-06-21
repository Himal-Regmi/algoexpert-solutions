package graphs.medium;

// O(d) and O(1)
public class YoungestCommonAncestor2 {
  public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
    int depthOne = getTreeDepth(descendantOne, topAncestor);
    int depthTwo = getTreeDepth(descendantTwo, topAncestor);

    AncestralTree lowerDescendant = depthOne > depthTwo ? descendantOne : descendantTwo;
    AncestralTree higherDescendant = depthOne > depthTwo ? descendantTwo : descendantOne;

    int diff = Math.abs(depthOne - depthTwo);

    return backtrackCommonAncestor(diff, lowerDescendant, higherDescendant);
  }

  public static int getTreeDepth(AncestralTree tree, AncestralTree topAncestor) {
    int depth = 0;
    while (tree != topAncestor) {
      depth++;
      tree = tree.ancestor;
    }
    return depth;
  }

  public static AncestralTree backtrackCommonAncestor(
      int diff, AncestralTree lowerDescendant, AncestralTree higherDescendant) {
    while (diff > 0) {
      lowerDescendant = lowerDescendant.ancestor;
      diff--;
    }
    while (lowerDescendant != higherDescendant) {
      lowerDescendant = lowerDescendant.ancestor;
      higherDescendant = higherDescendant.ancestor;
    }
    return lowerDescendant;
  }

  static class AncestralTree {
    public char name;
    public AncestralTree ancestor;

    AncestralTree(char name) {
      this.name = name;
      this.ancestor = null;
    }

    // This method is for testing only.
    void addAsAncestor(AncestralTree[] descendants) {
      for (AncestralTree descendant : descendants) {
        descendant.ancestor = this;
      }
    }
  }
}
