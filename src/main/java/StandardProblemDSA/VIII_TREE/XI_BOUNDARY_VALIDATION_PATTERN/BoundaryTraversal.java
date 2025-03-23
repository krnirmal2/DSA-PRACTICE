package StandardProblemDSA.VIII_TREE.XI_BOUNDARY_VALIDATION_PATTERN;

import java.util.ArrayList;

public class BoundaryTraversal {}

// Java implementation for Boundary Traversal of Binary Tree using recursion
class Node {
  int data;
  Node left, right;

  Node(int x) {
    data = x;
    left = right = null;
  }
}

class GfG {

  static boolean isLeaf(Node node) {
    return node.left == null && node.right == null;
  }

  // Function to collect left boundary nodes
  // (top-down order)
  static void collectBoundaryLeft(Node root, ArrayList<Integer> res) {
    if (root == null || isLeaf(root)) return;

    res.add(root.data);
    if (root.left != null) collectBoundaryLeft(root.left, res);
    else if (root.right != null) collectBoundaryLeft(root.right, res);
  }

  // Function to collect all leaf nodes
  static void collectLeaves(Node root, ArrayList<Integer> res) {
    if (root == null) return;

    if (isLeaf(root)) {
      res.add(root.data);
      return;
    }

    collectLeaves(root.left, res);
    collectLeaves(root.right, res);
  }

  // Function to collect right boundary nodes
  // (bottom-up order)
  static void collectBoundaryRight(Node root, ArrayList<Integer> res) {
    if (root == null || isLeaf(root)) return;

    if (root.right != null) collectBoundaryRight(root.right, res);
    else if (root.left != null) collectBoundaryRight(root.left, res);

    res.add(root.data);
  }

  // Function to find Boundary Traversal of Binary Tree
  static ArrayList<Integer> boundaryTraversal(Node root) {
    ArrayList<Integer> res = new ArrayList<>();

    if (root == null) return res;

    // Add root data if it's not a leaf
    if (!isLeaf(root)) res.add(root.data);

    // Collect left boundary
    collectBoundaryLeft(root.left, res);

    // Collect leaf nodes
    collectLeaves(root, res);

    // Collect right boundary
    collectBoundaryRight(root.right, res);

    return res;
  }

  public static void main(String[] args) {

    // Hardcoded Binary tree
    //        20
    //       /  \
    //      8    22
    //     / \     \
    //    4   12    25
    //       /  \
    //      10   14
    Node root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);
    root.left.left = new Node(4);
    root.left.right = new Node(12);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);
    root.right.right = new Node(25);

    ArrayList<Integer> boundary = boundaryTraversal(root);

    for (int x : boundary) System.out.print(x + " ");
  }
}
