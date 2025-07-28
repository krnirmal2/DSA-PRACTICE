package StandardProblemDSA.VIII_TREE.VII_OPTIMISATIN_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class DiameterOfBinaryTree {
    // ---------------------------------------------------
    // 3. Diameter of Binary Tree
    // ---------------------------------------------------
  /*
    Problem Statement:
       Find the diameter (or width) of a binary tree, defined as the length (number of edges)
       of the longest path between any two nodes in the tree.

    Optimal Approach:
       - Use recursion to compute the height of each subtree while updating a global diameter.
       - Diameter at a node = height(left) + height(right).

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
            / \
           4   5
       Diameter: 3 (path: 4 → 2 → 1 → 3 or 4→2→5 if defined in edges; here, 3 edges)
  */
    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        heightForDiameter(root);
        return diameter;
    } // Helper method returns height while updating diameter.

    static int heightForDiameter(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = heightForDiameter(node.left);
        int rightHeight = heightForDiameter(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
