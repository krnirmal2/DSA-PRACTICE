package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class SegregateEvenOddNode {

  /*
  Problem: Segregate Even and Odd Nodes in a Linked List
  -----------------------------------------------------
  Problem Statement:
  Given the head of a singly linked list, rearrange the list so that all even-valued nodes
  appear before all odd-valued nodes. The relative order of even and odd nodes should be preserved.

  Approach:
  ---------
  1. **Key Idea**:
     - Traverse the linked list once.
     - Maintain two separate lists: one for even-valued nodes, one for odd-valued nodes.
     - Append nodes to their respective lists based on their values.
     - Merge both lists at the end.

  2. **Steps**:
     - Create two dummy nodes (`evenDummy`, `oddDummy`) and corresponding tails (`evenTail`, `oddTail`).
     - Traverse the original list:
         - If the current node’s value is even, attach it to the even list.
         - Else, attach it to the odd list.
     - After traversal, connect the even list to the odd list and terminate the odd list with `null`.
     - Return `evenDummy.next` as the new head.

  3. **Time Complexity**:
     - O(n) — one traversal of the list.

  4. **Space Complexity**:
     - O(1) — no extra space besides a few pointers.

  Example:
  --------
  Input:  17 → 15 → 8 → 9 → 2 → 4 → 6
  Output: 8 → 2 → 4 → 6 → 17 → 15 → 9

  Edge Cases:
  -----------
  - Empty list (head = null).
  - All nodes are even.
  - All nodes are odd.
  - Single node list.

  Follow-Up:
  ----------
  - Can we do this in place without dummy nodes? (Yes, but dummy nodes make the implementation cleaner.)

  LeetCode:
  ---------
  - Similar problem: **LeetCode 328. Odd Even Linked List** (though that problem groups odd-indexed
    and even-indexed nodes, not values).
  */

  public ListNode segregateEvenOdd(ListNode head) {
    // if head is empyt or null return head
    if (head == null) return null;
    // step1: create dummy nodes
    ListNode evenDummy = new ListNode(0);
    ListNode oddDummy = new ListNode(0);
    // step2; assign those two nodes with other nodes
    ListNode evenTail = evenDummy, oddTail = oddDummy;
    // step 3. iterate over the element using head and applied the
    // condition of it
    while (head != null) {
      if (head.val % 2 == 0) {
        evenTail.next = head;
        evenTail = evenTail.next;
      } else {
        oddTail.next = head;
        oddTail = oddTail.next;
      }
      head = head.next;
    }
    // step 4. make a single list
    oddTail.next = null;
    evenTail.next = oddDummy.next;
    return evenDummy.next;
  }

  public static void main(String[] args) {
    /*

    // Example for Segregate Even and Odd Nodes:
    // Build list: 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6
    ListNode evenOddHead = ops.new ListNode(17);
    evenOddHead.next = ops.new ListNode(15);
    evenOddHead.next.next = ops.new ListNode(8);
    evenOddHead.next.next.next = ops.new ListNode(9);
    evenOddHead.next.next.next.next = ops.new ListNode(2);
    evenOddHead.next.next.next.next.next = ops.new ListNode(4);
    evenOddHead.next.next.next.next.next.next = ops.new ListNode(6);
    System.out.println("Original List for Even/Odd Segregation:");
    ops.printList(evenOddHead);
    ListNode segregatedList = ops.segregateEvenOdd(evenOddHead);
    System.out.println("List after segregating Even and Odd Nodes:");
    ops.printList(segregatedList);*/
  }
}
