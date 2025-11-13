package StandardProblemDSA.VIII_TREE.VII_OPTIMISATIN_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

public class ClientOfTreeMetrics {
  /*
   Problems:

   1. Diameter of a Binary Tree
      - Find the length of the longest path between any two nodes in the tree.
      - Approach:
          - Use recursion to get the height of each subtree.
          - Update a global `diameter` with the sum of left and right heights at each node.
      - Pattern: Tree DP, Postorder Traversal
      - Similar LeetCode: 543. Diameter of Binary Tree
      - Time: O(n), Space: O(h)

   2. Maximum Path Sum in Binary Tree
      - Find the maximum path sum, where a path can start and end at any node.
      - Approach:
          - Use recursion to compute max gain from each node.
          - Track a global max (`maxPathSumGlobal`) updated with node + left gain + right gain.
      - Pattern: Tree DP, Postorder Traversal with Global Tracking
      - Similar LeetCode: 124. Binary Tree Maximum Path Sum
      - Time: O(n), Space: O(h)

   3. Longest Zigzag Path in Binary Tree
      - Find the length of the longest path with alternating left-right directions.
      - Approach:
          - Recursively compute zigzag length by keeping track of direction and path length.
          - Maintain a global `longestZigzag`.
      - Pattern: DFS with State (direction, length)
      - Similar LeetCode: 1372. Longest ZigZag Path in a Binary Tree
      - Time: O(n), Space: O(h)

   4. Largest BST Subtree in Binary Tree
      - Find the size of the largest subtree that is also a valid BST.
      - Approach:
          - Postorder traversal returns:
              * whether subtree is BST
              * size of BST
              * min & max values of subtree
          - Update a global `largestBSTSize`.
      - Pattern: Postorder DFS with State Propagation
      - Similar LeetCode: 333. Largest BST Subtree
      - Time: O(n), Space: O(h)

   Follow-up Questions:
      - Diameter:
          * Can you print the path forming the diameter?
      - Max Path Sum:
          * How to modify if negative values are not allowed?
      - Zigzag Path:
          * How would you handle an n-ary tree?
      - Largest BST Subtree:
          * Can you also return the root of the largest BST?

  */

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {
    ClientOfTreeMetrics ops = new ClientOfTreeMetrics();

    // Build sample tree for depth/diameter/zigzag/path sum demonstration:
    //          1
    //         / \
    //        2   3
    //       / \   \
    //      4   5   6
    //           \
    //            7
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.left.right.right = new TreeNode(7);

    System.out.println("Maximum Depth: " + TreeUtility.maxDepth(root)); // Expected: 4
    System.out.println("Minimum Depth: " + TreeUtility.minDepth(root)); // Expected: 3
    System.out.println(
        "Diameter of Tree: "
            + DiameterOfBinaryTree.diameterOfBinaryTree(root)); // Expected: 4 (edge count)
    System.out.println(
        "Maximum Path Sum: " + MaxPathSumBinaryTree.maxPathSum(root)); // Depends on node values
    System.out.println(
        "Longest Zigzag Path: "
            + LongestZigZagPathInBinaryTree.longestZigzagPath(
                root)); // Expected: length depends on zigzag

    // Build tree for Largest BST Subtree:
    //         10
    //        /  \
    //       5    15
    //      / \     \
    //     1   8     7   <-- Not BST because 7 < 15
    TreeNode bstTest = new TreeNode(10);
    bstTest.left = new TreeNode(5);
    bstTest.right = new TreeNode(15);
    bstTest.left.left = new TreeNode(1);
    bstTest.left.right = new TreeNode(8);
    bstTest.right.right = new TreeNode(7);

    System.out.println(
        "Largest BST Subtree Size: " + LargestBstTree.largestBSTSubtree(bstTest)); // Expected: 3
  }
}
