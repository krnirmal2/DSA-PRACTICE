package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;

/*
Problem: Concatenate Two Singly Linked Lists
--------------------------------------------
Problem Statement:
Given two singly linked lists `head1` and `head2`, concatenate `head2` at the end of `head1`.
If either list is empty, return the head of the other list.

Approach:
---------
1. **Check for Empty Lists**:
   - If `head1` is null, simply return `head2`.

2. **Traverse First List**:
   - Move through `head1` until the last node (`curr.next == null`).

3. **Link the Lists**:
   - Set `curr.next = head2` to attach the second list.

4. **Return New Head**:
   - The concatenated list starts from `head1`.

Time Complexity: **O(n)** — traverse first list once.
Space Complexity: **O(1)** — no extra space required.

Example:
--------
Input:
- List 1: 1 → 2 → 3
- List 2: 4 → 5 → 6

Output: 1 → 2 → 3 → 4 → 5 → 6

Follow-up:
----------
- Can be extended to concatenate more than two lists.
- LeetCode Variant: Merge multiple sorted linked lists (LeetCode 23).
*/

public class ConcatenationTwoList {
  static Node concat(Node head1, Node head2) {
    // if one list is empty return the head of other
    if (head1 == null) return head2;

    // Find the last node of the first list
    Node curr = head1;
    while (curr.next != null) {
      curr = curr.next;
    }

    // Link the last node of the first list
    // to the head of the second list
    curr.next = head2;

    // Return the head of the concatenated list
    return head1;
  }

  public static void main(String[] args) {
    // Create first linked list: 1 -> 2 -> 3
    Node head1 = new Node(1);
    head1.next = new Node(2);
    head1.next.next = new Node(3);

    // Create second linked list: 4 -> 5
    Node head2 = new Node(4);
    head2.next = new Node(5);

    Node concatHead = concat(head1, head2);
    printList(concatHead);
  }
}
