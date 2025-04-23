package StandardProblemDSA.VIII_TREE.VII_OPTIMISATIN_PATTERNS;

public class TreeMetricsOperations {

  // ---------------------------------------------------
  // Definition for a binary tree node.
  // ---------------------------------------------------
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
      left = right = null;
    }
  }

  // ---------------------------------------------------
  // 1. Maximum Depth/Height of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Compute the maximum depth (height) of a binary tree, defined as the number of nodes
       along the longest path from the root down to the farthest leaf node.

    Brute Force Idea:
       - Traverse all paths from root to leaves and take the maximum.

    Optimal Approach:
       - Use recursion: height(root) = max(height(root.left), height(root.right)) + 1.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
            /
           4
       Maximum Depth: 3 (path: 1→2→4)
  */
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  // ---------------------------------------------------
  // 2. Minimum Depth/Height of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Compute the minimum depth of a binary tree, defined as the number of nodes along the
       shortest path from the root node down to the nearest leaf node.

    Optimal Approach:
       - Use recursion. Special care is needed when one subtree is null.
         If a node has no left child, use the minimum depth from the right, and vice versa.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              /
             2
              \
               3
       Minimum Depth: 3 (path: 1→2→3, since 3 is a leaf)
  */
  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    // If one subtree is missing, we use the depth of the other subtree.
    if (root.left == null) return minDepth(root.right) + 1;
    if (root.right == null) return minDepth(root.left) + 1;
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }

  // ---------------------------------------------------
  // 3. Diameter of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Find the diameter (or width) of a binary tree, defined as the length (number of edges)
       of the longest path between any two nodes in the tree.

    Optimal Approach:
       - Use recursion to compute the height of each subtree while updating a global diameter.
       - Diameter at a node = height(left) + height(right).

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
            / \
           4   5
       Diameter: 3 (path: 4 → 2 → 1 → 3 or 4→2→5 if defined in edges; here, 3 edges)
  */
  private int diameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    heightForDiameter(root);
    return diameter;
  }

  // Helper method returns height while updating diameter.
  private int heightForDiameter(TreeNode node) {
    if (node == null) return 0;
    int leftHeight = heightForDiameter(node.left);
    int rightHeight = heightForDiameter(node.right);
    diameter = Math.max(diameter, leftHeight + rightHeight);
    return Math.max(leftHeight, rightHeight) + 1;
  }

  // ---------------------------------------------------
  // 4. Maximum Path Sum in Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Find the maximum path sum in a binary tree. A path may start and end at any node,
       and the path must go downward (traveling from parent to child).
       (Some variations allow any path in the tree.)

    Optimal Approach:
       - Use recursion to compute the maximum gain from each node and update a global maximum.
       - At each node, consider the best path including the node and possibly one of its subtrees.

    Time Complexity: O(n)

    Example:
       For tree:
               -10
               /  \
              9   20
                 /  \
                15   7
       Maximum Path Sum: 42 (path: 15 → 20 → 7 or 15 + 20 + 7, depending on interpretation)
       (Typically the correct path is 15 + 20 + 7 = 42.)
  */
  private int maxPathSumGlobal = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxPathSumGlobal;
  }

  // Helper: maximum gain from node.
  private int maxGain(TreeNode node) {
    if (node == null) return 0;
    int leftGain = Math.max(maxGain(node.left), 0);
    int rightGain = Math.max(maxGain(node.right), 0);
    // Price to start a new path where node is highest node.
    int priceNewPath = node.val + leftGain + rightGain;
    maxPathSumGlobal = Math.max(maxPathSumGlobal, priceNewPath);
    // For recursion, return the max gain if continue the same path.
    return node.val + Math.max(leftGain, rightGain);
  }

  // ---------------------------------------------------
  // 5. Longest Zigzag Path in Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Find the length of the longest zigzag path in a binary tree.
       A zigzag path is defined as a sequence where the direction of travel alternates between left and right.
       The length is defined as the number of edges in the path.

    Optimal Approach:
       - Use recursion and at each node maintain two values:
           * The length of the zigzag path if we take a left turn.
           * The length of the zigzag path if we take a right turn.
       - Update a global maximum.

    Time Complexity: O(n)

    Example:
       For tree:
               1
              / \
             2   3
              \
               4
              /
             5
       Longest Zigzag Path: 3 (e.g., 1→2→4→5 with alternating directions)
  */
  private int longestZigzag = 0;

  public int longestZigzagPath(TreeNode root) {
    zigzag(root, true, 0);
    zigzag(root, false, 0);
    return longestZigzag;
  }

  // Helper: direction = true means previous move was to left, so now go right; false means vice
  // versa.
  private void zigzag(TreeNode node, boolean isLeft, int length) {
    if (node == null) return;
    longestZigzag = Math.max(longestZigzag, length);
    if (isLeft) {
      // Last move was left, now try to move right.
      zigzag(node.right, false, length + 1);
      // Also, restart from left child.
      zigzag(node.left, true, 1);
    } else {
      // Last move was right, now try to move left.
      zigzag(node.left, true, length + 1);
      // Also, restart from right child.
      zigzag(node.right, false, 1);
    }
  }

  // ---------------------------------------------------
  // 6. Largest BST Subtree in Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Find the size (number of nodes) of the largest subtree in a binary tree that is a valid BST.

    Optimal Approach:
       - Use recursion to return for each subtree: whether it's a BST, its size, its minimum, and its maximum.
       - Combine information from left and right children to decide if the current subtree is BST.

    Time Complexity: O(n)

    Example:
       For tree:
               10
              /  \
             5    15
            / \     \
           1   8     7
       The largest BST subtree is:
               5
              / \
             1   8
       Size: 3.
  */
  class BSTInfo {
    boolean isBST;
    int size;
    int min;
    int max;

    BSTInfo(boolean isBST, int size, int min, int max) {
      this.isBST = isBST;
      this.size = size;
      this.min = min;
      this.max = max;
    }
  }

  private int largestBSTSize = 0;

  public int largestBSTSubtree(TreeNode root) {
    largestBSTSize = 0;
    postorderBST(root);
    return largestBSTSize;
  }

  private BSTInfo postorderBST(TreeNode node) {
    if (node == null) return new BSTInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

    BSTInfo leftInfo = postorderBST(node.left);
    BSTInfo rightInfo = postorderBST(node.right);

    if (leftInfo.isBST && rightInfo.isBST && node.val > leftInfo.max && node.val < rightInfo.min) {
      int size = leftInfo.size + rightInfo.size + 1;
      largestBSTSize = Math.max(largestBSTSize, size);
      int min = (node.left != null) ? leftInfo.min : node.val;
      int max = (node.right != null) ? rightInfo.max : node.val;
      return new BSTInfo(true, size, min, max);
    } else {
      // Not a BST; size not needed here.
      return new BSTInfo(false, 0, 0, 0);
    }
  }

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {
    TreeMetricsOperations ops = new TreeMetricsOperations();

    // Build sample tree for depth/diameter/zigzag/path sum demonstration:
    //          1
    //         / \
    //        2   3
    //       / \   \
    //      4   5   6
    //           \
    //            7
    TreeNode root = ops.new TreeNode(1);
    root.left = ops.new TreeNode(2);
    root.right = ops.new TreeNode(3);
    root.left.left = ops.new TreeNode(4);
    root.left.right = ops.new TreeNode(5);
    root.right.right = ops.new TreeNode(6);
    root.left.right.right = ops.new TreeNode(7);

    System.out.println("Maximum Depth: " + ops.maxDepth(root)); // Expected: 4
    System.out.println("Minimum Depth: " + ops.minDepth(root)); // Expected: 3
    System.out.println(
        "Diameter of Tree: " + ops.diameterOfBinaryTree(root)); // Expected: 4 (edge count)
    System.out.println("Maximum Path Sum: " + ops.maxPathSum(root)); // Depends on node values
    System.out.println(
        "Longest Zigzag Path: "
            + ops.longestZigzagPath(root)); // Expected: length depends on zigzag

    // Build tree for Largest BST Subtree:
    //         10
    //        /  \
    //       5    15
    //      / \     \
    //     1   8     7   <-- Not BST because 7 < 15
    TreeNode bstTest = ops.new TreeNode(10);
    bstTest.left = ops.new TreeNode(5);
    bstTest.right = ops.new TreeNode(15);
    bstTest.left.left = ops.new TreeNode(1);
    bstTest.left.right = ops.new TreeNode(8);
    bstTest.right.right = ops.new TreeNode(7);

    System.out.println(
        "Largest BST Subtree Size: " + ops.largestBSTSubtree(bstTest)); // Expected: 3
  }
}
