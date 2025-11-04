package StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

public class LCA extends PathWitMaximumAndSpecificSum {
  // ---------------------------------------------------
  // 3. Lowest Common Ancestor (LCA)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given two nodes in a binary tree, find their lowest common ancestor (LCA).

    Brute Force Approach:
       - For each node, store its ancestors in lists and then compare lists.

    Optimal Approach:
       - Recursively traverse the tree.
       - If one node is found in one subtree and the other is found in the other subtree, then root is LCA.

    Time Complexity: O(n)

    Example:
       For tree:
                 3
                / \
               5   1
              / \  / \
             6  2 0   8
       LCA(6,2) = 5.
  */
  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return TreeUtility.lowestCommonAncestor(root, p, q);
  }

  public static void main(String[] args) {
    lowestCommonAncestor(TreeUtility.tree(), new TreeNode(6), new TreeNode(1));
  }
}
