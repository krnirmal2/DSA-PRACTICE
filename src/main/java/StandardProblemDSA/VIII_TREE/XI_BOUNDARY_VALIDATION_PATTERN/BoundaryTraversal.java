package StandardProblemDSA.VIII_TREE.XI_BOUNDARY_VALIDATION_PATTERN;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

import java.util.ArrayList;

public class BoundaryTraversal {
  /*
   Problem: Boundary Traversal of Binary Tree

   Print all the boundary nodes of a binary tree in anti-clockwise order:
      - Root node (if not a leaf)
      - Left boundary (excluding leaves)
      - All leaf nodes (from left to right)
      - Right boundary (excluding leaves, printed bottom-up)

   Example:
      Input:
              1
             / \
            2   3
           / \   \
          4   5   6
             / \
            7   8
      Output: [1, 2, 4, 7, 8, 6, 3]

   Pattern:
      - Tree Traversal
      - Boundary Traversal (modified preorder for left and right boundary, full DFS for leaves)

   Similar LeetCode Problems:
      - 545. Boundary of Binary Tree

   Follow-up Questions:
      - How would you handle skewed trees (all left or all right)?
      - Can you implement an iterative version?
      - How would you modify this for n-ary trees?
      - Can you print the boundary without using extra space?

   Time Complexity: O(n), where n = number of nodes
   Space Complexity: O(h) for recursion stack + O(n) for result
  */

  // Function to collect left boundary nodes
  // (top-down order)
  static void collectBoundaryLeft(TreeNode root, ArrayList<Integer> res) {
    if (root == null || TreeUtility.isLeaf(root)) return;

    res.add(root.val);
    if (root.left != null) collectBoundaryLeft(root.left, res);
    else if (root.right != null) collectBoundaryLeft(root.right, res);
  }

  // Function to collect all leaf nodes
  static void collectLeaves(TreeNode root, ArrayList<Integer> res) {
    if (root == null) return;

    if (TreeUtility.isLeaf(root)) {
      res.add(root.val);
      return;
    }

    collectLeaves(root.left, res);
    collectLeaves(root.right, res);
  }

  // Function to collect right boundary nodes
  // (bottom-up order)
  static void collectBoundaryRight(TreeNode root, ArrayList<Integer> res) {
    if (root == null || TreeUtility.isLeaf(root)) return;

    if (root.right != null) collectBoundaryRight(root.right, res);
    else if (root.left != null) collectBoundaryRight(root.left, res);

    res.add(root.val);
  }

  // Function to find Boundary Traversal of Binary Tree
  static ArrayList<Integer> boundaryTraversal(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();

    if (root == null) return res;

    // Add root val if it's not a leaf
    if (!TreeUtility.isLeaf(root)) res.add(root.val);

    // Collect left boundary
    collectBoundaryLeft(root.left, res);

    // Collect leaf nodes
    collectLeaves(root, res);

    // Collect right boundary
    collectBoundaryRight(root.right, res);

    return res;
  }

  public static void main(String[] args) {

    // Hardcoded Binary tree
    //        20
    //       /  \
    //      8    22
    //     / \     \
    //    4   12    25
    //       /  \
    //      10   14
    TreeNode root = new TreeNode(20);
    root.left = new TreeNode(8);
    root.right = new TreeNode(22);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(12);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);
    root.right.right = new TreeNode(25);

    ArrayList<Integer> boundary = boundaryTraversal(root);

    for (int x : boundary) System.out.print(x + " ");
  }
}
