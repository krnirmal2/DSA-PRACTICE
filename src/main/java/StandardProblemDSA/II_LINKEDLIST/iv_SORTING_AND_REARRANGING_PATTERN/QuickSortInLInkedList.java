package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.getTail;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class QuickSortInLInkedList {

  // ---------------------------------------------------
  // 2. Quick Sort for Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given the head of a linked list, sort the list using quick sort.

    Brute Force Approach:
       - Convert the list to an array, quick sort the array, then rebuild the list.

    Optimal Approach:
       - Use quick sort in place on the linked list.
       - Partition the list around a pivot, then recursively sort partitions.
       - Time Complexity: Average O(n log n); worst-case O(n^2)
       - Note: In practice, merge sort is often preferred for linked lists.

    Example:
       Input: 3 -> 5 -> 2 -> 4 -> 1
       Output: 1 -> 2 -> 3 -> 4 -> 5
  */
  public ListNode quickSort(ListNode head) {
    return quickSortRec(head, getTail(head));
  }

  // Utility: Recursively quick sort from head to tail.
  private ListNode quickSortRec(ListNode head, ListNode tail) {
    // steps; if list is empty or only single node return head;
    if (head == null || head == tail) {
      return head;
    }
    // step 1: make the partition accross last element as pivot element
    ListNode[] partitioned = Utility_linkedList.partition(head, tail);
    ListNode newHead = partitioned[0];
    ListNode pivot = partitioned[1];
    ListNode newTail = partitioned[2];

    // Sort the part before pivot
    if (newHead != pivot) {
      // Find node before pivot
      ListNode temp = newHead;
      while (temp.next != pivot) {
        temp = temp.next;
      }
      temp.next = null;
      newHead = quickSortRec(newHead, temp);
      // Reconnect pivot
      temp = getTail(newHead);
      temp.next = pivot;
    }

    // Sort the part after pivot
    pivot.next = quickSortRec(pivot.next, newTail);
    return newHead;
  }

  public static void main(String[] args) {
    /*// Example for Quick Sort:
    // Build unsorted list: 3 -> 5 -> 2 -> 4 -> 1
    ListNode quickHead = ops.new ListNode(3);
    quickHead.next = ops.new ListNode(5);
    quickHead.next.next = ops.new ListNode(2);
    quickHead.next.next.next = ops.new ListNode(4);
    quickHead.next.next.next.next = ops.new ListNode(1);
    System.out.println("Original List for Quick Sort:");
    ops.printList(quickHead);
    ListNode sortedQuick = ops.quickSort(quickHead);
    System.out.println("Sorted List using Quick Sort:");
    ops.printList(sortedQuick);*/
  }
}
