package StandardProblemDSA.VIII_TREE.I_TRAVERSAL_PATTERNS;

/**
 * Java implementation of Boundary Traversal of a binary tree. Boundary Traversal includes: 1. Left
 * boundary (excluding leaf nodes) 2. All leaf nodes (left subtree first, then right subtree) 3.
 * Right boundary (excluding leaf nodes), printed bottom-up
 *
 * <p>Time Complexity: O(N), where N is the number of nodes (each node visited once) Space
 * Complexity: O(H), where H is the tree height (recursion stack)
 */
/*1. Boundary Traversal
Boundary Traversal of a Tree includes

left boundary (nodes on left excluding leaf nodes)
leaves (consist of only the leaf nodes)
right boundary (nodes on right excluding leaf nodes)
Algorithm for Boundary Traversal:

BoundaryTraversal(tree)


 ● If root is not null:
        ○ Print root’s data
         ○ PrintLeftBoundary(root->left) // Print the left boundary nodes
        ○ PrintLeafNodes(root->left) // Print the leaf nodes of left subtree
        ○ PrintLeafNodes(root->right) // Print the leaf nodes of right subtree
        ○ PrintRightBoundary(root->right) // Print the right boundary nodes */
public class BoundaryTraversal {
  static class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
      this.data = data;
      left = right = null;
    }
  }

  // Main function to perform boundary traversal
  public void boundaryTraversal(TreeNode root) {
    if (root == null) return;

    // Print root data
    System.out.print(root.data + " ");

    // Print left boundary excluding leaf nodes
    printLeftBoundary(root.left);

    // Print all leaf nodes
    printLeaves(root.left);
    printLeaves(root.right);

    // Print right boundary excluding leaf nodes (in bottom-up order)
    printRightBoundary(root.right);
  }

  // Print the left boundary in top-down manner, excluding leaves
  private void printLeftBoundary(TreeNode node) {
    if (node == null) return;
    if (node.left != null) {
      // to ensure top-down, print before recursion
      System.out.print(node.data + " ");
      printLeftBoundary(node.left);
    } else if (node.right != null) {
      System.out.print(node.data + " ");
      printLeftBoundary(node.right);
    }
    // Do nothing for leaf node, this way we avoid duplicates in leaves
  }

  // Print all leaf nodes in left-to-right order
  private void printLeaves(TreeNode node) {
    if (node == null) return;
    printLeaves(node.left);
    if (node.left == null && node.right == null) {
      System.out.print(node.data + " ");
    }
    printLeaves(node.right);
  }

  // Print the right boundary in bottom-up manner, excluding leaves
  private void printRightBoundary(TreeNode node) {
    if (node == null) return;
    if (node.right != null) {
      // recursion first for bottom-up
      printRightBoundary(node.right);
      System.out.print(node.data + " ");
    } else if (node.left != null) {
      printRightBoundary(node.left);
      System.out.print(node.data + " ");
    }
    // Do nothing for leaf node
  }

  // Example usage
  public static void main(String[] args) {
    /* Construct the following tree:
              1
             / \
            2   3
           / \   \
          4   5   6
             / \ / \
            7  8 9  10
    */
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(8);
    root.right.right = new TreeNode(6);
    root.right.right.left = new TreeNode(9);
    root.right.right.right = new TreeNode(10);

    BoundaryTraversal bt = new BoundaryTraversal();
    bt.boundaryTraversal(root);
    // Expected output: 1 2 4 7 8 9 10 6 3
  }
}
