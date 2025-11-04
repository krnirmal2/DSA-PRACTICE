package StandardProblemDSA.VIII_TREE.BST;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.VIII_TREE.TreeNode;
import StandardProblemDSA.VIII_TREE.TreeUtility;
import java.util.ArrayList;
import java.util.List;

public class BSTCostructionArrayAndLinkedList {

  // ---------------------------------------------------
  // 1. Preorder Traversal of Binary Tree
  // ---------------------------------------------------
  /*
    Problem Statement:
       Traverse a binary tree in preorder (root, left, right) and return the list of values.

    Brute Force Approach:
       - Use recursion to visit the root then recursively visit left and right subtrees.
       - This simple recursive method does the job in O(n) time.

    Optimal Approach:
       - Use recursion (or iteration with a stack) to generate a preorder list.

    Time Complexity: O(n)

    Example:
       For a BST:
                  4
                 / \
                2   6
               / \ / \
              1  3 5  7
       Preorder Output: [4, 2, 1, 3, 6, 5, 7]
  */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeUtility.preorderHelper(root, result);
    return result;
  }

  // ---------------------------------------------------
  // 3. Construct BST from Sorted Array
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a sorted (ascending) array, construct a height-balanced BST.

    Brute Force Approach:
       - Insert each element into the BST one by one.
       - This may not guarantee balance.

    Optimal Approach:
       - Use a recursive approach by selecting the middle element as root, then
         recursively construct left and right subtrees.

    Time Complexity: O(n)

    Example:
       Input: [1, 2, 3, 4, 5, 6, 7]
       Output BST (Preorder): [4, 2, 1, 3, 6, 5, 7]
  */
  public TreeNode sortedArrayToBST(int[] arr) {
    return sortedArrayToBSTHelper(arr, 0, arr.length - 1);
  }

  private TreeNode sortedArrayToBSTHelper(int[] arr, int left, int right) {
    if (left > right) return null;
    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(arr[mid]);
    root.left = sortedArrayToBSTHelper(arr, left, mid - 1);
    root.right = sortedArrayToBSTHelper(arr, mid + 1, right);
    return root;
  }

  // ---------------------------------------------------
  // 4. Construct BST from Sorted Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a sorted (ascending) singly-linked list, construct a height-balanced BST.

    Brute Force Approach:
       - Convert the list to an array and then use the array-based method.

    Optimal Approach:
       - Use the slow-fast pointer technique to find the middle element as root,
         recursively constructing left and right subtrees.

    Time Complexity: O(n log n) if using slow-fast pointer at each recursion;
       It can be optimized to O(n) using an in-order simulation.

    Example:
       Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
       Output BST (Preorder): [4, 2, 1, 3, 6, 5, 7]
  */
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    return sortedListToBSTHelper(head, null);
  }

  // Helper function to build BST from list segment [head, tail)
  private TreeNode sortedListToBSTHelper(ListNode head, ListNode tail) {
    if (head == tail) return null;
    ListNode slow = head, fast = head;
    // Find the middle element using slow and fast pointers.
    while (fast != tail && fast.next != tail) {
      slow = slow.next;
      fast = fast.next.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBSTHelper(head, slow);
    root.right = sortedListToBSTHelper(slow.next, tail);
    return root;
  }

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {
    BSTCostructionArrayAndLinkedList ops = new BSTCostructionArrayAndLinkedList();

    // 1. Construct BST from Sorted Array
    int[] sortedArr = {1, 2, 3, 4, 5, 6, 7};
    TreeNode bstFromArr = ops.sortedArrayToBST(sortedArr);
    System.out.println("Preorder traversal of BST constructed from sorted array:");
    System.out.println(ops.preorderTraversal(bstFromArr)); // Expected: [4, 2, 1, 3, 6, 5, 7]

    System.out.println("Level order traversal of BST constructed from sorted array:");
    //    System.out.println(levelOrderTraversal(bstFromArr)); // Expected: [4, 2, 6, 1, 3, 5, 7]

    // 2. Construct BST from Sorted Linked List
    // Build sorted linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
    ListNode listHead = new ListNode(1);
    listHead.next = new ListNode(2);
    listHead.next.next = new ListNode(3);
    listHead.next.next.next = new ListNode(4);
    listHead.next.next.next.next = new ListNode(5);
    listHead.next.next.next.next.next = new ListNode(6);
    listHead.next.next.next.next.next.next = new ListNode(7);

    TreeNode bstFromList = ops.sortedListToBST(listHead);
    System.out.println("Preorder traversal of BST constructed from sorted linked list:");
    System.out.println(ops.preorderTraversal(bstFromList)); // Expected: [4, 2, 1, 3, 6, 5, 7]

    System.out.println("Level order traversal of BST constructed from sorted linked list:");
    //    System.out.println(ops.levelOrderTraversal(bstFromList)); // Expected: [4, 2, 6, 1, 3, 5,
    // 7]
  }
}
