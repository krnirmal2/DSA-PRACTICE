package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

import java.util.Stack;

class PostorderWithoutRecursion {

  /*(Left → Right → Root)
  🔹 Steps:
  Use two stacks:
  stack1 (process nodes like Preorder)
  stack2 (reverse order for Postorder)
  Pop from stack2 to print result.*/
  /*
   Problem: Perform postorder traversal of a binary tree without recursion.

   Given the root of a binary tree, print the postorder traversal (Left → Right → Root)
   using two stacks instead of recursion.

   Example:
   Input:
          1
         / \
        2   3
       / \   \
      4   5   6
   Output: 4 5 2 6 3 1

   Pattern:
      - Tree Traversal
      - Postorder Traversal
      - Iterative DFS using two stacks

   Similar LeetCode Problems:
      - 145. Binary Tree Postorder Traversal
      - 144. Binary Tree Preorder Traversal
      - 94. Binary Tree Inorder Traversal

   Follow-up Questions:
      - Can this be done using only one stack?
      - How to implement postorder traversal recursively?
      - How to handle very deep trees without stack overflow?
      - Can we modify to return the values instead of printing?

   Time Complexity: O(n), n = number of nodes
   Space Complexity: O(n), for the two stacks
  */

  public static void postOrderWithoutRecursion(TreeNode root) {
    if (root == null) return;

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(root);

    while (!stack1.isEmpty()) {
      TreeNode node = stack1.pop();
      stack2.push(node);

      if (node.left != null) stack1.push(node.left);
      if (node.right != null) stack1.push(node.right);
    }

    while (!stack2.isEmpty()) {
      System.out.print(stack2.pop().val + " ");
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);

    postOrderWithoutRecursion(root);
  }
}
