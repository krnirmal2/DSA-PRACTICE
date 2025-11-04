package StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;
import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathsPrint {
  // ---------------------------------------------------
  // 1. Root-to-Leaf Paths
  // ---------------------------------------------------
  /*
    Problem Statement:
       Print (or collect) all root-to-leaf paths in a binary tree.

    Brute Force Approach:
       - Recursively traverse the tree, and at every leaf, print the accumulated path.
       - Time Complexity: O(n) since each node is visited.

    Optimal Approach:
       - Use recursion with a list to store the current path.

    Time Complexity: O(n) and space O(n) for recursion and storing paths.

    Example:
       For tree:
                 1
                / \
               2   3
                \
                 5
       Root-to-leaf paths: [1,2,5] and [1,3]
  */
  public static List<List<Integer>> rootToLeafPaths(TreeNode root) {
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    TreeUtility.rootToLeafPathNodeUtil(root, current, paths);
    return paths;
  }
}
