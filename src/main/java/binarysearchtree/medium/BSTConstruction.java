package binarysearchtree.medium;

public class BSTConstruction {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    // AVG - O(logn) and O(1)
    // WORST - O(n) and O(1)
    public BST insert(int value) {
      BST currentNode = this;
      while (true) {
        if (value < currentNode.value) {
          if (currentNode.left == null) {
            currentNode.left = new BST(value);
            break;
          }
          currentNode = currentNode.left;
        } else {
          if (currentNode.right == null) {
            currentNode.right = new BST(value);
            break;
          }
          currentNode = currentNode.right;
        }
      }
      return this;
    }

    // AVG - O(logn) and O(1)
    // WORST - O(n) and O(1)
    public boolean contains(int value) {
      BST currentNode = this;
      while (currentNode != null) {
        if (value < currentNode.value) {
          currentNode = currentNode.left;
        } else if (value > currentNode.value) {
          currentNode = currentNode.right;
        } else {
          return true;
        }
      }
      return false;
    }

    // AVG - O(logn) and O(1)
    // WORST - O(n) and O(1)
    public BST remove(int value) {
      BST currentNode = this;
      if (currentNode.value == value) {
        if (currentNode.left == null && currentNode.right == null) {
          return currentNode;
        }
        BST leftNode = currentNode.left;
        BST rightNode = currentNode.right;
        if (rightNode == null) {
          currentNode.value = leftNode.value;
          currentNode.left = leftNode.left;
          return this;
        }
        if (leftNode == null) {
          currentNode.value = rightNode.value;
          currentNode.right = rightNode.right;
          return this;
        }
        BST leftNodeOfRight = rightNode.left;
        if (leftNodeOfRight == null) {
          currentNode.value = rightNode.value;
          currentNode.right = rightNode.right;
          return this;
        }
        while (leftNodeOfRight.left != null) {
          if (leftNodeOfRight.left.left == null) {
            BST tempNode = leftNodeOfRight;
            leftNodeOfRight = tempNode.left;
            tempNode.left = null;
          } else {
            leftNodeOfRight = leftNodeOfRight.left;
          }
        }
        currentNode.value = leftNodeOfRight.value;
        return this;
      }
      while (currentNode != null) {
        if (value < currentNode.value) {
          if (currentNode.left != null && currentNode.left.value == value) {
            BST nextLeftNode = currentNode.left.left;
            BST nextRightNode = currentNode.left.right;
            if (nextRightNode == null) {
              currentNode.left = nextLeftNode;
              break;
            }
            currentNode.left = nextRightNode;
            while (nextRightNode.left != null) {
              nextRightNode = nextRightNode.left;
            }
            nextRightNode.left = nextLeftNode;
            break;
          }
          currentNode = currentNode.left;
        } else if (value > currentNode.value) {
          if (currentNode.right != null && currentNode.right.value == value) {
            BST nextLeftNode = currentNode.right.left;
            BST nextRightNode = currentNode.right.right;
            if (nextRightNode == null) {
              currentNode.right = nextLeftNode;
              break;
            }
            currentNode.right = nextRightNode;
            while (nextRightNode.left != null) {
              nextRightNode = nextRightNode.left;
            }
            nextRightNode.left = nextLeftNode;
            break;
          }
          currentNode = currentNode.right;
        } else {
          break;
        }
      }
      return this;
    }
  }
}
