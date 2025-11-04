package StandardProblemDSA.VIII_TREE.VI_COUNTING_AND_SUMMATION_PATTERNS;

import StandardProblemDSA.VIII_TREE.Pair;
import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class AlternateLevelNodeSum {
  /*
   Problem: Calculate the sum of all nodes at alternate levels of a binary tree (levels 0, 2, 4, ...).

   Approach:
      - Perform BFS using a queue.
      - Track the level number for each node.
      - Add node values to the sum if the level is even.

   Pattern:
      - Level Order Traversal (BFS)
      - Pairing node with its level

   Similar LeetCode Problems:
      - 637. Average of Levels in Binary Tree
      - 102. Binary Tree Level Order Traversal

   Time Complexity: O(n), n = number of nodes
   Space Complexity: O(n), queue storage for BFS
  */

  public static int sumOfAlternateLevels(TreeNode root) {
    if (root == null) return 0;

    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));

    int sum = 0;

    while (!queue.isEmpty()) {
      Pair current = queue.poll();
      TreeNode node = current.node;
      int level = current.hd;

      if (level % 2 == 0) {
        sum += node.val;
      }

      if (node.left != null) queue.add(new Pair(node.left, level + 1));
      if (node.right != null) queue.add(new Pair(node.right, level + 1));
    }

    return sum;
  }

  // Optional: test the method
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    System.out.println(sumOfAlternateLevels(root)); // Output: 23
  }
}
