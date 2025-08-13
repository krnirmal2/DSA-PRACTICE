package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

import java.util.Stack;

public class InorderWithoutRecursion {
  /*
   Problem: Perform inorder traversal of a binary tree iteratively.

   Traverse the binary tree in inorder sequence (Left → Root → Right) using an explicit stack
   instead of recursion.

   Example:
   Input:
          1
           \
            2
           /
          3
   Output: 1 3 2

   Pattern:
      - Tree Traversal
      - Inorder Traversal
      - Iterative DFS using Stack

   Similar LeetCode Problems:
      - 94. Binary Tree Inorder Traversal DONE
      - 144. Binary Tree Preorder Traversal DONE
      - 145. Binary Tree Postorder Traversal DONE

   Follow-up Questions:
      - How to do it recursively?
      - Can you implement Morris traversal (O(1) space)?
      - How to handle very deep trees without stack overflow?
      - Can you modify to return the values instead of printing?

   Time Complexity: O(n), n = number of nodes
   Space Complexity: O(h), h = height of the tree (stack space)
  */

  public static void inorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    // Main intuition
    // we will not put the left or right child in the stack
    // but we will put the current node itself and iterate over left and right child
    // Also we take a node from the stack and go till its left and each time for current node we are
    // checking right child of it
    while (current != null || !stack.isEmpty()) {
      // we will first for the current node till all the left node and push it to stack
      while (current != null) { // Push all left nodes
        stack.push(current);
        current = current.left;
      }
      // we take the element from the stack and also check right if prsent after checking the left
      // of it
      current = stack.pop(); // Process node
      System.out.print(current.val + " ");

      current = current.right; // Move to right child
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);

    inorderTraversal(root);
  }
} /*
  🔹 Dry Run
    Stack	Current Node	Output
          [1]	2	-
          [1, 2]	4	-
          [1, 2, 4]	null	4
          [1, 2]	null	2
          [1]	5	5
          [1]	null	1
          []	3	3
          [3]	null	6
          🔹 Output
            Copy
    Edit
  4 2 5 1 3 6*/
