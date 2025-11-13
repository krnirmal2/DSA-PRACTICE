package StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS;

import static StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS.DistanceBetweenNodes.distanceBetweenNodes;
import static StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS.LCA.lowestCommonAncestor;
import static StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS.PathWitMaximumAndSpecificSum.hasPathSum;
import static StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS.PathWitMaximumAndSpecificSum.maxSumPath;
import static StandardProblemDSA.VIII_TREE.III_PATH_AND_ANCESTOR_PATTERNS.RootToLeafPathsPrint.rootToLeafPaths;

import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.Arrays;
import java.util.List;

public class PathAndAncestorMainClient extends PathsMatchToSpecificPatternInTree {
  /*
   Problem: Demonstrate various binary tree path operations.

   Features implemented:
    - Print all root-to-leaf paths
    - Find the path with the maximum sum
    - Check if there exists a root-to-leaf path with a given sum
    - Find the Lowest Common Ancestor (LCA) of two nodes
    - Calculate distance between two nodes
    - List all ancestors of a given node
    - Find paths matching a specific prefix pattern

   Example Tree:
          3
         / \
        5   1
       / \    \
      6   2    8
         /
        7

   Example Outputs:
    - Root-to-Leaf Paths: [3, 5, 6], [3, 5, 2, 7], [3, 1, 8]
    - Maximum Sum Path: [3, 5, 2, 7] with sum = 17
    - Has Path Sum 15? true
    - Lowest Common Ancestor of 6 and 7: 5
    - Distance between 6 and 8: 4
    - Ancestors of 7: [2, 5, 3]
    - Paths matching pattern [3, 5]: [[3, 5, 6], [3, 5, 2, 7]]

   Pattern:
      - DFS & BFS on Binary Trees
      - Path Sum, LCA, and Ancestor Finding
      - Pattern Matching in Paths

   Similar LeetCode Problems:
      - 257. Binary Tree Paths
      - 112. Path Sum
      - 236. Lowest Common Ancestor of a Binary Tree
      - 863. All Nodes Distance K in Binary Tree

   Follow-up Questions:
      - How to optimize for very large trees?
      - Can we find the maximum sum path without storing all paths?
      - How to handle duplicate node values?
      - Can we implement iterative versions of these operations?

   Time Complexity: O(n) for each operation, n = number of nodes
   Space Complexity: O(h), h = height of the tree (recursion stack)
  */

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {
    PathAndAncestorMainClient ops = new PathAndAncestorMainClient();

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
    PathWitMaximumAndSpecificSum.MaxPathResult maxPath = maxSumPath(root);
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
