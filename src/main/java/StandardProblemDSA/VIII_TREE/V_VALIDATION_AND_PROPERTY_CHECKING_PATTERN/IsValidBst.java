package StandardProblemDSA.VIII_TREE.V_VALIDATION_AND_PROPERTY_CHECKING_PATTERN;

import StandardProblemDSA.VIII_TREE.BST.BSTutility;
import StandardProblemDSA.VIII_TREE.TreeNode;

public class IsValidBst {
  // ---------------------------------------------------
  // 3. Validate Binary Search Tree (BST)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Determine if a binary tree is a valid binary search tree (BST).

    Brute Force Idea:
       - Inorder traverse the tree and check if the result is a sorted list.

    Optimal Approach:
       - Recursively validate each node by ensuring its value is within an allowed range.
       - For the root, the range is (-∞, ∞). For left child, update upper bound; for right child, update lower bound.

    Time Complexity: O(n)

    Example:
       Tree:
              5
             / \
            3   7
       This tree is a valid BST.
  */
  public static boolean isValidBST(TreeNode root) {
    return BSTutility.validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
}
