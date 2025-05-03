package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
  // ---------------------------------------------------
  // 2. Level Order Traversal of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Traverse a binary tree level by level (breadth-first) and return a list of values.

    Brute Force Approach:
       - Use recursion for each level (inefficient).

    Optimal Approach:
       - Use a queue to perform a breadth-first search (BFS).

    Time Complexity: O(n)

    Example:
       For the same BST above, level order output: [4, 2, 6, 1, 3, 5, 7]
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
