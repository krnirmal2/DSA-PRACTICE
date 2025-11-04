package StandardProblemDSA.II_LINKEDLIST.iii_RECURSIVE_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class RecursiveMergeTwoSortedList {
  /* Problem: Merge Sort for Linked List
     -----------------------------------
     Problem Statement:
     Given the head of a singly linked list, sort it in ascending order using merge sort.

     Approach:
     1. **Base Case**: If the list is empty or has only one node, it's already sorted.
     2. **Find Middle**: Use slow/fast pointers to find the middle node.
     3. **Split List**: Break the list into two halves at the middle.
     4. **Recursive Sort**: Recursively sort both halves.
     5. **Merge**: Use the standard merge of two sorted linked lists.

     Why Merge Sort?
     - Merge sort is stable and works efficiently on linked lists since we don't need random access.
     - Unlike quicksort, it does not require additional space for rearranging nodes.

     Time Complexity: O(n log n), where n is the number of nodes.
     Space Complexity: O(log n), recursion stack depth.

     Patterns: Divide & Conquer, Linked List Sorting.

     Edge Cases:
     - Empty list (`head == null`).
     - Single element list.
     - List with duplicate values.

     Follow-up:
     - Implement an **iterative bottom-up merge sort** to reduce recursion stack usage.

     Related LeetCode Problem:
     - 148. Sort List
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
