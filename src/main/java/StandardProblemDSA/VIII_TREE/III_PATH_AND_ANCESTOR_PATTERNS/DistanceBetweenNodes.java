package StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

import static StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS.LCA.lowestCommonAncestor;

public class DistanceBetweenNodes {

    // ---------------------------------------------------
    // 4. Distance Between Two Nodes
    // ---------------------------------------------------
  /*
    Problem Statement:
       Find the distance (number of edges) between two nodes in a binary tree.

    Optimal Approach:
       - Find the lowest common ancestor (LCA) of the two nodes.
       - Compute distance from LCA to each node, then add them.

    Time Complexity: O(n)

    Example:
       For tree as above, distance between 6 and 0 = distance(6,3) + distance(0,3) = 2 + 2 = 4.
  */

    public static int distanceBetweenNodes(TreeNode root, int val1, int val2) {
        TreeNode lca = lowestCommonAncestor(root, new TreeNode(val1), new TreeNode(val2));
        // Note: The above LCA function expects exact node references.
        // In practice, if values are unique, you might need to first locate nodes by value.
        // For demonstration, we assume nodes with these values exist and are unique.
        int d1 = TreeUtility.findLevel(lca, val1, 0);
        int d2 = TreeUtility.findLevel(lca, val2, 0);
        return d1 + d2;
    }
}
