package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.Stack;

public class InorderWithoutRecursion {
  /*
    (Left → Root → Right)
            🔹 Steps:
    Push all left nodes to stack.
    Process top node (print/store).
    Move to right child and repeat.
  */

  public static void inorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (current != null || !stack.isEmpty()) {
      while (current != null) { // Push all left nodes
        stack.push(current);
        current = current.left;
      }

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
