package StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

import java.util.ArrayList;
import java.util.List;

public class PathsMatchToSpecificPatternInTree extends AncestorsOfNode {
    // ---------------------------------------------------
    // 6. Paths Matching a Specific Pattern
    // ---------------------------------------------------
  /*
    Problem Statement:
       Given a binary tree and a pattern (as a list of integers), find all root-to-leaf paths
       that contain the pattern as a prefix.

    Brute Force Approach:
       - Generate all paths and then check if they start with the pattern.

    Optimal Approach:
       - Use DFS while comparing the current path with the pattern.
       - If the current path's beginning matches the pattern and reaches a leaf, record the path.

    Time Complexity: O(n * p) where p is the length of the pattern.

    Example:
       For tree:
                 1
                / \
               2   3
              /   / \
             4   2   5
       Pattern: [1,2]
       Matching path: [1,2,4]
  */
    public static List<List<Integer>> pathsMatchingPattern(TreeNode root, List<Integer> pattern) {
        List<List<Integer>> matchingPaths = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        TreeUtility.findPathsMatching(root, pattern, 0, current, matchingPaths);
        return matchingPaths;
    }
}
