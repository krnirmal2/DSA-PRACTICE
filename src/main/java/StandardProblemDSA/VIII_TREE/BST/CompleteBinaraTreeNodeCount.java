package StandardProblemDSA.VIII_TREE.BST;

public class CompleteBinaraTreeNodeCount {
  /*
  Problem:
      Count the number of nodes in a complete binary tree efficiently.

  Approach (Optimized O(log² n)):
      - For each subtree, compute leftmost and rightmost path heights.
      - If both heights are equal → subtree is a perfect binary tree → node count = 2^h - 1.
      - Otherwise, recursively count nodes in left and right subtrees.

  Pattern:
      - Divide and Conquer with height checks.
      - Uses the property that a complete binary tree has the last level filled from left to right.

  LeetCode Similar:
      - LeetCode 222: Count Complete Tree Nodes.

  Time Complexity:
      - getLeftHeight() and getRightHeight() take O(log n).
      - In worst case, we compute heights at O(log n) levels → O(log² n).

  Space Complexity:
      - O(log n) recursion depth.

  Follow-ups:
      - Can optimize further to O(log n * log n) iterative or even O(log n) using bit manipulation.
  */
  public int countNodes(TreeNode root) {
    if (root == null) return 0;

    int leftHeight = getLeftHeight(root);
    int rightHeight = getRightHeight(root);

    if (leftHeight == rightHeight) {
      // It's a perfect binary tree
      return (1 << leftHeight) - 1; // same as 2^h - 1
    } else {
      // Not perfect, count recursively
      return 1 + countNodes(root.left) + countNodes(root.right);
    }
  }

  private int getLeftHeight(TreeNode node) {
    int height = 0;
    while (node != null) {
      height++;
      node = node.left;
    }
    return height;
  }

  private int getRightHeight(TreeNode node) {
    int height = 0;
    while (node != null) {
      height++;
      node = node.right;
    }
    return height;
  }
  /*⏱ Time Complexity: O(log² n)
  For each node, we check the height of left & right → O(log n).
  We do this at most log n times (depth of tree) → O(log n * log n).
          🧠 Why This Works
  Perfect tree? Count with math.
  Imperfect tree? Divide and conquer — count children.*/
}
