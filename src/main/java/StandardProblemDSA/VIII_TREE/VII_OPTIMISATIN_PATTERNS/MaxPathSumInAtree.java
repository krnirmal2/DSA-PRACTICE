package StandardProblemDSA.VIII_TREE.VII_OPTIMISATIN_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

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
