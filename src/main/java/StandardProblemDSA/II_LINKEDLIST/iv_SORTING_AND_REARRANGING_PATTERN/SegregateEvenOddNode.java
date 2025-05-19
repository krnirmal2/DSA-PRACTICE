package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class SegregateEvenOddNode {

  // ---------------------------------------------------
  // 3. Segregate Even and Odd Nodes
  // ---------------------------------------------------
  /*
    Problem Statement:
       Rearrange the linked list so that all even-valued nodes appear before odd-valued nodes.

    Brute Force Approach:
       - Traverse the list, store even and odd nodes in separate arrays/lists,
         then combine them.

    Optimal Approach:
       - Use two dummy nodes to build separate even and odd lists while traversing once,
         then join them.
       - Time Complexity: O(n)
       - Space Complexity: O(1)

    Example:
       Input: 17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6
       Output: 8 -> 2 -> 4 -> 6 -> 17 -> 15 -> 9
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
