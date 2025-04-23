package StandardProblemDSA.II_LINKEDLIST.xiv_CONVERSION_PATTERNS;

public class ConversionOperations {

  // ---------------------------------------------------
  // Node and Tree Definitions
  // ---------------------------------------------------

  // Definition for singly-linked list node.
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  // Definition for a binary tree node.
  class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
      val = x;
      left = right = null;
    }
  }

  // Definition for a multilevel linked list node.
  // Each node may have a child pointer to another list.
  class MultiLevelNode {
    int val;
    MultiLevelNode next, child;

    MultiLevelNode(int x) {
      val = x;
      next = null;
      child = null;
    }
  }

  // ---------------------------------------------------
  // 1. Convert Linked List to Binary Tree
  // (Assuming the linked list is sorted and we want a balanced BST)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Convert a sorted linked list into a height-balanced binary search tree.

    Brute Force Approach:
       - Convert the list to an array and then build the BST using array indices.
       - Time: O(n) but uses extra space O(n).

    Optimal Approach:
       - Count nodes and perform an in-order traversal conversion using a global pointer.
       - Time Complexity: O(n), Space Complexity: O(log n) due to recursion.

    Example:
       Input: 1 -> 2 -> 3 -> 4 -> 5
       Output (BST Inorder): 1, 2, 3, 4, 5  (balanced BST with 3 as root)
  */
  private ListNode globalListHead; // Used in conversion

  public TreeNode sortedListToBST(ListNode head) {
    int n = countNodes(head);
    globalListHead = head;
    return sortedListToBSTRec(n);
  }

  private int countNodes(ListNode head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }

  private TreeNode sortedListToBSTRec(int n) {
    if (n <= 0) return null;
    // Recursively build left subtree
    TreeNode left = sortedListToBSTRec(n / 2);
    // The current node becomes root
    TreeNode root = new TreeNode(globalListHead.val);
    root.left = left;
    globalListHead = globalListHead.next;
    // Build right subtree with remaining nodes
    root.right = sortedListToBSTRec(n - n / 2 - 1);
    return root;
  }

  // ---------------------------------------------------
  // 2. Convert Binary Tree to Linked List
  // (Creating a singly-linked list using in-order traversal)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Convert a binary tree to a singly-linked list containing the in-order sequence of nodes.

    Brute Force Approach:
       - Perform in-order traversal and store values in an array, then build the list.

    Optimal Approach:
       - Use recursion to traverse the tree in-order and create nodes for the list on the fly.
       - Time Complexity: O(n)

    Example:
       Input Tree:
                2
               / \
              1   3
       Output Linked List: 1 -> 2 -> 3
  */
  // We'll create a new list while traversing.
  public ListNode treeToLinkedList(TreeNode root) {
    // Dummy head for ease of building list
    ListNode dummy = new ListNode(0);
    treeToListHelper(root, dummy);
    return dummy.next;
  }

  // Use a tail pointer to maintain the end of the list.
  private ListNode treeListTail = null;

  private void treeToListHelper(TreeNode root, ListNode dummy) {
    if (root == null) return;
    treeToListHelper(root.left, dummy);
    ListNode newNode = new ListNode(root.val);
    if (treeListTail == null) {
      dummy.next = newNode;
      treeListTail = newNode;
    } else {
      treeListTail.next = newNode;
      treeListTail = newNode;
    }
    treeToListHelper(root.right, dummy);
  }

  // ---------------------------------------------------
  // 3. Convert Array to Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Convert an integer array into a singly-linked list.

    Brute Force/Optimal Approach:
       - Iterate through the array, create nodes, and link them sequentially.
       - Time Complexity: O(n)

    Example:
       Input: [1, 2, 3, 4]
       Output: 1 -> 2 -> 3 -> 4
  */
  public ListNode arrayToLinkedList(int[] arr) {
    if (arr == null || arr.length == 0) return null;
    ListNode head = new ListNode(arr[0]);
    ListNode current = head;
    for (int i = 1; i < arr.length; i++) {
      current.next = new ListNode(arr[i]);
      current = current.next;
    }
    return head;
  }

  // ---------------------------------------------------
  // 4. Convert Linked List to Array
  // ---------------------------------------------------
  /*
    Problem Statement:
       Convert a singly-linked list into an integer array.

    Brute Force/Optimal Approach:
       - Traverse the linked list to count nodes, then traverse again to fill an array.
       - Time Complexity: O(n)

    Example:
       Input: 1 -> 2 -> 3
       Output: [1, 2, 3]
  */
  public int[] linkedListToArray(ListNode head) {
    int count = 0;
    ListNode current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    int[] arr = new int[count];
    current = head;
    int index = 0;
    while (current != null) {
      arr[index++] = current.val;
      current = current.next;
    }
    return arr;
  }

  // ---------------------------------------------------
  // 5. Convert Multilevel List to Flattened List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a multilevel linked list (each node may have a child pointer),
       flatten it into a single-level linked list.

    Brute Force Approach:
       - Use recursion to traverse each node and merge child lists.

    Optimal Approach:
       - Recursively flatten the child list and splice it into the main list.
       - Time Complexity: O(n)

    Example:
       Multilevel List:
         1 -> 2 -> 3
              |
              4 -> 5
       Output: 1 -> 2 -> 4 -> 5 -> 3
  */
  public MultiLevelNode flattenMultiLevelList(MultiLevelNode head) {
    if (head == null) return head;
    MultiLevelNode curr = head;
    while (curr != null) {
      if (curr.child != null) {
        MultiLevelNode next = curr.next;
        MultiLevelNode childHead = flattenMultiLevelList(curr.child);
        curr.next = childHead;
        curr.child = null;
        // Find the tail of the flattened child list.
        MultiLevelNode tail = childHead;
        while (tail.next != null) {
          tail = tail.next;
        }
        tail.next = next;
      }
      curr = curr.next;
    }
    return head;
  }

  // ---------------------------------------------------
  // Utility Methods for Demonstration
  // ---------------------------------------------------

  // Print a singly-linked list.
  public void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      if (curr.next != null) System.out.print(" -> ");
      curr = curr.next;
    }
    System.out.println();
  }

  // Print inorder traversal of a binary tree.
  public void inorderPrint(TreeNode root) {
    if (root == null) return;
    inorderPrint(root.left);
    System.out.print(root.val + " ");
    inorderPrint(root.right);
  }

  // Print a flattened multilevel linked list.
  public void printMultiLevelList(MultiLevelNode head) {
    MultiLevelNode curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      if (curr.next != null) System.out.print(" -> ");
      curr = curr.next;
    }
    System.out.println();
  }

  // ---------------------------------------------------
  // Main Method for Demonstration
  // ---------------------------------------------------
  public static void main(String[] args) {
    ConversionOperations ops = new ConversionOperations();

    // 3. Array to Linked List
    int[] arr = {1, 2, 3, 4, 5};
    ListNode listFromArray = ops.arrayToLinkedList(arr);
    System.out.println("Linked List from Array:");
    ops.printList(listFromArray);

    // 4. Linked List to Array
    int[] convertedArr = ops.linkedListToArray(listFromArray);
    System.out.print("Array from Linked List: ");
    for (int num : convertedArr) {
      System.out.print(num + " ");
    }
    System.out.println();

    // 1. Linked List to Binary Tree (sorted list to BST)
    // Input: 1 -> 2 -> 3 -> 4 -> 5 (already sorted)
    TreeNode bstRoot = ops.sortedListToBST(listFromArray);
    System.out.println("BST from Sorted Linked List (Inorder Traversal):");
    ops.inorderPrint(bstRoot);
    System.out.println();

    // 2. Binary Tree to Linked List (inorder order)
    ListNode listFromTree = ops.treeToLinkedList(bstRoot);
    System.out.println("Linked List from Binary Tree (Inorder):");
    ops.printList(listFromTree);

    // 5. Flatten Multilevel List
    // Build a multilevel list: 1 -> 2 -> 3, where 2 has child 4 -> 5.
    MultiLevelNode m1 = ops.new MultiLevelNode(1);
    MultiLevelNode m2 = ops.new MultiLevelNode(2);
    MultiLevelNode m3 = ops.new MultiLevelNode(3);
    m1.next = m2;
    m2.next = m3;
    MultiLevelNode m4 = ops.new MultiLevelNode(4);
    MultiLevelNode m5 = ops.new MultiLevelNode(5);
    m4.next = m5;
    m2.child = m4;
    MultiLevelNode flatHead = ops.flattenMultiLevelList(m1);
    System.out.println("Flattened Multilevel List:");
    ops.printMultiLevelList(flatHead);
  }
}
