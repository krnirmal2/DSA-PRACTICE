package StandardProblemDSA.VIII_TREE.V_VALIDATION_AND_PROPERTY_CHECKING_PATTERN;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

public class IsSymmetricTree {
  // ---------------------------------------------------
  // 2. Check if Tree is Symmetric
  // ---------------------------------------------------
  /*
    Problem Statement:
       Determine if a binary tree is symmetric (a mirror of itself).

    Brute Force Idea:
       - Generate the mirror of the tree and then compare with the original.

    Optimal Approach:
       - Use a helper method to compare the left subtree with the right subtree.
       - Two trees are mirror images if the value at the root is the same and
         the right subtree of one is a mirror of the left subtree of the other.

    Time Complexity: O(n)

    Example:
       Tree:
              1
             / \
            2   2
           /     \
          3       3
       This tree is not symmetric because the left and right subtrees differ.
       A symmetric example would have both subtrees matching.
  */
  public static boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return TreeUtility.isMirror(root.left, root.right);
  }
}
