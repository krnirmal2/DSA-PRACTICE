package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalTraversal {
  /*
   Problem: Perform diagonal traversal of a binary tree.

   Traverse the binary tree diagonally, grouping all nodes having the same diagonal distance
   (distance from the top-right to bottom-left). Nodes are printed diagonal by diagonal.

   Example:
   Input:
          8
         / \
        3   10
       / \    \
      1   6    14
         / \   /
        4   7 13
   Output:
      Diagonal 0: 8 10 14
      Diagonal 1: 3 6 7 13
      Diagonal 2: 1 4

   Pattern:
      - Tree Traversal
      - Diagonal Traversal
      - DFS + Hashing (group by diagonal level)

   Similar LeetCode Problems:
      - 103. Binary Tree Zigzag Level Order Traversal
      - 314. Binary Tree Vertical Order Traversal
      - 987. Vertical Order Traversal of a Binary Tree

   Follow-up Questions:
      - Can this be done iteratively using a queue?
      - How to print in a single list instead of level-wise?
      - How to optimize for very large trees?
      - How to handle skewed trees efficiently?

   Time Complexity: O(n), n = number of nodes
   Space Complexity: O(n), due to map storing all nodes and recursion stack
  */

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
    map.computeIfAbsent(diagonalLevel, k -> new ArrayList<>()).add(node.val);

    // Move to left child → diagonal level increases
    diagonalTraversalUtil(node.left, diagonalLevel + 1, map);

    // Move to right child → diagonal level remains the same
    diagonalTraversalUtil(node.right, diagonalLevel, map);
  }

  // Sample usage
  public static void main(String[] args) {

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
