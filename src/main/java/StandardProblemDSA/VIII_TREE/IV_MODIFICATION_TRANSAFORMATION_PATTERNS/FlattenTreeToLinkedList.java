package StandardProblemDSA.VIII_TREE.IV_MODIFICATION_TRANSAFORMATION_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class FlattenTreeToLinkedList {
    // ---------------------------------------------------
    // 1. Flatten Tree to Linked List
    // ---------------------------------------------------
  /*
    Problem Statement:
       Flatten a binary tree into a linked list "in-place." The resulting list should use
       the right pointers as next pointers and left pointers should be null, following pre-order.

    Brute Force Approach:
       - Do a pre-order traversal, store nodes in an array, then relink.
       - Time: O(n) but requires extra O(n) space.

    Optimal Approach:
       - Recursively flatten left and right subtrees.
       - Then, attach the flattened left subtree between the root and the flattened right subtree.
       - Time Complexity: O(n)

    Example:
       Input:
                 1
                / \
               2   5
              / \   \
             3   4   6
       Output (right chain): 1 -> 2 -> 3 -> 4 -> 5 -> 6
  */
    public static void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tempRight = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        curr.right = tempRight;
    }
}
