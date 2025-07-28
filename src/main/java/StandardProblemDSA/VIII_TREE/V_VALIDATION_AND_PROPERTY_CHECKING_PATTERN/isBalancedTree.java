package StandardProblemDSA.VIII_TREE.V_VALIDATION_AND_PROPERTY_CHECKING_PATTERN;

import StandardProblemDSA.VIII_TREE.BST.BSTutility;
import StandardProblemDSA.VIII_TREE.TreeNode;

public class isBalancedTree {
    // ---------------------------------------------------
    // 5. Check if Tree is Balanced
    // ---------------------------------------------------
  /*
    Problem Statement:
       A binary tree is balanced if the heights of its two subtrees differ by no more than one at every node.

    Brute Force Idea:
       - For each node, compute the height of left and right subtrees, then check the difference.

    Optimal Approach:
       - Use recursion to compute height; if at any point the tree is not balanced, propagate a failure flag (e.g., return -1).

    Time Complexity: O(n)

    Example:
       Tree:
              1
             / \
            2   3
           /
          4
       This tree is balanced if the height difference is ≤ 1 at every node.
  */
    public static boolean isBalanced(TreeNode root) {
        return BSTutility.height(root) != -1;
    }
}
