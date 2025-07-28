package StandardProblemDSA.VIII_TREE.IV_MODIFICATION_TRANSAFORMATION_PATTERNS;

import StandardProblemDSA.VIII_TREE.TreeNode;

public class BinaryToDoublyLL {

    static TreeNode prev = null; // Global pointer for DLL conversion

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
}
