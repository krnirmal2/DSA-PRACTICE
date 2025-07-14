package StandardProblemDSA.VIII_TREE.VI_COUNTING_AND_SUMMATION_PATTERNS;

import StandardProblemDSA.VIII_TREE.Pair;
import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class AlternateLevelNodeSum {
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
