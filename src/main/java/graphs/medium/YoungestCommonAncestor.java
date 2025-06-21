package graphs.medium;

// O(d) and O(n)
import java.util.HashSet;
import java.util.Set;

public class YoungestCommonAncestor {
  public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
    Set<AncestralTree> ancestorsVisited = new HashSet<>();
    AncestralTree currentAncestor = descendantOne;
    while (currentAncestor != null) {
      ancestorsVisited.add(currentAncestor);
      currentAncestor = currentAncestor.ancestor;
    }
    currentAncestor = descendantTwo;

    while (currentAncestor != null) {
      if (ancestorsVisited.contains(currentAncestor)) {
        return currentAncestor;
      }
      currentAncestor = currentAncestor.ancestor;
    }

    return topAncestor;
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
