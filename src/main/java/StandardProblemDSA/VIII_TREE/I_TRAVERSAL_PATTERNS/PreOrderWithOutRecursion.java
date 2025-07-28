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

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
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
