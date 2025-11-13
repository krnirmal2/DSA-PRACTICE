package StandardProblemDSA.VIII_TREE.VI_COUNTING_AND_SUMMATION_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;
import java.util.List;

public class TreeCountingOperations {
  /*
   Problem: Demonstrate tree counting operations using a sample binary tree.

   Operations covered:
     1. Count total nodes.
     2. Count leaf nodes.
     3. Count good nodes (nodes >= all previous values on the path).
     4. Sum of all nodes.
     5. Sum of leaf nodes.
     6. Nodes at distance k from root.

   Pattern:
     - Tree traversal (DFS/BFS)
     - Counting and aggregation

   Expected Output:
     Total nodes: 7
     Leaf nodes count: 3
     Good nodes count: (depends on path values)
     Sum of all nodes: 28
     Sum of leaf nodes: 17
     Nodes at distance 2 from root: [4, 5, 6]
  */

  // ---------------------------------------------------
  // 3. Count Good Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       A node X in the tree is considered "good" if on the path from the root to X, there
       is no node with a value greater than X.
       Count the total number of good nodes in the binary tree.

    Brute Force Idea:
       - For every node, compare with all ancestors.

    Optimal Approach:
       - Use recursion and pass the maximum value seen so far along the path.
       - If the current node’s value is greater than or equal to that maximum, it is "good."

    Time Complexity: O(n)

    Example:
       For tree:
               3
              / \
             1   4
              \
               3
       Good nodes are: 3 (root), 4, and 3 (right child of 1 is >= 1) → count = 3.
  */
  public static int countGoodNodes(TreeNode root) {
    return countGoodNodesHelper(root, Integer.MIN_VALUE);
  }

  private static int countGoodNodesHelper(TreeNode node, int maxSoFar) {
    if (node == null) return 0;
    int count = 0;
    if (node.val >= maxSoFar) {
      count = 1;
      maxSoFar = node.val; // update the max value seen so far
    }
    count += countGoodNodesHelper(node.left, maxSoFar);
    count += countGoodNodesHelper(node.right, maxSoFar);
    return count;
  }

  // ---------------------------------------------------
  // 5. Sum of Leaf Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Compute the sum of all leaf node values in a binary tree.

    Optimal Approach:
       - Recursively check if a node is a leaf; if yes, add its value.
       - Otherwise, sum for left and right subtrees.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
              \
               4
       Leaves are 4 and 3 → sum = 4 + 3 = 7.
  */
  public static int sumLeafNodes(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return root.val;
    return sumLeafNodes(root.left) + sumLeafNodes(root.right);
  }

  // ---------------------------------------------------
  // 6. Nodes at K Distance from Root/Node
  // ---------------------------------------------------
  /*
    Problem Statement:
       Find all nodes that are exactly K edges away from the root (or a given node).

    Optimal Approach:
       - Use recursion (or level order traversal). For recursion, if k == 0, add current node.
       - Otherwise, decrement k and recur for left and right subtrees.

    Time Complexity: O(n) in worst-case.

    Example:
       For tree:
               1
              / \
             2   3
            / \
           4   5
       Nodes at distance 2 from root: [4, 5, 3].
  */
  public static List<Integer> nodesAtKDistance(TreeNode root, int k) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    TreeUtility.nodesAtKDistanceHelper(root, k, result);
    return result;
  }

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {
    TreeCountingOperations ops = new TreeCountingOperations();

    // Build a sample tree:
    //         1
    //        / \
    //       2   3
    //      /   / \
    //     4   5   6
    //          \
    //           7
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.left.right = new TreeNode(7);

    // 1. Total Nodes Count
    int totalNodes = TreeUtility.countNodes(root);
    System.out.println("Total nodes: " + totalNodes); // Expected: 7

    // 2. Leaf Nodes Count
    int leafNodes = TreeUtility.countLeafNodes(root);
    System.out.println("Leaf nodes count: " + leafNodes); // Expected: 3 (nodes 4, 7, 6)

    // 3. Good Nodes Count
    int goodNodes = countGoodNodes(root);
    System.out.println("Good nodes count: " + goodNodes);
    // For tree: root (1) is good, then check others along path.

    // 4. Sum of All Nodes
    int sumAll = TreeUtility.sumNodes(root);
    System.out.println("Sum of all nodes: " + sumAll); // Expected: 1+2+3+4+5+6+7 = 28

    // 5. Sum of Leaf Nodes
    int sumLeaves = sumLeafNodes(root);
    System.out.println("Sum of leaf nodes: " + sumLeaves); // Expected: 4+7+6 = 17

    // 6. Nodes at K Distance from Root (k = 2)
    List<Integer> nodesAtDistance2 = nodesAtKDistance(root, 2);
    System.out.println("Nodes at distance 2 from root: " + nodesAtDistance2); // Expected: [4, 5, 6]
  }
}
