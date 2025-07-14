package StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;
import java.util.*;

public class TreePathOperations {

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
  // (a) Maximum sum root-to-leaf path (returns the sum and the path)
  public static class MaxPathResult {
    int sum;
    List<Integer> path;

    MaxPathResult(int sum, List<Integer> path) {
      this.sum = sum;
      this.path = path;
    }
  }

  public static MaxPathResult maxSumPath(TreeNode root) {
    if (root == null) return new MaxPathResult(0, new ArrayList<>());
    if (root.left == null && root.right == null) {
      List<Integer> path = new ArrayList<>();
      path.add(root.val);
      return new MaxPathResult(root.val, path);
    }
    MaxPathResult leftResult = maxSumPath(root.left);
    MaxPathResult rightResult = maxSumPath(root.right);
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
    return hasPathSum(root.left, targetSum - root.val)
        || hasPathSum(root.right, targetSum - root.val);
  }

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

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {
    TreePathOperations ops = new TreePathOperations();

    // Build a sample binary tree:
    //          3
    //         / \
    //        5   1
    //       / \   \
    //      6   2   8
    //         /
    //        7
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.right.right = new TreeNode(8);

    // 1. Root-to-Leaf Paths
    List<List<Integer>> allPaths = rootToLeafPaths(root);
    System.out.println("Root-to-Leaf Paths:");
    for (List<Integer> path : allPaths) {
      System.out.println(path);
    }
    // Expected paths: [3,5,6], [3,5,2,7], [3,1,8]

    // 2. Path with Maximum Sum
    MaxPathResult maxPath = maxSumPath(root);
    System.out.println("Maximum Sum Path: " + maxPath.path + " with sum = " + maxPath.sum);

    // Check for specific sum, e.g., 15.
    boolean hasSum15 = hasPathSum(root, 15);
    System.out.println("Is there a root-to-leaf path with sum 15? " + hasSum15);

    // 3. Lowest Common Ancestor
    // For demonstration, assume we want LCA of nodes with values 6 and 7.
    // (In practice, you would locate the actual nodes; here we assume unique values.)
    TreeNode lca = lowestCommonAncestor(root, new TreeNode(6), new TreeNode(7));
    System.out.println(
        "Lowest Common Ancestor of 6 and 7 (by value): " + (lca != null ? lca.val : "None"));
    // Expected LCA is 5.

    // 4. Distance Between Two Nodes
    // Using our helper (note: this simplistic method assumes unique values and uses value
    // matching).
    int distance = distanceBetweenNodes(root, 6, 8);
    System.out.println("Distance between nodes with values 6 and 8: " + distance);
    // Expected: distance = 4 (6->5->3->1->8)

    // 5. Ancestors of a Node
    List<Integer> ancestorsOf7 = ancestors(root, 7);
    System.out.println("Ancestors of node 7: " + ancestorsOf7);
    // Expected: [2,5,3] (depending on order, typically bottom-up).

    // 6. Paths Matching a Specific Pattern
    List<Integer> pattern = Arrays.asList(3, 5);
    List<List<Integer>> matchingPaths = pathsMatchingPattern(root, pattern);
    System.out.println("Paths matching the pattern " + pattern + ":");
    for (List<Integer> path : matchingPaths) {
      System.out.println(path);
    }
    // Expected: Paths that start with 3,5 (e.g., [3,5,6] and [3,5,2,7])
  }
}
