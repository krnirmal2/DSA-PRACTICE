package StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

import java.util.ArrayList;
import java.util.List;

public class AncestorsOfNode {
    // ---------------------------------------------------
    // 5. Ancestors of a Node
    // ---------------------------------------------------
  /*
    Problem Statement:
       Return all ancestors of a node (excluding the node itself) in a binary tree.

    Optimal Approach:
       - Recursively traverse the tree.
       - When the target is found, return true while adding nodes along the recursive path.

    Time Complexity: O(n)

    Example:
       For tree:
                 3
                / \
               5   1
              / \
             6   2
       Ancestors of 6: [5, 3]
  */
    public static List<Integer> ancestors(TreeNode root, int target) {
        List<Integer> result = new ArrayList<>();
        TreeUtility.findAncestors(root, target, result);
        return result;
    }
}
