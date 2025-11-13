package StandardProblemDSA.VIII_TREE.VII_OPTIMISATIN_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

/*
 Problem: Find the maximum path sum in a binary tree.
 A path is any sequence of nodes from some starting node to any node
 in the tree along the parent-child connections. The path must contain
 at least one node and does not need to pass through the root.

 Approach:
   - Use recursion to calculate the maximum path sum starting at each node.
   - For each node:
       1. Compute the maximum path sum for its left and right subtrees.
       2. Only consider positive contributions (if negative, take 0).
       3. Update the global maximum (res) with the maximum path that
          passes through the current node (left + node + right).
       4. Return the maximum sum of paths that can be extended upwards
          (node + max(left, right)).

 Pattern:
   - Tree DP (postorder traversal)
   - Divide and Conquer with a global result tracker.

 Similar LeetCode Problems:
   - 124. Binary Tree Maximum Path Sum
   - 543. Diameter of Binary Tree (similar structure but counts nodes)

 Follow-up Questions:
   - How to also return the nodes forming the maximum path?
   - Can we modify it to allow paths with at least k nodes?
   - How to handle weighted graphs with negative cycles?

 Time Complexity: O(n), where n = number of nodes.
 Space Complexity: O(h), where h = height of the tree (recursion stack).
*/

public class MaxPathSumInAtree {
  // Returns the maximum path sum in the subtree with the current node as an endpoint.
  // Also updates 'res' with the maximum path sum.
  static int maxPathSumUtil(TreeNode root, int[] res) {
    // Base case: return 0 for a null node
    if (root == null) return 0;

    // Calculate maximum path sums for left and right subtrees
    int l = Math.max(0, maxPathSumUtil(root.left, res));
    int r = Math.max(0, maxPathSumUtil(root.right, res));

    // Update 'res' with the maximum path sum passing through the current node
    res[0] = Math.max(res[0], l + r + root.val);

    // Return the maximum path sum rooted at this node
    return root.val + Math.max(l, r);
  }

  // Returns maximum path sum in tree with given root
  static int maxPathSum(TreeNode root) {
    int[] res = {root.val};

    // Compute maximum path sum and store it in 'res'
    maxPathSumUtil(root, res);

    return res[0];
  }

  public static void main(String[] args) {
    // Representation of input binary tree:
    //            10
    //           /  \
    //          2    10
    //         / \     \
    //        20  1    -25
    //                 /  \
    //                3    4
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(2);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(20);
    root.left.right = new TreeNode(1);
    root.right.right = new TreeNode(-25);
    root.right.right.left = new TreeNode(3);
    root.right.right.right = new TreeNode(4);

    System.out.println(maxPathSum(root));
  }
}
