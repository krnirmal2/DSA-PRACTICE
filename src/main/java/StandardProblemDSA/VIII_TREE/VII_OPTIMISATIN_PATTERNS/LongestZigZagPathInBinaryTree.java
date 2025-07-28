package StandardProblemDSA.VIII_TREE.VII_OPTIMISATIN_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class LongestZigZagPathInBinaryTree {
    // ---------------------------------------------------
    // 5. Longest Zigzag Path in Binary Tree
    // ---------------------------------------------------
  /*
    Problem Statement:
       Find the length of the longest zigzag path in a binary tree.
       A zigzag path is defined as a sequence where the direction of travel alternates between left and right.
       The length is defined as the number of edges in the path.

    Optimal Approach:
       - Use recursion and at each node maintain two values:
           * The length of the zigzag path if we take a left turn.
           * The length of the zigzag path if we take a right turn.
       - Update a global maximum.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
              \
               4
              /
             5
       Longest Zigzag Path: 3 (e.g., 1→2→4→5 with alternating directions)
  */
    static int longestZigzag = 0;

    public static int longestZigzagPath(TreeNode root) {
        zigzag(root, true, 0);
        zigzag(root, false, 0);
        return longestZigzag;
    } // Helper: direction = true means previous move was to left, so now go right; false means vice

    // versa.
    static void zigzag(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;
        longestZigzag = Math.max(longestZigzag, length);
        if (isLeft) {
            // Last move was left, now try to move right.
            zigzag(node.right, false, length + 1);
            // Also, restart from left child.
            zigzag(node.left, true, 1);
        } else {
            // Last move was right, now try to move left.
            zigzag(node.left, true, length + 1);
            // Also, restart from right child.
            zigzag(node.right, false, 1);
        }
    }
}
