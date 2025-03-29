package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import java.util.Stack;

class PostorderTraversal {
  static class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
    }
  }

  /*(Left → Right → Root)
  🔹 Steps:
  Use two stacks:

  stack1 (process nodes like Preorder)

  stack2 (reverse order for Postorder)

  Pop from stack2 to print result.*/
  public static void postorderTraversal(TreeNode root) {
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

    postorderTraversal(root);
  }
}
