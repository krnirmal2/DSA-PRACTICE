package StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathWitMaximumAndSpecificSum extends RootToLeafPathsPrint {
    // ---------------------------------------------------
    // 2. Path with Maximum/Specific Sum
    // ---------------------------------------------------
  /*
    Problem Statement:
       (a) Find the root-to-leaf path with maximum sum.
       (b) Check if there is a root-to-leaf path with a given sum.

    Brute Force Approach:
       - Traverse all root-to-leaf paths and compute the sum.

    Optimal Approach:
       - For maximum sum, recursively compute the maximum sum path.
       - For specific sum, use recursion and subtract node values from target sum.

    Time Complexity: O(n)

    Example:
       For tree:
                 10
                /  \
               5    12
              / \
             4   7
       Maximum sum path: [10, 5, 7] with sum 22.
       Specific sum (e.g., 21): Path [10, 5, 4, 2] if tree supports such a sum.
       (Example values may vary.)
  */
    public static MaxPathResult maxSumPath(TreeNode root) {
        if (root == null) return new MaxPathResult(0, new ArrayList<>());
        if (root.left == null && root.right == null) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            return new MaxPathResult(root.val, path);
        }
        MaxPathResult leftResult = PathWitMaximumAndSpecificSum.maxSumPath(root.left);
        MaxPathResult rightResult = PathWitMaximumAndSpecificSum.maxSumPath(root.right);
        MaxPathResult best = (leftResult.sum > rightResult.sum) ? leftResult : rightResult;
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        path.addAll(best.path);
        return new MaxPathResult(root.val + best.sum, path);
    }

    // (b) Check if there is a root-to-leaf path with a given sum.
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        // If leaf, check if path sum equals targetSum.
        if (root.left == null && root.right == null) {
            return (root.val == targetSum);
        }
        // Otherwise, check in left or right subtree with reduced target.
        return PathWitMaximumAndSpecificSum.hasPathSum(root.left, targetSum - root.val)
                || PathWitMaximumAndSpecificSum.hasPathSum(root.right, targetSum - root.val);
    }

    // (a) Maximum sum root-to-leaf path (returns the sum and the path)
    public static class MaxPathResult {
        int sum;
        List<Integer> path;

        MaxPathResult(int sum, List<Integer> path) {
            this.sum = sum;
            this.path = path;
        }
    }
}
