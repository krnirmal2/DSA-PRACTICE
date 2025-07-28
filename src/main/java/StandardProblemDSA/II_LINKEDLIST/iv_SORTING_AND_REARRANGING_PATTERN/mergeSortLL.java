package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class mergeSortLL {
  /*
  Problem: Merge Sort on a Singly Linked List
  -------------------------------------------
  Problem Statement:
  Given the head of a singly linked list, sort it in ascending order using Merge Sort.

  Constraints:
  - 0 <= number of nodes <= 10^5
  - Node values can be any integers.

  Approach:
  ---------
  1. **Why Merge Sort?**
     - Merge Sort works efficiently for linked lists because:
       - Linked lists can be split into halves easily using slow/fast pointers.
       - Merging two sorted linked lists can be done in O(n) without extra space.

  2. **Steps**:
     - **Base Case**: If the list has 0 or 1 node, it's already sorted.
     - **Split the List**:
       - Use `splitLLWithHeadNode(head)` (a helper function using slow/fast pointers) to divide the list into two halves.
     - **Recursive Sort**:
       - Recursively sort each half of the list.
     - **Merge**:
       - Use a `merge(first, second)` function to merge the two sorted halves into a single sorted list.

  3. **Merge Function**:
     - Takes two sorted linked lists and merges them recursively by always selecting the node with the smaller value.

  4. **Time Complexity**: O(n log n) — n for merging and log n for recursive splits.
  5. **Space Complexity**: O(log n) — due to recursion stack.

  Example:
  --------
  Input:  4 → 2 → 1 → 3
  Output: 1 → 2 → 3 → 4

  Follow-Up:
  - Can we do it iteratively? Yes, but recursion is more intuitive for merge sort on linked lists.

  LeetCode:
  - [148. Sort List](https://leetcode.com/problems/sort-list/) — Merge Sort on Linked List
  */

  // Function to merge two sorted singly linked lists
  static ListNode merge(ListNode first, ListNode second) {

    // If either list is empty, return the other list
    if (first == null) return second;
    if (second == null) return first;

    // Pick the smaller value between first and second ListNodes
    if (first.val < second.val) {

      // Recursively merge the rest of the lists and
      // link the result to the current ListNode
      first.next = merge(first.next, second);
      return first;
    } else {
      // Recursively merge the rest of the lists
      // and link the result to the current ListNode
      second.next = merge(first, second.next);
      return second;
    }
  }

  // Function to perform merge sort on a singly linked list
  static ListNode mergeSort(ListNode head) {

    // Base case: if the list is empty or has only one ListNode,
    // it's already sorted
    if (head == null || head.next == null) {
      return head;
    }

    // 1.Split the list into two halves
    ListNode second = Utility_linkedList.splitLLWithHeadNode(head);

    // 2. Recursively sort each half
    head = mergeSort(head);
    second = mergeSort(second);

    // 3. Merge the two sorted halves
    return merge(head, second);
  }

  public static void main(String[] args) {
    // Create a hard-coded singly linked list:
    // 9 -> 8 -> 5 -> 2
    ListNode head = new ListNode(9);
    head.next = new ListNode(8);
    head.next.next = new ListNode(5);
    head.next.next.next = new ListNode(2);

    head = mergeSort(head);
    Utility_linkedList.printList(head);
  }
}
