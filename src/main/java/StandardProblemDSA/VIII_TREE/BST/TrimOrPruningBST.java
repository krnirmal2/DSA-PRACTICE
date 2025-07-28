package StandardProblemDSA.VIII_TREE.BST;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class TrimOrPruningBST {
  // ---------------------------------------------------
  // 5. Tree Trimming/Pruning (BST Trim by Range)
  // ---------------------------------------------------
  /*
      Problem Statement:
         Given a BST and a range [L, R], trim the tree so that all its elements lie in [L, R].
         The resulting tree should still be a valid BST.

      Brute Force Approach:
         - Traverse the tree and remove nodes not in range, then rebuild BST.

      Optimal Approach:
         - Recursively trim the tree:
           - If a node's value is less than L, then trim its right subtree.
           - If a node's value is greater than R, then trim its left subtree.
           - Otherwise, recursively trim both subtrees.
         - Time Complexity: O(n)

      Example:
         Input BST:
                   3
                  / \
                 0   4
                  \
                   2
                  /
                 1
         Range: [1, 3]
         Output:
                   3
                  /
                 2
                /
               1
  Approach:
      - Use recursion:
          * If node.val < L → discard left subtree, return trim of right.
          * If node.val > R → discard right subtree, return trim of left.
          * Else → keep node, recursively trim left and right.
      - Preserves BST property because we only remove out-of-range branches.

  Pattern:
      - **DFS recursion** with range-based pruning.

  LeetCode Similar:
      - LeetCode 669: Trim a Binary Search Tree.

  Time Complexity:
      - O(n) visiting each node at most once.
  Space Complexity:
      - O(h) recursion depth, h = tree height.

  Follow-up:
      - Can be adapted for other pruning conditions (e.g., sum of path, node count, etc.).
    */
  public static TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) return null;
    if (root.val < L) return trimBST(root.right, L, R);
    if (root.val > R) return trimBST(root.left, L, R);
    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);
    return root;
  }
}
