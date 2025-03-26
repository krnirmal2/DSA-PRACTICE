package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import java.util.Stack;

public class PreOrderWithOutRecursion {
  static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  /*(Root → Left → Right)
          🔹 Steps:
  Push root to stack.

  Process node (print/store).

  Push right, then left child.*/
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
