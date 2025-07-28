package StandardProblemDSA.VIII_TREE.V_VALIDATION_AND_PROPERTY_CHECKING_PATTERN;

import StandardProblemDSA.VIII_TREE.TreeNode;

import static StandardProblemDSA.VIII_TREE.TreeUtility.isIdentical;

public class TreeCheckOperations {
  /*
   Problem: Demonstrate binary tree checking operations.

   Features implemented:
    1. Check if two trees are identical
    2. Check if a tree is symmetric (mirror image of itself)
    3. Validate whether a binary tree is a Binary Search Tree (BST)
    4. Check if one tree is a subtree of another
    5. Check if a tree is height-balanced (difference in heights ≤ 1)
    6. Check if a tree is complete (all levels filled except possibly last, filled from left)
    7. Check if a tree is full (every node has either 0 or 2 children)

   Example Trees:
    - Identical check:
          1
         / \
        2   3
       / \
      4   5

    - Symmetric check:
          1
         / \
        2   2
       /     \
      3       3

    - BST validation:
          5
         / \
        3   7
       / \    \
      2   4    8

    - Subtree check:
          3
         / \
        2   4

    - Complete tree:
          1
         / \
        2   3
       / \  /
      4  5 6

    - Full tree:
          1
         / \
        2   3
       / \ / \
      4  5 6  7

   Patterns:
      - Tree Traversal (DFS and BFS)
      - Recursive checks
      - Structural and property validations

   Similar LeetCode Problems:
      - 100. Same Tree
      - 101. Symmetric Tree
      - 98. Validate Binary Search Tree
      - 572. Subtree of Another Tree
      - 110. Balanced Binary Tree
      - 958. Check Completeness of a Binary Tree

   Follow-up Questions:
      - Can you check if a tree is perfect (complete + full)?
      - How would you implement `isBalanced` iteratively?
      - How to handle subtree check efficiently for large trees?
      - Can we validate BST using iterative inorder traversal?

   Time Complexity:
      - Each check: O(n), n = number of nodes in the tree
   Space Complexity:
      - O(h), h = height of the tree (recursion stack for DFS, queue for BFS)
  */

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
    boolean symmetric = IsSymmetricTree.isSymmetric(symmetricTree);
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
    boolean validBST = IsValidBst.isValidBST(bst);
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
    boolean isSub = IsSubtree.isSubtree(bst, t);
    System.out.println("t is a subtree of bst: " + isSub);

    // 5. Check if Tree is Balanced
    boolean balanced = isBalancedTree.isBalanced(tree1);
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
    boolean complete = IsCompleteBinaryTree.isComplete(completeTree);
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
    boolean full = IsFullTree.isFull(fullTree);
    System.out.println("The tree is full: " + full);
  }
}
