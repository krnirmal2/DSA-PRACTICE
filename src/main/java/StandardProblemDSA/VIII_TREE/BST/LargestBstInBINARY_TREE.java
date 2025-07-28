package StandardProblemDSA.VIII_TREE.BST;

public class LargestBstInBINARY_TREE {

  /*
  Problem:
      Find the size of the largest BST subtree in a binary tree.

  Brute Force:
      - For each node, check if its subtree is a BST (O(n)) and count nodes if true.
      - Repeat for all n nodes → O(n²) time, O(h) space for recursion stack.

  Optimal Solution:
      - Use bottom-up (post-order) traversal.
      - For each node, gather:
          * min value in subtree,
          * max value in subtree,
          * size of largest BST in subtree.
      - If node satisfies BST property (left.max < node.val < right.min):
          - It's a BST → size = 1 + left.size + right.size.
          - Update min = min(node.val, left.min), max = max(node.val, right.max).
      - Else:
          - Return invalid markers (min = -∞, max = +∞) so parent won't consider it a BST.
          - Pass up the maximum size found in left or right.

  Pattern:
      - **Post-order traversal** with subtree info aggregation.

  LeetCode Similar:
      - LeetCode 333: Largest BST Subtree.

  Time Complexity:
      - O(n) since each node visited once.
  Space Complexity:
      - O(h) recursion depth, h = tree height.

  Follow-up:
      - Can be extended to also return the root of largest BST subtree.
  */

  // own data structure for complex thing
  class NodeValue {
    int maxNode, minNode, maxSize;

    NodeValue(int minNode, int maxNode, int maxSize) {
      this.maxNode = maxNode;
      this.minNode = minNode;
      this.maxNode = maxNode;
    }
  }

  class Solution {
    private class TreeNode {
      int val;
      TreeNode left, right;

      TreeNode(int x) {
        val = x;
        left = right = null;
      }
    }

    private NodeValue largestBstFromBinarTree(TreeNode root) {
      if (root == null) {
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
      }

      // get values from left and right subtree of current tree
      NodeValue left = largestBstFromBinarTree(root.left);
      NodeValue right = largestBstFromBinarTree(root.right);

      // now we will set the current node value with min, max, size
      // if root value is greater than the
      // its left node and smaller than its right node
      if (left.maxNode < root.val && root.val < right.minNode) {
        // means it is a BST
        return new NodeValue(
            Math.min(root.val, left.minNode),
            Math.max(root.val, right.maxNode),
            left.maxSize + right.maxSize + 1);
      }
      // else it is not BST
      return new NodeValue(
          Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
  }
}
