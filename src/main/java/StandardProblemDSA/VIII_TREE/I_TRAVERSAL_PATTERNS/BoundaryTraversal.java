package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

/*
 Problem: Perform boundary traversal of a binary tree.

 Print the nodes on the boundary of a binary tree in anti-clockwise order:
  - Root node
  - Left boundary (excluding leaves)
  - All leaf nodes (left to right)
  - Right boundary (excluding leaves, printed bottom-up)

 Example:
 Input:
        1
       / \
      2   3
     / \   \
    4   5   6
       / \
      7   8
 Output: 1 2 4 7 8 6 3

 Pattern:
    - Tree Traversal
    - Boundary Traversal
    - DFS with custom order

 Similar LeetCode Problems:
    - 545. Boundary of Binary Tree
    - 94. Binary Tree Inorder Traversal
    - 199. Binary Tree Right Side View

 Follow-up Questions:
    - How to handle skewed trees (all left or all right)?
    - Can you implement an iterative version?
    - How to modify for n-ary trees?
    - How to handle duplicates or printing without extra space?

 Time Complexity: O(n), n = number of nodes
 Space Complexity: O(h), h = height of the tree (recursion stack)
*/

/*1. Boundary Traversal
Boundary Traversal of a Tree includes

 ● If root is not null:
        ○ Print root’s val
        ○ PrintLeftBoundary(root->left) // Print the left boundary nodes
        ○ PrintLeafNodes(root->left) // Print the leaf nodes of left subtree
        ○ PrintLeafNodes(root->right) // Print the leaf nodes of right subtree
        ○ PrintRightBoundary(root->right) // Print the right boundary nodes */
public class BoundaryTraversal {
  // Main function to perform boundary traversal
  public void boundaryTraversal(TreeNode root) {
    if (root == null) return;

    // Print root val
    System.out.print(root.val + " ");
    // INORDER TRAVERSAL OF THE TREE

    // Print left boundary excluding leaf nodes
    printLeftBoundary(root.left);

    // Print all leaf nodes
    printLeaves(root.left);
    printLeaves(root.right);

    // Print right boundary excluding leaf nodes (in bottom-up order)
    // at bottom we use l R R means inorder traversal
    printRightBoundary(root.right);
  }

  // Print the left boundary in top-down manner, excluding leaves
  private void printLeftBoundary(TreeNode node) {
    if (node == null) return;
    if (node.left != null) {
      // to ensure top-down, print before recursion
      System.out.print(node.val + " ");
      printLeftBoundary(node.left);
    } else if (node.right != null) {
      System.out.print(node.val + " ");
      printLeftBoundary(node.right);
    }
    // Do nothing for leaf node, this way we avoid duplicates in leaves
  }

  // Print all leaf nodes in left-to-right order
  private void printLeaves(TreeNode node) {
    if (node == null) return;
    printLeaves(node.left);
    if (node.left == null && node.right == null) {
      System.out.print(node.val + " ");
    }
    printLeaves(node.right);
  }

  // Print the right boundary in bottom-up manner, excluding leaves
  private void printRightBoundary(TreeNode node) {
    if (node == null) return;
    if (node.right != null) {
      // recursion first for bottom-up
      printRightBoundary(node.right);
      System.out.print(node.val + " ");
    } else if (node.left != null) {
      printRightBoundary(node.left);
      System.out.print(node.val + " ");
    }
    // Do nothing for leaf node
  }

  // Example usage
  public static void main(String[] args) {
    /* Construct the following tree:
              1
             / \
            2   3
           / \   \
          4   5   6
             / \ / \
            7  8 9  10
    */
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(8);
    root.right.right = new TreeNode(6);
    root.right.right.left = new TreeNode(9);
    root.right.right.right = new TreeNode(10);

    BoundaryTraversal bt = new BoundaryTraversal();
    bt.boundaryTraversal(root);
    // Expected output: 1 2 4 7 8 9 10 6 3
  }
}
