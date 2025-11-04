package StandardProblemDSA.VIII_TREE.V_VALIDATION_AND_PROPERTY_CHECKING_PATTERN;

import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBinaryTree {
  // ---------------------------------------------------
  // 6. Check if Tree is Complete or Full
  // ---------------------------------------------------
  /*
    Problem Statement:
       - A binary tree is complete if all levels are completely filled except possibly the last,
         and the last level has all keys as left as possible.
       - A binary tree is full if every node has either 0 or 2 children.

    Optimal Approaches:
       Complete Tree:
         - Perform a level order traversal. Once a null child is encountered, all subsequent nodes must be null.
         - Time Complexity: O(n)
       Full Tree:
         - Recursively check each node: if it's a leaf or has exactly two children.
         - Time Complexity: O(n)

    Example:
       Complete Tree Example:
              1
             / \
            2   3
           / \  /
          4   5 6
       Full Tree Example:
              1
             / \
            2   3
           / \ / \
          4  5 6  7
  */
  public static boolean isComplete(TreeNode root) {
    if (root == null) return true;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    boolean end = false;
    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      if (curr == null) {
        end = true;
      } else {
        if (end) return false; // if we've seen a null, no more nodes should be non-null.
        queue.offer(curr.left);
        queue.offer(curr.right);
      }
    }
    return true;
  }
}
