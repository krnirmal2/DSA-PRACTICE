package StandardProblemDSA.VIII_TREE.V_VALIDATION_AND_PROPERTY_CHECKING_PATTERN;

import static StandardProblemDSA.VIII_TREE.BST.BSTutility.height;
import static StandardProblemDSA.VIII_TREE.TreeUtility.isIdentical;

import StandardProblemDSA.VIII_TREE.BST.BSTutility;
import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;
import java.util.LinkedList;
import java.util.Queue;

public class TreeCheckOperations {

  // ---------------------------------------------------
  // 2. Check if Tree is Symmetric
  // ---------------------------------------------------
  /*
    Problem Statement:
       Determine if a binary tree is symmetric (a mirror of itself).

    Brute Force Idea:
       - Generate the mirror of the tree and then compare with the original.

    Optimal Approach:
       - Use a helper method to compare the left subtree with the right subtree.
       - Two trees are mirror images if the value at the root is the same and
         the right subtree of one is a mirror of the left subtree of the other.

    Time Complexity: O(n)

    Example:
       Tree:
              1
             / \
            2   2
           /     \
          3       3
       This tree is not symmetric because the left and right subtrees differ.
       A symmetric example would have both subtrees matching.
  */
  public static boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return TreeUtility.isMirror(root.left, root.right);
  }

  // ---------------------------------------------------
  // 3. Validate Binary Search Tree (BST)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Determine if a binary tree is a valid binary search tree (BST).

    Brute Force Idea:
       - Inorder traverse the tree and check if the result is a sorted list.

    Optimal Approach:
       - Recursively validate each node by ensuring its value is within an allowed range.
       - For the root, the range is (-∞, ∞). For left child, update upper bound; for right child, update lower bound.

    Time Complexity: O(n)

    Example:
       Tree:
              5
             / \
            3   7
       This tree is a valid BST.
  */
  public static boolean isValidBST(TreeNode root) {
    return BSTutility.validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  // ---------------------------------------------------
  // 4. Subtree of Another Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Check if one tree (T) is a subtree of another tree (S). T is a subtree of S if there exists a node in S
       such that the subtree rooted at that node is identical to T.

    Brute Force Idea:
       - For every node in S, check if T is identical to the subtree starting at that node.

    Optimal Approach:
       - Use recursion: if the current node in S matches T’s root, check for identical structure.

    Time Complexity: O(m*n) worst-case, where m and n are the number of nodes in S and T respectively.

    Example:
       S:        3           T:       4
               /   \                /
              4     5              1
             / \
            1   2
       T is a subtree of S.
  */
  public static boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return t == null;
    if (isIdentical(s, t)) return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  // ---------------------------------------------------
  // 5. Check if Tree is Balanced
  // ---------------------------------------------------
  /*
    Problem Statement:
       A binary tree is balanced if the heights of its two subtrees differ by no more than one at every node.

    Brute Force Idea:
       - For each node, compute the height of left and right subtrees, then check the difference.

    Optimal Approach:
       - Use recursion to compute height; if at any point the tree is not balanced, propagate a failure flag (e.g., return -1).

    Time Complexity: O(n)

    Example:
       Tree:
              1
             / \
            2   3
           /
          4
       This tree is balanced if the height difference is ≤ 1 at every node.
  */
  public static boolean isBalanced(TreeNode root) {
    return height(root) != -1;
  }

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
    Queue<TreeNode> queue = new LinkedList<>();
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

  public static boolean isFull(TreeNode root) {
    if (root == null) return true;
    if ((root.left == null && root.right != null) || (root.left != null && root.right == null))
      return false;
    return isFull(root.left) && isFull(root.right);
  }

  // ---------------------------------------------------
  // Main method for demonstration
  // ---------------------------------------------------
  public static void main(String[] args) {
    TreeCheckOperations ops = new TreeCheckOperations();

    // Build sample trees for demonstration:
    // Tree 1 (for identical, symmetric, balanced, BST check):
    //        1
    //       / \
    //      2   3
    //     / \
    //    4   5
    TreeNode tree1 = new TreeNode(1);
    tree1.left = new TreeNode(2);
    tree1.right = new TreeNode(3);
    tree1.left.left = new TreeNode(4);
    tree1.left.right = new TreeNode(5);

    // Clone tree1 for identical check.
    TreeNode tree1Clone = new TreeNode(1);
    tree1Clone.left = new TreeNode(2);
    tree1Clone.right = new TreeNode(3);
    tree1Clone.left.left = new TreeNode(4);
    tree1Clone.left.right = new TreeNode(5);

    // 1. Check if Two Trees are Identical
    boolean identical = isIdentical(tree1, tree1Clone);
    System.out.println("Tree1 and its clone are identical: " + identical);

    // 2. Check if Tree is Symmetric
    // For symmetric tree, build:
    //         1
    //        / \
    //       2   2
    //      /     \
    //     3       3
    TreeNode symmetricTree = new TreeNode(1);
    symmetricTree.left = new TreeNode(2);
    symmetricTree.right = new TreeNode(2);
    symmetricTree.left.left = new TreeNode(3);
    symmetricTree.right.right = new TreeNode(3);
    boolean symmetric = isSymmetric(symmetricTree);
    System.out.println("The tree is symmetric: " + symmetric);

    // 3. Validate Binary Search Tree (BST)
    // For BST, build:
    //         5
    //        / \
    //       3   7
    //      / \   \
    //     2   4   8
    TreeNode bst = new TreeNode(5);
    bst.left = new TreeNode(3);
    bst.right = new TreeNode(7);
    bst.left.left = new TreeNode(2);
    bst.left.right = new TreeNode(4);
    bst.right.right = new TreeNode(8);
    boolean validBST = isValidBST(bst);
    System.out.println("The BST is valid: " + validBST);

    // 4. Subtree of Another Tree
    // Check if subtree t is a subtree of s.
    // Let s = bst (above) and t be:
    //       3
    //      / \
    //     2   4
    TreeNode t = new TreeNode(3);
    t.left = new TreeNode(2);
    t.right = new TreeNode(4);
    boolean isSub = isSubtree(bst, t);
    System.out.println("t is a subtree of bst: " + isSub);

    // 5. Check if Tree is Balanced
    boolean balanced = isBalanced(tree1);
    System.out.println("Tree1 is balanced: " + balanced);

    // 6. Check if Tree is Complete or Full
    // Complete Tree example:
    //        1
    //       / \
    //      2   3
    //     / \  /
    //    4  5 6
    TreeNode completeTree = new TreeNode(1);
    completeTree.left = new TreeNode(2);
    completeTree.right = new TreeNode(3);
    completeTree.left.left = new TreeNode(4);
    completeTree.left.right = new TreeNode(5);
    completeTree.right.left = new TreeNode(6);
    boolean complete = isComplete(completeTree);
    System.out.println("The tree is complete: " + complete);

    // Full Tree example:
    //        1
    //       / \
    //      2   3
    //     / \ / \
    //    4  5 6  7
    TreeNode fullTree = new TreeNode(1);
    fullTree.left = new TreeNode(2);
    fullTree.right = new TreeNode(3);
    fullTree.left.left = new TreeNode(4);
    fullTree.left.right = new TreeNode(5);
    fullTree.right.left = new TreeNode(6);
    fullTree.right.right = new TreeNode(7);
    boolean full = isFull(fullTree);
    System.out.println("The tree is full: " + full);
  }
}
