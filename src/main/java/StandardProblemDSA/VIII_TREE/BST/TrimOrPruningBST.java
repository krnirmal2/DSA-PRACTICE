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
  */
    public static StandardProblemDSA.VIII_TREE.TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

}
