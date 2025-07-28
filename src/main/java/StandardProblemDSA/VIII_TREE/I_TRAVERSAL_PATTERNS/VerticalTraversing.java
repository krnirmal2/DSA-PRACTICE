package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

import java.util.ArrayList;
import java.util.List;

public class VerticalTraversing {
  /*
   Problem: Print the vertical order traversal of a binary tree.

   Given the root of a binary tree, print all nodes column by column from leftmost vertical line
   to rightmost vertical line. Nodes on the same vertical line are printed from top to bottom.

   Example:
   Input:
          1
         / \
        2   3
       / \   \
      4   5   6
   Output: [4, 2, 1, 5, 3, 6]

   Pattern:
      - Tree Traversal
      - Vertical Order Traversal
      - DFS with Horizontal Distance (HD)

   Similar LeetCode Problems:
      - 987. Vertical Order Traversal of a Binary Tree
      - 314. Binary Tree Vertical Order Traversal
      - 103. Binary Tree Zigzag Level Order Traversal

   Follow-up Questions:
      - How to implement using BFS for correct top-to-bottom order?
      - Can we print each vertical line separately?
      - How to handle duplicate values or very large trees?
      - Can we optimize to O(n) with a single traversal?

   Time Complexity: O(n²), n = number of nodes (due to repeated traversals per vertical line)
   Space Complexity: O(h), h = height of the tree (recursion stack)
  */

  // A utility function to collect all
  // TreeNode on a given vertical line_no.
  static void collectVerticalLine(TreeNode node, int lineNo, int hd, List<Integer> result) {
    // Base case
    if (node == null) return;

    // If this node is on the given vertical line
    if (hd == lineNo) result.add(node.val);

    // Recur for left and right subtrees
    collectVerticalLine(node.left, lineNo, hd - 1, result);
    collectVerticalLine(node.right, lineNo, hd + 1, result);
  }

  // The main function that returns a list of TreeNode
  // in vertical order
  static List<Integer> verticalOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    // Find min and max distances with respect to root
    int[] minMax = new int[] {0, 0};
    TreeUtility.findHorizontalDistance(root, minMax, 0);

    // Iterate through all possible vertical
    // lines from leftmost to rightmost
    for (int lineNo = minMax[0]; lineNo <= minMax[1]; lineNo++) {
      collectVerticalLine(root, lineNo, 0, result);
    }

    return result;
  }

  public static void main(String[] args) {

    // Create binary tree
    //            1
    //          /   \
    //         2     3
    //        / \   / \
    //       4   5 6   7
    //              \   \
    //               8   9

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.right = new TreeNode(9);

    List<Integer> result = verticalOrder(root);

    for (int val : result) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}
