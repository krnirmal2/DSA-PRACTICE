package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class VerticalTraversing {

  // A utility function to find min and max
  // distances with respect to root.
  static void findMinMax(TreeNode node, int[] minMax, int hd) {

    // Base case
    if (node == null) return;

    // Update min and max
    if (hd < minMax[0]) minMax[0] = hd;
    else if (hd > minMax[1]) minMax[1] = hd;

    // Recur for left and right subtrees
    findMinMax(node.left, minMax, hd - 1);
    findMinMax(node.right, minMax, hd + 1);
  }

  // A utility function to collect all
  // TreeNode on a given vertical line_no.
  static void collectVerticalLine(TreeNode node, int lineNo, int hd, List<Integer> result) {
    // Base case
    if (node == null) return;

    // If this node is on the given vertical line
    if (hd == lineNo) result.add(node.val);

    // Recur for left and right subtrees
    collectVerticalLine(node.left, lineNo, hd - 1, result);
    collectVerticalLine(node.right, lineNo, hd + 1, result);
  }

  // The main function that returns a list of TreeNode
  // in vertical order
  static List<Integer> verticalOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    // Find min and max distances with respect to root
    int[] minMax = new int[] {0, 0};
    findMinMax(root, minMax, 0);

    // Iterate through all possible vertical
    // lines from leftmost to rightmost
    for (int lineNo = minMax[0]; lineNo <= minMax[1]; lineNo++) {
      collectVerticalLine(root, lineNo, 0, result);
    }

    return result;
  }

  public static void main(String[] args) {

    // Create binary tree
    //            1
    //          /   \
    //         2     3
    //        / \   / \
    //       4   5 6   7
    //              \   \
    //               8   9

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.right = new TreeNode(9);

    List<Integer> result = verticalOrder(root);

    for (int val : result) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}
