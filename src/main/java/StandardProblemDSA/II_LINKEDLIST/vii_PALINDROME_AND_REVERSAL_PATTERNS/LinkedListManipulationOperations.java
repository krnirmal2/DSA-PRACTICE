package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

public class LinkedListManipulationOperations {

  // ---------------------------------------------------
  // Definition for a singly-linked list node.
  // ---------------------------------------------------
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  // ---------------------------------------------------
  // 1. Reverse Every Alternate K Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a linked list and an integer k, reverse every alternate k nodes of the list.
       That is, reverse the first k nodes, leave the next k nodes unchanged, then reverse the following k nodes, and so on.

    Brute Force Idea:
       - Convert the list to an array, manipulate segments, and rebuild the list.
       - Time Complexity: O(n) but uses extra space.

    Optimal Approach:
       - Use recursion (or iteration) to reverse the first k nodes, then skip the next k nodes, and repeat.
       - Time Complexity: O(n) and O(1) extra space (ignoring recursion stack).

    Example:
       Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9, k = 3
       Process:
         Reverse first 3: 3 -> 2 -> 1,
         Skip next 3: 4 -> 5 -> 6 remain,
         Reverse last 3: 9 -> 8 -> 7.
       Output: 3 -> 2 -> 1 -> 4 -> 5 -> 6 -> 9 -> 8 -> 7
  */
  public ListNode reverseAlternateKNodes(ListNode head, int k) {
    if (head == null) return null;

    // Reverse first k nodes.
    ListNode current = head;
    ListNode prev = null;
    ListNode next = null;
    int count = 0;
    while (current != null && count < k) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }

    // Now head becomes the last node in the reversed group.
    // Link it to the next k nodes which remain unchanged.
    if (head != null) {
      head.next = current;
    }

    // Skip next k nodes.
    count = 0;
    ListNode temp = current;
    while (current != null && count < k - 1) { // move k-1 nodes
      current = current.next;
      count++;
    }

    // Recurse for remaining list.
    if (current != null) {
      current.next = reverseAlternateKNodes(current.next, k);
    }

