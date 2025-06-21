package StandardProblemDSA.VIII_TREE.IV_MODIFICATION_TRANSAFORMATION_PATTERNS;

import static StandardProblemDSA.VIII_TREE.BST.TrimOrPruningBST.trimBST;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

public class ModificationAndTransFormation {
  // ---------------------------------------------------
  // 1. Flatten Tree to Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Flatten a binary tree into a linked list "in-place." The resulting list should use
       the right pointers as next pointers and left pointers should be null, following pre-order.

    Brute Force Approach:
       - Do a pre-order traversal, store nodes in an array, then relink.
       - Time: O(n) but requires extra O(n) space.

    Optimal Approach:
       - Recursively flatten left and right subtrees.
       - Then, attach the flattened left subtree between the root and the flattened right subtree.
       - Time Complexity: O(n)

    Example:
       Input:
                 1
                / \
               2   5
              / \   \
             3   4   6
       Output (right chain): 1 -> 2 -> 3 -> 4 -> 5 -> 6
  */
  public static void flatten(TreeNode root) {
    if (root == null) return;
    flatten(root.left);
    flatten(root.right);
    TreeNode tempRight = root.right;
    root.right = root.left;
    root.left = null;
    TreeNode curr = root;
    while (curr.right != null) {
      curr = curr.right;
    }
    curr.right = tempRight;
  }

  // ---------------------------------------------------
  // 2. Mirror/Invert Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Invert (or mirror) a binary tree by swapping left and right children of every node.

    Brute Force Approach:
       - Recursively swap children for every node.
       - Time Complexity: O(n)

    Optimal Approach:
       - Recursively swap left and right pointers.

    Example:
       Input:
                 4
                / \
               2   7
              / \ / \
             1  3 6  9
       Output (Mirrored):
                 4
                / \
               7   2
              / \ / \
             9  6 3  1
  */
  public static TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode tmp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(tmp);
    return root;
  }

  // ---------------------------------------------------
  // 4. Convert Binary Tree to Doubly Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Convert a binary tree into a doubly linked list (DLL) in-place. The left pointer
       is used as the previous pointer and the right pointer as the next pointer. The nodes
       should appear in the DLL in in-order sequence.

    Brute Force Approach:
       - Do an in-order traversal, store nodes in an array, then re-link.
       - Time: O(n) but uses extra O(n) space.

    Optimal Approach:
       - Recursively convert left subtree, then fix pointers at root, and then convert right subtree.
       - Maintain a global "previous" pointer to link nodes.
       - Time Complexity: O(n)

    Example:
       Input:
                 10
                /  \
               5    20
              / \     \
             3   7     30
       Output DLL (in-order): 3 <-> 5 <-> 7 <-> 10 <-> 20 <-> 30
  */
  static TreeNode prev = null; // Global pointer for DLL conversion

  public static TreeNode convertToDoublyLinkedList(TreeNode root) {
    if (root == null) return null;
    // Convert left subtree
    TreeNode head = convertToDoublyLinkedList(root.left);
    // If left subtree is null, then current root is head.
    if (head == null) head = root;
    // Link current root with prev node in DLL
    if (prev != null) {
      prev.right = root;
      root.left = prev;
    }
    prev = root;
    // Convert right subtree
    convertToDoublyLinkedList(root.right);
    return head;
  }

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {
    ModificationAndTransFormation ops = new ModificationAndTransFormation();

    // Build sample binary tree for demonstration:
    //         10
    //        /  \
    //       5    20
    //      / \     \
    //     3   7     30
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(20);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);
    root.right.right = new TreeNode(30);

    // 1. Flatten Tree to Linked List
    System.out.println("Flatten Tree to Linked List (pre-order linked list using right pointers):");
    flatten(root);
    TreeNode curr = root;
    while (curr != null) {
      System.out.print(curr.val + " ");
      curr = curr.right;
    }
    System.out.println("\n");

    // Rebuild tree for further operations.
    root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(20);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);
    root.right.right = new TreeNode(30);

    // 2. Mirror/Invert Binary Tree
    System.out.println("Mirror/Invert Binary Tree (preorder):");
    TreeNode inverted = invertTree(root);
    TreeUtility.printPreorder(inverted);
    System.out.println("\n");

    // 3. Rotate Tree: Perform a right rotation at root (if applicable)
    System.out.println("Right Rotation at Root:");
    // For right rotation, root must have a left child.
    TreeNode rotatedRight = TreeUtility.rotateRight(inverted);
    TreeUtility.printPreorder(rotatedRight);
    System.out.println("\n");

    // 4. Convert Binary Tree to Doubly Linked List
    // Rebuild a simple tree.
    root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(20);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);
    root.right.right = new TreeNode(30);
    System.out.println("Convert Binary Tree to Doubly Linked List (In-Order):");
    // Reset the global pointer 'prev'
    prev = null;
    TreeNode dllHead = convertToDoublyLinkedList(root);
    TreeNode temp = dllHead;
    // Print DLL forward.
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.right;
    }
    System.out.println("\n");

    // 5. Tree Trimming/Pruning (BST trim by range)
    System.out.println("BST Trimming/Pruning: Trim BST to range [5, 20]:");
    // Build BST:
    //         10
    //        /  \
    //       5    20
    //      / \     \
    //     3   7     30
    root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(20);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(7);
    root.right.right = new TreeNode(30);
    TreeNode trimmed = trimBST(root, 5, 20);
    TreeUtility.printPreorder(trimmed);
    System.out.println();
  }
}
