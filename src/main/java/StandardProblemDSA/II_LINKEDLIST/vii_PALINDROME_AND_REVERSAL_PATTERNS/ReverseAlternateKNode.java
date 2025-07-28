package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

public class ReverseAlternateKNode {

  /*
  Problem: Reverse Every Alternate K Nodes in a Linked List
  ---------------------------------------------------------
  Given the head of a singly linked list and integer k, reverse the first k nodes,
  leave the next k nodes as they are, then reverse the following k nodes, and so on.

  Approach:
  ---------
  1. **Reverse first k nodes**:
     - Use three pointers: `prev`, `current`, `next`.
     - Reverse k nodes; `prev` becomes new head of this segment.

  2. **Link reversed part to the next segment**:
     - Original `head` now becomes the last node of the reversed segment.
     - Connect `head.next` to the remaining list starting at `current`.

  3. **Skip next k nodes**:
     - Move `current` forward by k-1 nodes to leave this segment untouched.

  4. **Recursive call**:
     - Reverse every alternate k-group in the remaining list by calling recursively on `current.next`.

  Edge Cases:
  -----------
  - If the list has fewer than k nodes at any reversal step, reverse all remaining nodes.
  - If fewer than k nodes remain in the "skip" part, leave them as is.

  Time Complexity:  O(n) — every node is visited once.
  Space Complexity: O(1) auxiliary, ignoring recursion stack.

  Example:
  --------
  Input:  1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9, k = 3
  Output: 3 → 2 → 1 → 4 → 5 → 6 → 9 → 8 → 7

  Follow-up:
  ----------
  - Implement an iterative version to avoid recursion stack overflow on very large lists.
  - Can generalize to "reverse M nodes, skip N nodes" pattern.
  - LeetCode Reference: **LeetCode 2074** (Reverse Nodes in Even Length Groups) — similar pattern.
  */

  public static ListNode reverseAlternateKNodes(ListNode head, int k) {
    if (head == null) return null;

    // Step 1: Reverse first k nodes
    ListNode current = head;
    ListNode prev = null;
    ListNode next = null;
    int count = 0;
    while (current != null && count < k) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }
    // Step 2: Link last of reversed group to the current node
    // Now head becomes the last node in the reversed group.
    // Link it to the next k nodes which remain unchanged.
    if (head != null) {
      head.next = current;
    }

    // Step 3: Skip next k nodes (no reversal)
    count = 0;
    ListNode temp = current;
    while (current != null && count < k - 1) { // move k-1 nodes
      current = current.next;
      count++;
    }

    // Step 4: Recurse for remaining list
    if (current != null) {
      current.next = reverseAlternateKNodes(current.next, k);
    }

    // prev is the new head of the reversed segment.
    return prev;
  }

  public static void main(String[] args) {
    // Build a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    ListNode head = new ListNode(1);
    ListNode current = head;
    for (int i = 2; i <= 9; i++) {
      current.next = new ListNode(i);
      current = current.next;
    }

    // 1. Reverse Every Alternate K Nodes with k = 3
    System.out.println("Original List:");
    printList(head);
    ListNode altReversed = reverseAlternateKNodes(head, 3);
    System.out.println("After Reversing Every Alternate 3 Nodes:");
    printList(altReversed);
    // Expected Output: 3 -> 2 -> 1 -> 4 -> 5 -> 6 -> 9 -> 8 -> 7
  }
}