    // prev is the new head of the reversed segment.
    return prev;
  }

  // ---------------------------------------------------
  // 2. Reverse Linked List Between Two Indices
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given the head of a linked list and two integers m and n (1-indexed), reverse the nodes from position m to n.

    Brute Force Idea:
       - Convert the list to an array, reverse the portion between m and n, and rebuild the list.

    Optimal Approach:
       - Traverse the list to the (m-1)th node, reverse the next (n-m+1) nodes, then reconnect the reversed sublist back.
       - Time Complexity: O(n)

    Example:
       Input: 1 -> 2 -> 3 -> 4 -> 5, m = 2, n = 4
       Output: 1 -> 4 -> 3 -> 2 -> 5
  */
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null || m == n) return head;

    // Create a dummy node to handle edge cases (e.g., m = 1).
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    // Move prev to the node just before reversal start (position m-1).
    for (int i = 1; i < m; i++) {
      prev = prev.next;
    }

    // Reverse sublist from m to n.
    ListNode reverseStart = prev.next;
    ListNode current = reverseStart;
    ListNode next = null;
    for (int i = m; i <= n; i++) {
      next = current.next;
      current.next = prev.next;
      prev.next = current;
      current = next;
    }

    // Connect the end of reversed part to the remainder of the list.
    reverseStart.next = current;
    return dummy.next;
  }

  // ---------------------------------------------------
  // 3. Rotate Linked List Left/Right by K
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given the head of a linked list and an integer k, rotate the list to the left or right by k positions.

    Brute Force Idea:
       - Repeatedly remove one node from the beginning (or end) and append it to the other side.
       - Time Complexity: O(n*k)

    Optimal Approach:
       - Compute the length of the list.
       - Connect the list into a circle.
       - Compute the effective rotations needed (k modulo length).
       - Break the circle to form the new list.
       - For left rotation, move (k % length) nodes; for right rotation, move (length - (k % length)) nodes.
       - Time Complexity: O(n)

    Example:
       Left Rotation:
         Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2
         Output: 3 -> 4 -> 5 -> 1 -> 2
       Right Rotation:
         Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2
         Output: 4 -> 5 -> 1 -> 2 -> 3
  */
  public ListNode rotateLeft(ListNode head, int k) {
    if (head == null || k == 0) return head;

    // Compute length and get tail.
    ListNode current = head;
    int length = 1;
    while (current.next != null) {
      current = current.next;
      length++;
    }
    // Connect tail to head to form a circle.
    current.next = head;

    // Effective rotations.
    k = k % length;
    int stepsToNewHead = k; // for left rotation

    // Find the new tail: (stepsToNewHead - 1) steps from head.
    ListNode newTail = head;
    for (int i = 1; i < stepsToNewHead; i++) {
      newTail = newTail.next;
    }

    // New head is next of newTail.
    ListNode newHead = newTail.next;
    // Break the circle.
    newTail.next = null;
    return newHead;
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) return head;

    // Compute length and get tail.
    ListNode current = head;
    int length = 1;
    while (current.next != null) {
      current = current.next;
      length++;
    }
    // Connect tail to head.
    current.next = head;

    // Effective rotations.
    k = k % length;
    // For right rotation, new head is at position length - k.
    int stepsToNewHead = length - k;

    ListNode newTail = head;
    for (int i = 1; i < stepsToNewHead; i++) {
      newTail = newTail.next;
    }
    ListNode newHead = newTail.next;
    newTail.next = null;
    return newHead;
  }

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {
    LinkedListManipulationOperations ops = new LinkedListManipulationOperations();

    // Build a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    ListNode head = ops.new ListNode(1);
    ListNode current = head;
    for (int i = 2; i <= 9; i++) {
      current.next = ops.new ListNode(i);
      current = current.next;
    }

    // 1. Reverse Every Alternate K Nodes with k = 3
    System.out.println("Original List:");
    printList(head);
    ListNode altReversed = ops.reverseAlternateKNodes(head, 3);
    System.out.println("After Reversing Every Alternate 3 Nodes:");
    printList(altReversed);
    // Expected Output: 3 -> 2 -> 1 -> 4 -> 5 -> 6 -> 9 -> 8 -> 7

    // 2. Reverse Linked List Between Two Indices (m = 2, n = 6)
    // Rebuild list for clarity.
    head = ops.new ListNode(1);
    current = head;
    for (int i = 2; i <= 9; i++) {
      current.next = ops.new ListNode(i);
      current = current.next;
    }
    System.out.println("Original List:");
    printList(head);
    ListNode reversedBetween = ops.reverseBetween(head, 2, 6);
    System.out.println("After Reversing Between Positions 2 and 6:");
    printList(reversedBetween);
    // Expected Output: 1 -> 6 -> 5 -> 4 -> 3 -> 2 -> 7 -> 8 -> 9

    // 3. Rotate Linked List Left by k = 2
    // Rebuild list.
    head = ops.new ListNode(1);
    current = head;
    for (int i = 2; i <= 5; i++) {
      current.next = ops.new ListNode(i);
      current = current.next;
    }
    System.out.println("Original List:");
    printList(head);
    ListNode rotatedLeft = ops.rotateLeft(head, 2);
    System.out.println("After Left Rotation by 2:");
    printList(rotatedLeft);
    // Expected Output (Left Rotate): 3 -> 4 -> 5 -> 1 -> 2

    // 4. Rotate Linked List Right by k = 2
    // Rebuild list.
    head = ops.new ListNode(1);
    current = head;
    for (int i = 2; i <= 5; i++) {
      current.next = ops.new ListNode(i);
      current = current.next;
    }
    System.out.println("Original List:");
    printList(head);
    ListNode rotatedRight = ops.rotateRight(head, 2);
    System.out.println("After Right Rotation by 2:");
    printList(rotatedRight);
    // Expected Output (Right Rotate): 4 -> 5 -> 1 -> 2 -> 3
  }

  // Utility method to print linked list.
  public static void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      if (curr.next != null) System.out.print(" -> ");
      curr = curr.next;
    }
    System.out.println();
  }
}
