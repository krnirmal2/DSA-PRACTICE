package StandardProblemDSA.II_LINKEDLIST.iii_RECURSIVE_PATTERN;

public class RecursiveLinkedListOperations {

  // Definition for singly-linked list node.
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  // Definition for a multilevel linked list node.
  // Here, each node has a 'next' pointer and may have a 'child' pointer.
  class MultiLevelNode {
    int val;
    MultiLevelNode next;
    MultiLevelNode child;

    MultiLevelNode(int x) {
      val = x;
      next = null;
      child = null;
    }
  }

  // 1. Recursive Merge of Two Sorted Lists
  // Merges two sorted singly-linked lists and returns the head of the merged list.
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

  // 2. Recursive Traversal (Print in Reverse Order)
  // Prints the values of a linked list in reverse order using recursion.
  public void printReverse(ListNode head) {
    if (head == null) return;
    printReverse(head.next);
    System.out.print(head.val + " ");
  }

  // 3. Flatten a Multilevel Linked List Recursively
  // Given a multilevel linked list where nodes may have a 'child' pointer,
  // flatten the list so that all nodes appear in a single-level linked list.
  // The method returns the head of the flattened list.
  public MultiLevelNode flattenMultiLevelList(MultiLevelNode head) {
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

  // Utility method to print a singly-linked list.
  public void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      if (curr.next != null) {
        System.out.print(" -> ");
      }
      curr = curr.next;
    }
    System.out.println();
  }

  // Utility method to print a flattened multilevel linked list.
  public void printMultiLevelList(MultiLevelNode head) {
    MultiLevelNode curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      if (curr.next != null) {
        System.out.print(" -> ");
      }
      curr = curr.next;
    }
    System.out.println();
  }

  // -------------------------------
  // Main method for demonstration
  // -------------------------------
  public static void main(String[] args) {
    RecursiveLinkedListOperations ops = new RecursiveLinkedListOperations();

    // Demonstrate Recursive Merge of Two Sorted Lists.
    // Build first sorted list: 1 -> 3 -> 5
    ListNode l1 = ops.new ListNode(1);
    l1.next = ops.new ListNode(3);
    l1.next.next = ops.new ListNode(5);

    // Build second sorted list: 2 -> 4 -> 6
    ListNode l2 = ops.new ListNode(2);
    l2.next = ops.new ListNode(4);
    l2.next.next = ops.new ListNode(6);

    ListNode mergedHead = ops.mergeTwoLists(l1, l2);
    System.out.println("Merged Sorted List:");
    ops.printList(mergedHead); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6

    // Demonstrate Recursive Traversal: Print in Reverse Order.
    System.out.println("Print Merged List in Reverse Order:");
    ops.printReverse(mergedHead); // Expected reverse order: 6 5 4 3 2 1
    System.out.println();

    // Demonstrate Flattening a Multilevel Linked List.
    // Build a multilevel linked list:
    // Level 1: 1 -> 2 -> 3
    // Node 2 has a child: 7 -> 8
    MultiLevelNode m1 = ops.new MultiLevelNode(1);
    MultiLevelNode m2 = ops.new MultiLevelNode(2);
    MultiLevelNode m3 = ops.new MultiLevelNode(3);
    m1.next = m2;
    m2.next = m3;
    // Child list for node 2: 7 -> 8
    MultiLevelNode mChild1 = ops.new MultiLevelNode(7);
    MultiLevelNode mChild2 = ops.new MultiLevelNode(8);
    mChild1.next = mChild2;
    m2.child = mChild1;

    MultiLevelNode flattenedHead = ops.flattenMultiLevelList(m1);
    System.out.println("Flattened Multilevel List:");
    ops.printMultiLevelList(flattenedHead); // Expected: 1 -> 2 -> 7 -> 8 -> 3
  }
}
