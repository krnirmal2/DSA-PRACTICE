package StandardProblemDSA.II_LINKEDLIST.iii_RECURSIVE_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.MultiLevelNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

import static StandardProblemDSA.II_LINKEDLIST.MultiLevelNode.printMultiLevelList;
import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

public class RecursiveLinkedListOperations {
  /* Problem 1: Merge Two Sorted Lists
     --------------------------------
     Problem Statement:
     Given two sorted singly linked lists l1 and l2, merge them into one sorted list and return its head.

     Approach:
     - Base cases: if l1 is null, return l2; if l2 is null, return l1.
     - Compare values at l1 and l2.
     - Recursively link the smaller node to the merged list.
     - Continue until one of the lists is fully traversed.

     Time Complexity: O(m + n), where m and n are lengths of l1 and l2.
     Space Complexity: O(m + n) due to recursion stack.

     Pattern: Linked List Merge, Divide & Conquer.

     Related LeetCode Problem: 21. Merge Two Sorted Lists

     ---------------------------------------------------
     Problem 2: Flatten a Multilevel Linked List
     --------------------------------------------
     Problem Statement:
     Given a multilevel linked list where each node may have:
     - `next` pointer (to the next node in the same level),
     - `child` pointer (to a sub-linked list),
     flatten it so that all nodes appear in a single-level list.

     Approach:
     - Traverse the list iteratively using `current`.
     - If `current.child` exists:
         1. Save `next` pointer.
         2. Recursively flatten the `child` list.
         3. Attach the flattened `child` list to `current.next`.
         4. Set `child = null`.
         5. Traverse to the end of the flattened child list.
         6. Re-attach saved `next` pointer (flattened).
     - Else, move `current` to `current.next`.

     Time Complexity: O(N), where N is the total number of nodes.
     Space Complexity: O(H), where H is the maximum depth of recursion (list nesting).

     Pattern: Recursion, Linked List Modification.

     Follow-Up:
     - Can this be solved iteratively using a stack to avoid recursion depth issues?
     - How to maintain O(1) extra space?

     Related LeetCode Problems:
     - 21. Merge Two Sorted Lists
     - 430. Flatten a Multilevel Doubly Linked List
  */

  // 1. Recursive Merge of Two Sorted Lists
  // Merges two sorted singly-linked lists and returns the head of the merged list.
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // Base cases: if either list is null, return the other.
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    // Recursively merge based on the node values.
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  // 3. Flatten a Multilevel Linked List Recursively
  // Given a multilevel linked list where nodes may have a 'child' pointer,
  // flatten the list so that all nodes appear in a single-level linked list.
  // The method returns the head of the flattened list.
  public static MultiLevelNode flattenMultiLevelList(MultiLevelNode head) {
    if (head == null) return head;

    // Pointer to traverse the list.
    MultiLevelNode current = head;

    // Process all nodes.
    while (current != null) {
      if (current.child != null) {
        // Save the next pointer.
        MultiLevelNode next = current.next;
        // Recursively flatten the child list.
        MultiLevelNode childFlat = flattenMultiLevelList(current.child);
        // Attach the flattened child list.
        current.next = childFlat;
        // Clear the child pointer.
        current.child = null;

        // Traverse to the end of the flattened child list.
        while (current.next != null) {
          current = current.next;
        }

        // Re-attach the saved next pointer.
        current.next = flattenMultiLevelList(next);
      } else {
        // Move to the next node if no child exists.
        current = current.next;
      }
    }
    return head;
  }

  // -------------------------------
  // Utility Methods for Demonstration
  // -------------------------------

  // -------------------------------
  // Main method for demonstration
  // -------------------------------
  public static void main(String[] args) {
    RecursiveLinkedListOperations ops = new RecursiveLinkedListOperations();

    // Demonstrate Recursive Merge of Two Sorted Lists.
    // Build first sorted list: 1 -> 3 -> 5
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(3);
    l1.next.next = new ListNode(5);

    // Build second sorted list: 2 -> 4 -> 6
    ListNode l2 = new ListNode(2);
    l2.next = new ListNode(4);
    l2.next.next = new ListNode(6);

    ListNode mergedHead = mergeTwoLists(l1, l2);
    System.out.println("Merged Sorted List:");
    printList(mergedHead); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6

    // Demonstrate Recursive Traversal: Print in Reverse Order.
    System.out.println("Print Merged List in Reverse Order:");
    Utility_linkedList.printReverse(mergedHead); // Expected reverse order: 6 5 4 3 2 1
    System.out.println();

    // Demonstrate Flattening a Multilevel Linked List.
    // Build a multilevel linked list:
    // Level 1: 1 -> 2 -> 3
    // Node 2 has a child: 7 -> 8
    MultiLevelNode m1 = new MultiLevelNode(1);
    MultiLevelNode m2 = new MultiLevelNode(2);
    MultiLevelNode m3 = new MultiLevelNode(3);
    m1.next = m2;
    m2.next = m3;
    // Child list for node 2: 7 -> 8
    MultiLevelNode mChild1 = new MultiLevelNode(7);
    MultiLevelNode mChild2 = new MultiLevelNode(8);
    mChild1.next = mChild2;
    m2.child = mChild1;

    MultiLevelNode flattenedHead = flattenMultiLevelList(m1);
    System.out.println("Flattened Multilevel List:");
    printMultiLevelList(flattenedHead); // Expected: 1 -> 2 -> 7 -> 8 -> 3
  }
}
