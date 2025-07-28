package StandardProblemDSA.II_LINKEDLIST.iii_RECURSIVE_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;
import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.reverseRecursive;

public class RecursiveReverseLL {
  /* Problem: Reverse a Linked List Recursively
     ------------------------------------------
     Problem Statement:
     Given the head of a singly linked list, reverse the list using recursion.

     Approach:
     1. **Base Case**:
        - If the list is empty (`head == null`) or has only one node (`head.next == null`),
          return the head as it is already reversed.
     2. **Recursive Step**:
        - Reverse the rest of the list starting from `head.next`.
        - Set `head.next.next = head` to reverse the link.
        - Set `head.next = null` to avoid cycles.
     3. **Return**:
        - Return the new head (tail of the original list).

     Example Walkthrough:
        Original: 1 -> 2 -> 3 -> 4 -> null
        Recursive calls reverse the list step by step until:
        Final: 4 -> 3 -> 2 -> 1 -> null

     Time Complexity: O(n), where n is the number of nodes.
     Space Complexity: O(n), recursion stack depth.

     Patterns: Recursion, Linked List Reversal.

     Edge Cases:
     - Empty list (`head == null`).
     - Single node list (no change).

     Follow-up:
     - Implement an **iterative** approach with three pointers (prev, curr, next) to reduce recursion stack usage.

     Related LeetCode Problem:
     - 206. Reverse Linked List
  */

  public static void main(String[] args) {
    // Example List: 1 -> 2 -> 3 -> 4 -> null
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    System.out.println("Original List:");
    printList(head);

    head = reverseRecursive(head);

    System.out.println("Reversed List:");
    printList(head);
  }
}
