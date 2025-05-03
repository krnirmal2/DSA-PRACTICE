package StandardProblemDSA.VIII_TREE;

import java.util.ArrayList;
import java.util.List;

public class TreeUtility {
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      left = null;
      right = null;
    }
  }

  public static class BinaryTree {
    public static TreeNode root;

    public BinaryTree() {
      root = null;
    }

    public static void main(String[] args) {
      BinaryTree tree = new BinaryTree();
      root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      tree.root.left.right = new TreeNode(5);
      tree.root.right.left = new TreeNode(6);
      tree.root.right.right = new TreeNode(7);

      System.out.println("Height of the tree: " + tree.height());
      System.out.println("Height of node with value 5: " + tree.nodeHeight(5));
      System.out.println("Level of node with value 5: " + tree.nodeLevel(5));
      System.out.println("Is value 3 present in the tree? " + tree.search(3));
      System.out.println("Parent of node with value 5: " + tree.findParent(5).val);
      System.out.println("Diameter of the tree: " + tree.diameter());
      System.out.println("Leaf nodes: " + tree.findLeafNodes());
      System.out.println("Siblings of node with value 5: " + tree.findSiblings(5));
      System.out.println("Children of node with value 2: " + tree.findChildren(2));

      System.out.print("Inorder Traversal: ");
      tree.inorderTraversal();

      System.out.print("Preorder Traversal: ");
      tree.preorderTraversal();

      System.out.print("Postorder Traversal: ");
      tree.postorderTraversal();
    }

    // Method to find the height of the tree
    public static int height() {
      return height(root);
    }

    public static int height(TreeNode node) {
      // if node is null then return 0
      // Else go for left and right and find the maximum amount
      // them with add extra 1 to
      if (node == null) {
        return 0;
      } else {
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
      }
    }

    // Method to find the height of a specific node
    public static int nodeHeight(int val) {
      // find the specific noden
      // set the height =1 and then use utility to
      // if node value is matched then return height
      // first go for left with height+1; if level set the
      // second if not getting any thing from left go for  right and return
      // the value level
      return nodeHeight(root, val, 1);
    }

    public static int nodeHeight(TreeNode node, int val, int height) {
      if (node == null) return 0;
      if (node.val == val) return height;

      int level = nodeHeight(node.left, val, height + 1);
      if (level != 0) return level;

      level = nodeHeight(node.right, val, height + 1);
      return level;
    }

    // Method to find the level of a given node in the tree
    public static int nodeLevel(int val) {
      // for level of a node just find the height of node and just minus 1 to it

      return nodeHeight(val) - 1;
    }

    // Method to search for a node in the tree
    public static boolean search(int val) {
      return search(root, val);
    }

    public static boolean search(TreeNode node, int val) {
      if (node == null) return false;
      if (node.val == val) return true;

      return search(node.left, val) || search(node.right, val);
    }

    // Method to find the parent of a node
    public static TreeNode findParent(int val) {
      return findParent(root, val);
    }

    public static TreeNode findParent(TreeNode node, int val) {
      if (node == null
          || (node.left != null && node.left.val == val)
          || (node.right != null && node.right.val == val)) return node;

      TreeNode parent = findParent(node.left, val);
      if (parent == null) parent = findParent(node.right, val);

      return parent;
    }

    // Method to find the diameter of the tree
    public static int diameter() {
      return diameter(root);
    }

    public static int diameter(TreeNode node) {
      if (node == null) return 0;
      // find the height of the left and right

      int leftHeight = height(node.left);
      int rightHeight = height(node.right);

      // then find the left and right diameter of the tree
      int leftDiameter = diameter(node.left);
      int rightDiameter = diameter(node.right);
      // return the maximum of the ( height of tree , maximum of left and rightDiameter)
      return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    // Method to find all leaf nodes
    public static List<Integer> findLeafNodes() {
      List<Integer> leafNodes = new ArrayList<>();
      findLeafNodes(root, leafNodes);
      return leafNodes;
    }

    public static void findLeafNodes(TreeNode node, List<Integer> leafNodes) {
      if (node == null) return;

      if (node.left == null && node.right == null) leafNodes.add(node.val);

      findLeafNodes(node.left, leafNodes);
      findLeafNodes(node.right, leafNodes);
    }

    // Method to find siblings of a node
    public static List<Integer> findSiblings(int val) {
      List<Integer> siblings = new ArrayList<>();
      TreeNode parent = findParent(val);
      if (parent != null) {
        if (parent.left != null && parent.left.val != val) siblings.add(parent.left.val);
        if (parent.right != null && parent.right.val != val) siblings.add(parent.right.val);
      }
      return siblings;
    }

    // Method to find children of a node
    public static List<Integer> findChildren(int val) {
      List<Integer> children = new ArrayList<>();
      TreeNode node = findNode(root, val);
      if (node != null) {
        if (node.left != null) children.add(node.left.val);
        if (node.right != null) children.add(node.right.val);
      }
      return children;
    }

    public static TreeNode findNode(TreeNode node, int val) {
      if (node == null) return null;
      if (node.val == val) return node;
      TreeNode left = findNode(node.left, val);
      if (left != null) return left;
      return findNode(node.right, val);
    }

    // Tree Traversals: Inorder, Preorder and Postorder
    public static void inorderTraversal() {
      inorderTraversal(root);
      System.out.println();
    }

    public static void inorderTraversal(TreeNode node) {
      if (node != null) {
        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
      }
    }

    public static void preorderTraversal() {
      preorderTraversal(root);
      System.out.println();
    }

    public static void preorderTraversal(TreeNode node) {
      if (node != null) {
        System.out.print(node.val + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
      }
    }

    public static void postorderTraversal() {
      postorderTraversal(root);
      System.out.println();
    }

    public static void postorderTraversal(TreeNode node) {
      if (node != null) {
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.val + " ");
      }
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
  public static boolean isIdentical(
      StandardProblemDSA.VIII_TREE.TreeNode root1, StandardProblemDSA.VIII_TREE.TreeNode root2) {
    if (root1 == null && root2 == null) return true;
    if (root1 == null || root2 == null) return false;
    return (root1.val == root2.val)
        && isIdentical(root1.left, root2.left)
        && isIdentical(root1.right, root2.right);
  }
}
