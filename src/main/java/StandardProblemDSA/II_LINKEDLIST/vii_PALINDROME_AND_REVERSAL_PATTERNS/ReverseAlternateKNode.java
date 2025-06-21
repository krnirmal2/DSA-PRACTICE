package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class ReverseAlternateKNode {

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
  public static ListNode reverseAlternateKNodes(ListNode head, int k) {
    if (head == null) return null;

    // Step 1: Reverse first k nodes
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
    // Step 2: Link last of reversed group to the current node
    // Now head becomes the last node in the reversed group.
    // Link it to the next k nodes which remain unchanged.
    if (head != null) {
      head.next = current;
    }

    // Step 3: Skip next k nodes (no reversal)
    count = 0;
    ListNode temp = current;
    while (current != null && count < k - 1) { // move k-1 nodes
      current = current.next;
      count++;
    }

    // Step 4: Recurse for remaining list
    if (current != null) {
      current.next = reverseAlternateKNodes(current.next, k);
    }

    // prev is the new head of the reversed segment.
    return prev;
  }

  public static void main(String[] args) {
    // Build a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    ListNode head = new ListNode(1);
    ListNode current = head;
    for (int i = 2; i <= 9; i++) {
      current.next = new ListNode(i);
      current = current.next;
    }

    // 1. Reverse Every Alternate K Nodes with k = 3
    System.out.println("Original List:");
    printList(head);
    ListNode altReversed = reverseAlternateKNodes(head, 3);
    System.out.println("After Reversing Every Alternate 3 Nodes:");
    printList(altReversed);
    // Expected Output: 3 -> 2 -> 1 -> 4 -> 5 -> 6 -> 9 -> 8 -> 7
  }
}
