package StandardProblemDSA.VIII_TREE.BST;

public class CompleteBinaraTreeNodeCount {
  /*🔥 Optimized Approach — O(log² n) Time
   We'll:
   Compute the height of the leftmost and rightmost paths.
   If they're equal → it's a perfect binary tree → use formula 2^h - 1.
   If not equal → recursively count nodes in left and right subtrees.
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
