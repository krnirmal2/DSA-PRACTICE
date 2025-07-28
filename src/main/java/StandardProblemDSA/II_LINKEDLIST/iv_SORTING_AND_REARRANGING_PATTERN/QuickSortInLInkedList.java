package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.getTail;

public class QuickSortInLInkedList {

  /*
  Problem: Quick Sort for Linked List
  -----------------------------------
  Problem Statement:
  Given the head of a linked list, sort the list in ascending order using Quick Sort.

  Approach:
  ---------
  1. **Key Idea**:
     - Choose the last node as the pivot.
     - Partition the list so that nodes less than the pivot come before it, and nodes greater or equal come after it.
     - Recursively quick sort the two partitions.
     - Reconnect the sorted parts with the pivot node.

  2. **Steps**:
     - Base case: if the sublist has 0 or 1 nodes, it’s already sorted.
     - Partition the list using `Utility_linkedList.partition(head, tail)` which returns:
         - `newHead`: head of the left partition,
         - `pivot`: pivot node,
         - `newTail`: tail of the right partition.
     - Recursively quick sort nodes before and after the pivot.
     - Reconnect pivot and sorted partitions.

  3. **Time Complexity**:
     - Average: O(n log n)
     - Worst-case: O(n²) (e.g., already sorted or reverse-sorted list if the last node is always picked as pivot).

  4. **Space Complexity**:
     - O(log n) due to recursion stack.

  Example:
  --------
  Input:  3 → 5 → 2 → 4 → 1
  Output: 1 → 2 → 3 → 4 → 5

  Edge Cases:
  -----------
  - Empty list (head = null).
  - Single node list.
  - List with duplicate values.

  Follow-Up:
  ----------
  - Can we improve worst-case performance? (Yes, by choosing a random pivot or median-of-three.)
  - Is Quick Sort recommended for linked lists? (No, Merge Sort is often preferred for stability and guaranteed O(n log n).)

  LeetCode:
  ---------
  - No direct problem for Quick Sort on Linked List, but it's a classic interview variation.
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
