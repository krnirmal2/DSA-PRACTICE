package StandardProblemDSA.VIII_TREE.IV_MODIFICATION_TRANSAFORMATION_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class MirrorOrInvertedBinaryTree {
  // ---------------------------------------------------
  // 2. Mirror/Invert Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Invert (or mirror) a binary tree by swapping left and right children of every node.

    Brute Force Approach:
       - Recursively swap children for every node.
       - Time Complexity: O(n)

    Optimal Approach:
       - Recursively swap left and right pointers.

    Example:
       Input:
                 4
                / \
               2   7
              / \ / \
             1  3 6  9
       Output (Mirrored):
                 4
                / \
               7   2
              / \ / \
             9  6 3  1
  */
  public static TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode tmp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(tmp);
    return root;
  }
}
