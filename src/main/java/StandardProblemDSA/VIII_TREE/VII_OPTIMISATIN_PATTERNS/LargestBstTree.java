package StandardProblemDSA.VIII_TREE.VII_OPTIMISATIN_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class LargestBstTree {
    static int largestBSTSize = 0;

    public static int largestBSTSubtree(TreeNode root) {
        largestBSTSize = 0;
        postorderBST(root);
        return largestBSTSize;
    }

    static BSTInfo postorderBST(TreeNode node) {
        if (node == null)
            return new BSTInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        BSTInfo leftInfo = postorderBST(node.left);
        BSTInfo rightInfo = postorderBST(node.right);

        if (leftInfo.isBST && rightInfo.isBST && node.val > leftInfo.max && node.val < rightInfo.min) {
            int size = leftInfo.size + rightInfo.size + 1;
            largestBSTSize = Math.max(largestBSTSize, size);
            int min = (node.left != null) ? leftInfo.min : node.val;
            int max = (node.right != null) ? rightInfo.max : node.val;
            return new BSTInfo(true, size, min, max);
        } else {
            // Not a BST; size not needed here.
            return new BSTInfo(false, 0, 0, 0);
        }
    } // ---------------------------------------------------

    // 6. Largest BST Subtree in Binary Tree
    // ---------------------------------------------------
  /*
    Problem Statement:
       Find the size (number of nodes) of the largest subtree in a binary tree that is a valid BST.

    Optimal Approach:
       - Use recursion to return for each subtree: whether it's a BST, its size, its minimum, and its maximum.
       - Combine information from left and right children to decide if the current subtree is BST.

    Time Complexity: O(n)

    Example:
       For tree:
               10
              /  \
             5    15
            / \     \
           1   8     7
       The largest BST subtree is:
               5
              / \
             1   8
       Size: 3.
  */
    static class BSTInfo {
        public boolean isBST;
        public int size;
        int min;
        int max;

        public BSTInfo(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}
