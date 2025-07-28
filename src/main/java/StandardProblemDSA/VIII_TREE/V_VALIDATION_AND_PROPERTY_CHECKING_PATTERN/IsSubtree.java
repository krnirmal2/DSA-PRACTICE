package StandardProblemDSA.VIII_TREE.V_VALIDATION_AND_PROPERTY_CHECKING_PATTERN;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

public class IsSubtree {
    // ---------------------------------------------------
    // 4. Subtree of Another Tree
    // ---------------------------------------------------
  /*
    Problem Statement:
       Check if one tree (T) is a subtree of another tree (S). T is a subtree of S if there exists a node in S
       such that the subtree rooted at that node is identical to T.

    Brute Force Idea:
       - For every node in S, check if T is identical to the subtree starting at that node.

    Optimal Approach:
       - Use recursion: if the current node in S matches T’s root, check for identical structure.

    Time Complexity: O(m*n) worst-case, where m and n are the number of nodes in S and T respectively.

    Example:
       S:        3           T:       4
               /   \                /
              4     5              1
             / \
            1   2
       T is a subtree of S.
  */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return t == null;
        if (TreeUtility.isIdentical(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
