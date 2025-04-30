package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class PartitionLinkedList {

  // ---------------------------------------------------
  // 5. Partition Linked List Around a Value
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a linked list and a value x, partition it such that all nodes less than x
       come before nodes greater than or equal to x. The original relative order should be preserved.

    Brute Force Approach:
       - Convert list to an array, partition the array, then rebuild the list.

    Optimal Approach:
       - Use two dummy nodes: one for nodes less than x, another for nodes greater or equal.
       - Traverse the list, appending nodes to the appropriate list.
       - Merge the two lists.
       - Time Complexity: O(n)
       - Space Complexity: O(1)

    Example:
       Input: 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
       Output: 1 -> 2 -> 2 -> 4 -> 3 -> 5
  */
  public ListNode partitionAroundValue(ListNode head, int x) {
    ListNode beforeDummy = new ListNode(0);
    ListNode afterDummy = new ListNode(0);
    ListNode before = beforeDummy, after = afterDummy;

    while (head != null) {
      if (head.val < x) {
        before.next = head;
        before = before.next;
      } else {
        after.next = head;
        after = after.next;
      }
      head = head.next;
    }
    after.next = null;
    before.next = afterDummy.next;
    return beforeDummy.next;
  }

  public static void main(String[] args) {
    /*

    // Example for Partition Around a Value:
    // Build list: 1 -> 4 -> 3 -> 2 -> 5 -> 2, with x = 3
    ListNode partitionHead = ops.new ListNode(1);
    partitionHead.next = ops.new ListNode(4);
    partitionHead.next.next = ops.new ListNode(3);
    partitionHead.next.next.next = ops.new ListNode(2);
    partitionHead.next.next.next.next = ops.new ListNode(5);
    partitionHead.next.next.next.next.next = ops.new ListNode(2);
    System.out.println("Original List for Partitioning:");
    ops.printList(partitionHead);
    ListNode partitionedList = ops.partitionAroundValue(partitionHead, 3);
    System.out.println("List after Partitioning around value 3:");
    ops.printList(partitionedList);*/
  }
}
