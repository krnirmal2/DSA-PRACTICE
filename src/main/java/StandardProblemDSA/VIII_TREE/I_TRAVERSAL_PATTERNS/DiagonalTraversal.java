package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import java.util.*;

class TreeNode {
  int data;
  TreeNode left, right;

  TreeNode(int val) {
    data = val;
    left = right = null;
  }
}

public class DiagonalTraversal {

  // Main function to perform diagonal traversal
  public static void diagonalTraversal(TreeNode root) {
    if (root == null) return;

    // TreeMap to store diagonals with diagonal level as key
    Map<Integer, List<Integer>> diagonalMap = new TreeMap<>();
    diagonalTraversalUtil(root, 0, diagonalMap);

    // Print result
    for (Map.Entry<Integer, List<Integer>> entry : diagonalMap.entrySet()) {
      for (int val : entry.getValue()) {
        System.out.print(val + " ");
      }
      System.out.println(); // Optional: Print each diagonal in a new line
    }
  }

  // Recursive helper function
  public static void diagonalTraversalUtil(
      TreeNode node, int diagonalLevel, Map<Integer, List<Integer>> map) {
    if (node == null) return;

    // Add node to its corresponding diagonal level
    map.computeIfAbsent(diagonalLevel, k -> new ArrayList<>()).add(node.data);

    // Move to left child → diagonal level increases
    diagonalTraversalUtil(node.left, diagonalLevel + 1, map);

    // Move to right child → diagonal level remains the same
    diagonalTraversalUtil(node.right, diagonalLevel, map);
  }

  // Sample usage
  public static void main(String[] args) {
    /*
              8
             / \
            3   10
           / \    \
          1   6    14
             / \   /
            4   7 13
    Expected Diagonal Traversal:
    8 10 14
    3 6 7 13
    1 4
    */

    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(3);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    root.right.right = new TreeNode(14);
    root.right.right.left = new TreeNode(13);

    diagonalTraversal(root);
  }
}
