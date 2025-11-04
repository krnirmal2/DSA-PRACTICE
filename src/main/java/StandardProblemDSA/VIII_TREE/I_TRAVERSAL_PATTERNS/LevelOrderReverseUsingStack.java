package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderReverseUsingStack {
  /*
   Problem: Print the reverse level order traversal of a binary tree.

   Given the root of a binary tree, print all nodes in reverse level order (from bottom to top,
   and from left to right within each level).

   Example:
   Input:
          1
         / \
        2   3
       / \   \
      4   5   6
   Output: 4 5 6 2 3 1

   Pattern:
      - Tree Traversal
      - BFS with Queue + Stack
      - Reverse Level Order Traversal

   Similar LeetCode Problems:
      - 107. Binary Tree Level Order Traversal II DONE
      - 102. Binary Tree Level Order Traversal DONE
      - 199. Binary Tree Right Side View DONE

   Follow-up Questions:
      - How to do this without using an explicit stack?
      - Can you print nodes level by level in reverse order?
      - How to modify for n-ary trees?
      - How to implement recursively?

   Time Complexity: O(n), n = number of nodes
   Space Complexity: O(n), for queue and stack
  */

  public static void levelOrderReverse(TreeNode root) {
    if (root == null) return;

    Queue<TreeNode> queue = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      // Extra things that need use stack to push the nodes
      stack.push(node); // Push to stack
      // right  first put in the quest and then left but
      if (node.right != null) queue.add(node.right);
      if (node.left != null) queue.add(node.left);
    }
    // After
    while (!stack.isEmpty()) {
      System.out.print(stack.pop().val + " ");
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);

    levelOrderReverse(root);
  }
}
/*🔹 Output
4 5 6 2 3 1*/
/*
4️⃣ Level Order Traversal Using Stack (Reverse BFS)
(Bottom-Up Level Order)
        🔹 Steps:
Use queue for BFS traversal.
Use stack to store traversal order.
Pop from stack to get bottom-up order.

*/
