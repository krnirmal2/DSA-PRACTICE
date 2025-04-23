package StandardProblemDSA.VIII_TREE.VI_COUNTING_AND_SUMMATION_PATTERNS;

public class TreeCountingOperations {

  // ---------------------------------------------------
  // Definition for a binary tree node.
  // ---------------------------------------------------
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
      left = right = null;
    }
  }

  // ---------------------------------------------------
  // 1. Count Total Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Count the total number of nodes in a binary tree.

    Brute Force Idea:
       - Traverse all nodes (e.g., using recursion) and increment a counter.

    Optimal Approach:
       - Use recursion: count = 1 (current node) + count(left subtree) + count(right subtree).

    Time Complexity: O(n), where n is the number of nodes.

    Example:
       For tree:
               1
              / \
             2   3
            /
           4
       Total nodes = 4.
  */
  public int countNodes(TreeNode root) {
    if (root == null) return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  // ---------------------------------------------------
  // 2. Count Leaf Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Count the number of leaf nodes (nodes with no children) in a binary tree.

    Optimal Approach:
       - Recursively check: if node is null, return 0; if both children are null, return 1;
         otherwise, sum counts from left and right subtrees.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
              \
               4
       Leaf nodes: 4 and 3 → count = 2.
  */
  public int countLeafNodes(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    return countLeafNodes(root.left) + countLeafNodes(root.right);
  }

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
  public int countGoodNodes(TreeNode root) {
    return countGoodNodesHelper(root, Integer.MIN_VALUE);
  }

  private int countGoodNodesHelper(TreeNode node, int maxSoFar) {
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
  // 4. Sum of All Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Calculate the sum of all node values in a binary tree.

    Optimal Approach:
       - Recursively sum the current node’s value and the sums from the left and right subtrees.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
       Sum = 1 + 2 + 3 = 6.
  */
  public int sumNodes(TreeNode root) {
    if (root == null) return 0;
    return root.val + sumNodes(root.left) + sumNodes(root.right);
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
  public int sumLeafNodes(TreeNode root) {
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
  public java.util.List<Integer> nodesAtKDistance(TreeNode root, int k) {
    java.util.List<Integer> result = new java.util.ArrayList<>();
    nodesAtKDistanceHelper(root, k, result);
    return result;
  }

  private void nodesAtKDistanceHelper(TreeNode node, int k, java.util.List<Integer> result) {
    if (node == null) return;
    if (k == 0) {
      result.add(node.val);
      return;
    }
    nodesAtKDistanceHelper(node.left, k - 1, result);
    nodesAtKDistanceHelper(node.right, k - 1, result);
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
    TreeNode root = ops.new TreeNode(1);
    root.left = ops.new TreeNode(2);
    root.right = ops.new TreeNode(3);
    root.left.left = ops.new TreeNode(4);
    root.right.left = ops.new TreeNode(5);
    root.right.right = ops.new TreeNode(6);
    root.right.left.right = ops.new TreeNode(7);

    // 1. Total Nodes Count
    int totalNodes = ops.countNodes(root);
    System.out.println("Total nodes: " + totalNodes); // Expected: 7

    // 2. Leaf Nodes Count
    int leafNodes = ops.countLeafNodes(root);
    System.out.println("Leaf nodes count: " + leafNodes); // Expected: 3 (nodes 4, 7, 6)

    // 3. Good Nodes Count
    int goodNodes = ops.countGoodNodes(root);
    System.out.println("Good nodes count: " + goodNodes);
    // For tree: root (1) is good, then check others along path.

    // 4. Sum of All Nodes
    int sumAll = ops.sumNodes(root);
    System.out.println("Sum of all nodes: " + sumAll); // Expected: 1+2+3+4+5+6+7 = 28

    // 5. Sum of Leaf Nodes
    int sumLeaves = ops.sumLeafNodes(root);
    System.out.println("Sum of leaf nodes: " + sumLeaves); // Expected: 4+7+6 = 17

    // 6. Nodes at K Distance from Root (k = 2)
    java.util.List<Integer> nodesAtDistance2 = ops.nodesAtKDistance(root, 2);
    System.out.println("Nodes at distance 2 from root: " + nodesAtDistance2); // Expected: [4, 5, 6]
  }
}
