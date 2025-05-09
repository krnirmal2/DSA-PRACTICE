package StandardProblemDSA.II_LINKEDLIST.iii_RECURSIVE_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.MultiLevelNode.printMultiLevelList;
import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.MultiLevelNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class RecursiveLinkedListOperations {
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
