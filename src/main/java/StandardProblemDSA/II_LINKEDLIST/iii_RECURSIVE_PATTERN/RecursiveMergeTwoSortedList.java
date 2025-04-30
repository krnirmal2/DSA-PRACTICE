package StandardProblemDSA.II_LINKEDLIST.iii_RECURSIVE_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class RecursiveMergeTwoSortedList {
  // ---------------------------------------------------
  // 1. Merge Sort for Linked List
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given the head of a linked list, sort the list using merge sort.

    Brute Force Approach:
       - Convert the linked list into an array.
       - Sort the array (e.g., using Arrays.sort).
       - Convert the array back to a linked list.
       - Time: O(n log n) but uses extra space O(n).

    Optimal Approach:
       - Use a recursive merge sort that splits the list in half (using slow/fast pointers),
         recursively sorts each half, then merges them.
       - Time Complexity: O(n log n)
       - Space Complexity: O(log n) due to recursion stack.

    Example:
       Input: 4 -> 2 -> 1 -> 3
       Output: 1 -> 2 -> 3 -> 4
  */
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    // Split list into halves
    ListNode mid = Utility_linkedList.findMiddle(head);
    ListNode nextToMid = mid.next;
    mid.next = null; // Break the list

    // Recursively sort the halves
    ListNode left = mergeSort(head);
    ListNode right = mergeSort(nextToMid);

    // Merge sorted halves
    return Utility_linkedList.mergeTwoLists(left, right);
  }

  public static void main(String[] args) {
    RecursiveMergeTwoSortedList ops = new RecursiveMergeTwoSortedList();

    // Example for Merge Sort:
    // Build unsorted list: 4 -> 2 -> 1 -> 3
    ListNode mergeHead = new ListNode(4);
    mergeHead.next = new ListNode(2);
    mergeHead.next.next = new ListNode(1);
    mergeHead.next.next.next = new ListNode(3);
    System.out.println("Original List for Merge Sort:");
    printList(mergeHead);
    ListNode sortedMerge = new RecursiveMergeTwoSortedList().mergeSort(mergeHead);
    System.out.println("Sorted List using Merge Sort:");
    printList(sortedMerge);
  }
}
