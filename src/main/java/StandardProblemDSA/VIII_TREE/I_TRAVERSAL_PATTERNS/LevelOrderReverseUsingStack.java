package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import java.util.*;

public class LevelOrderReverseUsingStack {}

/*
4️⃣ Level Order Traversal Using Stack (Reverse BFS)
(Bottom-Up Level Order)
        🔹 Steps:
Use queue for BFS traversal.

Use stack to store traversal order.

Pop from stack to get bottom-up order.

*/

class LevelOrderReverse {
  static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  public static void levelOrderReverse(TreeNode root) {
    if (root == null) return;

    Queue<TreeNode> queue = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      stack.push(node); // Push to stack

      if (node.right != null) queue.add(node.right);
      if (node.left != null) queue.add(node.left);
    }

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
        Copy
Edit
4 5 6 2 3 1*/
