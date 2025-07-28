package StandardProblemDSA.VIII_TREE.VII_OPTIMISATIN_PATTERNS;

import StandardProblemDSA.VIII_TREE.BST.BSTutility;
import StandardProblemDSA.VIII_TREE.TreeNode;

/*
 Problem: Find the size of the largest BST (Binary Search Tree) within a given Binary Tree.

 Approach:
   - Traverse the tree recursively.
   - For each node:
       - Check if the subtree rooted at this node is a valid BST using `validateBST`.
       - If yes, return the size of this subtree.
       - Otherwise, recursively find the largest BST size in the left and right subtrees.
   - Return the maximum size found.

 Pattern:
   - Tree Traversal + Validation
   - Divide and Conquer

 Similar LeetCode Problems:
   - 333. Largest BST Subtree
   - 98. Validate Binary Search Tree

 Follow-up Questions:
   - Can we optimize to avoid repeated BST validation (O(n²))?
   - How to return both size and structure of the largest BST?
   - Can you modify it to return the root of the largest BST?

 Time Complexity: O(n²) in the worst case (checking BST repeatedly for each node)
 Space Complexity: O(h), where h = height of the tree (recursion stack)
*/

// Java Program to find Size of Largest
// BST in a Binary Tree
/*The idea is simple, we traverse through the Binary tree (starting from root). For every node, we check if it is BST.
If yes, then we return size of the subtree rooted with current node. Else, we recursively call for left and right
subtrees and return the maximum of two calls.*/
public class LargestBST {
  // Returns size of a tree
  static int size(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + size(root.left) + size(root.right);
  }

  // Finds the size of the largest BST
  public static int largestBst(TreeNode root) {

    // If tree is empty
    if (root == null) {
      return 0;
    }

    // If whole tree is BST
    if (BSTutility.validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
      return size(root);
    }

    // If whole tree is not BST
    return Math.max(largestBst(root.left), largestBst(root.right));
  }

  public static void main(String[] args) {

    // Constructed binary tree looks like this:
    //         50
    //       /    \
    //     75      45
    //    /
    //  40

    TreeNode root = new TreeNode(50);
    root.left = new TreeNode(75);
    root.right = new TreeNode(45);
    root.left.left = new TreeNode(40);
    System.out.println(largestBst(root));
  }
}
