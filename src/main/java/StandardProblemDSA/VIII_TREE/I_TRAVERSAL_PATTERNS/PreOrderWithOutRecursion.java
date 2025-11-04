package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.Stack;

public class PreOrderWithOutRecursion {
  /*(Root → Left → Right)
          🔹 Steps:
  Push root to stack.
  Process node (print/store).
  Push right, then left child.*/
  /*
   Problem: Perform preorder traversal of a binary tree iteratively.

   Given the root of a binary tree, print the preorder traversal (Root → Left → Right)
   using an explicit stack instead of recursion.

   Example:
   Input:
          1
         / \
        2   3
       / \   \
      4   5   6
   Output: 1 2 4 5 3 6

   Pattern:
      - Tree Traversal
      - Preorder Traversal
      - Iterative DFS using Stack

   Similar LeetCode Problems:
      - 144. Binary Tree Preorder Traversal
      - 94. Binary Tree Inorder Traversal
      - 145. Binary Tree Postorder Traversal
          Validate Binary Search Tree
          Medium
          Binary Tree Preorder Traversal
          Easy
          Binary Tree Postorder Traversal
          Easy
          Binary Search Tree Iterator
          Medium
          Kth Smallest Element in a BST
          Medium
          Closest Binary Search Tree Value II
          Hard
          Inorder Successor in BST
          Medium
          Convert Binary Search Tree to Sorted Doubly Linked List
          Medium
          Minimum Distance Between BST Nodes
   Follow-up Questions:
      - How to do it recursively?
      - Can you implement Morris traversal (O(1) space)?
      - How to handle very deep trees without stack overflow?
      - Can you modify to return the values instead of printing?

   Time Complexity: O(n), n = number of nodes
   Space Complexity: O(h), h = height of the tree (stack space)
  */

  public static void preorderTraversal(TreeNode root) {
    if (root == null) return;
    // Step 1 : use stack and put the root it in to that
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    // Step 2 : now till the stack is not empty iterate and print value first and then push right
    // and left
    while (!stack.isEmpty()) {
      // take the node first and then check its right and left child till the leaf node we are not
      // encounter
      // and push its left and right to the
      TreeNode node = stack.pop(); // Process node
      System.out.print(node.val + " ");

      if (node.right != null) stack.push(node.right); // Push right first
      if (node.left != null) stack.push(node.left); // Then push left
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);

    preorderTraversal(root);
  }
  /*🔹 Dry Run
  Stack	Current Node	Output
  [1]	1	1
  [3, 2]	2	2
  [3, 5, 4]	4	4
  [3, 5]	5	5
  [3]	3	3
  [6]	6	6*/
}
