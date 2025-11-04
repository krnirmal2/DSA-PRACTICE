package StandardProblemDSA.VIII_TREE.IV_MODIFICATION_TRANSAFORMATION_PATTERNS;

import static StandardProblemDSA.VIII_TREE.BST.TrimOrPruningBST.trimBST;

import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;

public class ModificationAndTransFormation {

  /*
   Problem: Demonstrate binary tree modification and transformation operations.

   Features implemented:
    1. Flatten a binary tree to a linked list (using right pointers, preorder traversal)
    2. Mirror/Invert a binary tree
    3. Rotate a binary tree to the right at the root
    4. Convert a binary tree to a doubly linked list (DLL) using in-order traversal
    5. Trim/Prune a BST to keep values in a given range [low, high]

   Example Tree:
          10
         /  \
        5    20
       / \     \
      3   7     30

   Example Outputs:
    - Flattened tree: 10 5 3 7 20 30
    - Inverted tree (preorder): 10 20 30 5 7 3
    - Right-rotated tree (preorder): 5 3 10 20 30 7
    - Doubly Linked List: 3 5 7 10 20 30
    - Trimmed BST in range [5,20] (preorder): 10 5 7 20

   Pattern:
      - Tree Transformations
      - Recursion & Pointer Manipulation
      - In-order, Pre-order traversal patterns

   Similar LeetCode Problems:
      - 114. Flatten Binary Tree to Linked List
      - 226. Invert Binary Tree
      - 156. Binary Tree Upside Down
      - 426. Convert Binary Search Tree to Sorted Doubly Linked List
      - 669. Trim a Binary Search Tree

   Follow-up Questions:
      - Can you perform flattening and inversion iteratively?
      - How would you handle a skewed tree for DLL conversion?
      - Can you support k-ary trees for flattening and mirroring?
      - How to handle large BST trimming with streaming input?

   Time Complexity: O(n) for each operation, n = number of nodes
   Space Complexity: O(h), h = height of the tree (recursion stack)
  */
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
    FlattenTreeToLinkedList.flatten(root);
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
    TreeNode inverted = MirrorOrInvertedBinaryTree.invertTree(root);
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
    BinaryToDoublyLL.prev = null;
    TreeNode dllHead = BinaryToDoublyLL.convertToDoublyLinkedList(root);
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
