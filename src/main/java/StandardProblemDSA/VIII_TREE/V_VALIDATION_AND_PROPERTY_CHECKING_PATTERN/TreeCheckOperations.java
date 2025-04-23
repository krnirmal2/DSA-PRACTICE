package StandardProblemDSA.VIII_TREE.V_VALIDATION_AND_PROPERTY_CHECKING_PATTERN;

public class TreeCheckOperations {

  // ---------------------------------------------------
  // Definition for a binary tree node.
  // ---------------------------------------------------
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
      left = right = null;
    }
  }

  // ---------------------------------------------------
  // 1. Check if Two Trees are Identical
  // ---------------------------------------------------
  /*
    Problem Statement:
       Determine whether two binary trees are identical (structure and node values are the same).

    Brute Force Idea:
       - Traverse both trees simultaneously (e.g., in preorder) and compare nodes.

    Optimal Approach:
       - Use recursion: if both nodes are null, they are identical; if one is null or values differ, they are not.

    Time Complexity: O(n) where n is the number of nodes in the smaller tree.

    Example:
       Tree A:       1         Tree B:       1
                   /   \                   /   \
                  2     3                 2     3
       They are identical.
  */
  public boolean isIdentical(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;
    return (root1.val == root2.val)
        && isIdentical(root1.left, root2.left)
        && isIdentical(root1.right, root2.right);
  }

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
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isMirror(root.left, root.right);
  }

  private boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
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
  public boolean isValidBST(TreeNode root) {
    return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean validateBST(TreeNode node, long lower, long upper) {
    if (node == null) return true;
    if (node.val <= lower || node.val >= upper) return false;
    return validateBST(node.left, lower, node.val) && validateBST(node.right, node.val, upper);
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
  public boolean isSubtree(TreeNode s, TreeNode t) {
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
  public boolean isBalanced(TreeNode root) {
    return height(root) != -1;
  }

  private int height(TreeNode node) {
    if (node == null) return 0;
    int leftHeight = height(node.left);
    if (leftHeight == -1) return -1;
    int rightHeight = height(node.right);
    if (rightHeight == -1) return -1;
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;
    return Math.max(leftHeight, rightHeight) + 1;
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
  public boolean isComplete(TreeNode root) {
    if (root == null) return true;
    java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
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

  public boolean isFull(TreeNode root) {
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
    TreeNode tree1 = ops.new TreeNode(1);
    tree1.left = ops.new TreeNode(2);
    tree1.right = ops.new TreeNode(3);
    tree1.left.left = ops.new TreeNode(4);
    tree1.left.right = ops.new TreeNode(5);

    // Clone tree1 for identical check.
    TreeNode tree1Clone = ops.new TreeNode(1);
    tree1Clone.left = ops.new TreeNode(2);
    tree1Clone.right = ops.new TreeNode(3);
    tree1Clone.left.left = ops.new TreeNode(4);
    tree1Clone.left.right = ops.new TreeNode(5);

    // 1. Check if Two Trees are Identical
    boolean identical = ops.isIdentical(tree1, tree1Clone);
    System.out.println("Tree1 and its clone are identical: " + identical);

    // 2. Check if Tree is Symmetric
    // For symmetric tree, build:
    //         1
    //        / \
    //       2   2
    //      /     \
    //     3       3
    TreeNode symmetricTree = ops.new TreeNode(1);
    symmetricTree.left = ops.new TreeNode(2);
    symmetricTree.right = ops.new TreeNode(2);
    symmetricTree.left.left = ops.new TreeNode(3);
    symmetricTree.right.right = ops.new TreeNode(3);
    boolean symmetric = ops.isSymmetric(symmetricTree);
    System.out.println("The tree is symmetric: " + symmetric);

    // 3. Validate Binary Search Tree (BST)
    // For BST, build:
    //         5
    //        / \
    //       3   7
    //      / \   \
    //     2   4   8
    TreeNode bst = ops.new TreeNode(5);
    bst.left = ops.new TreeNode(3);
    bst.right = ops.new TreeNode(7);
    bst.left.left = ops.new TreeNode(2);
    bst.left.right = ops.new TreeNode(4);
    bst.right.right = ops.new TreeNode(8);
    boolean validBST = ops.isValidBST(bst);
    System.out.println("The BST is valid: " + validBST);

    // 4. Subtree of Another Tree
    // Check if subtree t is a subtree of s.
    // Let s = bst (above) and t be:
    //       3
    //      / \
    //     2   4
    TreeNode t = ops.new TreeNode(3);
    t.left = ops.new TreeNode(2);
    t.right = ops.new TreeNode(4);
    boolean isSub = ops.isSubtree(bst, t);
    System.out.println("t is a subtree of bst: " + isSub);

    // 5. Check if Tree is Balanced
    boolean balanced = ops.isBalanced(tree1);
    System.out.println("Tree1 is balanced: " + balanced);

    // 6. Check if Tree is Complete or Full
    // Complete Tree example:
    //        1
    //       / \
    //      2   3
    //     / \  /
    //    4  5 6
    TreeNode completeTree = ops.new TreeNode(1);
    completeTree.left = ops.new TreeNode(2);
    completeTree.right = ops.new TreeNode(3);
    completeTree.left.left = ops.new TreeNode(4);
    completeTree.left.right = ops.new TreeNode(5);
    completeTree.right.left = ops.new TreeNode(6);
    boolean complete = ops.isComplete(completeTree);
    System.out.println("The tree is complete: " + complete);

    // Full Tree example:
    //        1
    //       / \
    //      2   3
    //     / \ / \
    //    4  5 6  7
    TreeNode fullTree = ops.new TreeNode(1);
    fullTree.left = ops.new TreeNode(2);
    fullTree.right = ops.new TreeNode(3);
    fullTree.left.left = ops.new TreeNode(4);
    fullTree.left.right = ops.new TreeNode(5);
    fullTree.right.left = ops.new TreeNode(6);
    fullTree.right.right = ops.new TreeNode(7);
    boolean full = ops.isFull(fullTree);
    System.out.println("The tree is full: " + full);
  }
}
