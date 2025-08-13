package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
  /*
   Problem: Perform level order traversal of a binary tree.

   Given the root of a binary tree, return the level order traversal
   (from top to bottom, left to right) of its nodes' values.

   Example:
   Input:
          1
         / \
        2   3
       / \     \
      4   5     6
   Output: [1, 2, 3, 4, 5, 6]

   Pattern:
      - Tree Traversal
      - BFS using Queue
      - Level Order Traversal

   Similar LeetCode Problems:
      - 102. Binary Tree Level Order Traversal
      - 107. Binary Tree Level Order Traversal II
      - 429. N-ary Tree Level Order Traversal

   Follow-up Questions:
      - How to print nodes level by level (list of lists)?
      - Can you implement without using extra space (Morris traversal)?
      - How to modify for zigzag (spiral) traversal?
      - How to handle very large trees?

   Time Complexity: O(n), n = number of nodes
   Space Complexity: O(n), for the queue
  */

  public List<Integer> levelOrderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      result.add(curr.val);
      if (curr.left != null) queue.offer(curr.left);
      if (curr.right != null) queue.offer(curr.right);
    }
    return result;
  }
}
