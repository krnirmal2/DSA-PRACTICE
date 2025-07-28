package StandardProblemDSA.VIII_TREE.VII_OPTIMISATIN_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class MaxPathSumBinaryTree {
    // ---------------------------------------------------
    // 4. Maximum Path Sum in Binary Tree
    // ---------------------------------------------------
  /*
    Problem Statement:
       Find the maximum path sum in a binary tree. A path may start and end at any node,
       and the path must go downward (traveling from parent to child).
       (Some variations allow any path in the tree.)

    Optimal Approach:
       - Use recursion to compute the maximum gain from each node and update a global maximum.
       - At each node, consider the best path including the node and possibly one of its subtrees.

    Time Complexity: O(n)

    Example:
       For tree:
               -10
               /  \
              9   20
                 /  \
                15   7
       Maximum Path Sum: 42 (path: 15 → 20 → 7 or 15 + 20 + 7, depending on interpretation)
       (Typically the correct path is 15 + 20 + 7 = 42.)
  */
    static int maxPathSumGlobal;

    public MaxPathSumBinaryTree() {
        maxPathSumGlobal = Integer.MIN_VALUE;
    }

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxPathSumGlobal;
    } // Helper: maximum gain from node.

    static int maxGain(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        // Price to start a new path where node is highest node.
        int priceNewPath = node.val + leftGain + rightGain;
        maxPathSumGlobal = Math.max(maxPathSumGlobal, priceNewPath);
        // For recursion, return the max gain if continue the same path.
        return node.val + Math.max(leftGain, rightGain);
    }
}
