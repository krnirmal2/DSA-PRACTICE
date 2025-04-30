package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class AlternatePositiveNegativeNo {
  // ---------------------------------------------------
  // 4. Rearrange List Alternately (Positive and Negative Nodes)
  // ---------------------------------------------------
  /*
    Problem Statement:
       Rearrange the linked list so that positive and negative numbers alternate.
       The order of appearance should be maintained as in the original list.

    Brute Force Approach:
       - Traverse the list, extract positive and negative nodes into two lists,
         then merge them alternately.

    Optimal Approach:
       - Using two dummy nodes, separate positive and negative nodes while traversing.
       - Merge the two lists by alternately linking nodes.
       - Time Complexity: O(n)
       - Space Complexity: O(1)

    Example:
       Input: 1 -> -2 -> 3 -> -4 -> 5 -> -6
       Output: 1 -> -2 -> 3 -> -4 -> 5 -> -6
       (If already alternating, the order remains. If not, adjust accordingly.)
  */
  public ListNode rearrangePosNeg(ListNode head) {
    if (head == null) return null;
    ListNode posDummy = new ListNode(0), negDummy = new ListNode(0);
    ListNode posTail = posDummy, negTail = negDummy;
    ListNode curr = head;
    while (curr != null) {
      if (curr.val >= 0) {
        posTail.next = curr;
        posTail = posTail.next;
      } else {
        negTail.next = curr;
        negTail = negTail.next;
      }
      curr = curr.next;
    }
    // End the lists.
    posTail.next = null;
    negTail.next = null;

    // Merge alternately: choose the list that comes first in original order.
    ListNode newHead = posDummy.next != null ? posDummy.next : negDummy.next;
    ListNode pos = posDummy.next, neg = negDummy.next;
    ListNode tail = new ListNode(0); // dummy for merge

    while (pos != null && neg != null) {
      tail.next = pos;
      tail = tail.next;
      pos = pos.next;

      tail.next = neg;
      tail = tail.next;
      neg = neg.next;
    }
    if (pos != null) tail.next = pos;
    if (neg != null) tail.next = neg;

    return newHead;
  }

  public static void main(String[] args) {
    /*

    // Example for Rearranging Alternately (Positive and Negative):
    // Build list: 1 -> -2 -> 3 -> -4 -> 5 -> -6
    ListNode posNegHead = ops.new ListNode(1);
    posNegHead.next = ops.new ListNode(-2);
    posNegHead.next.next = ops.new ListNode(3);
    posNegHead.next.next.next = ops.new ListNode(-4);
    posNegHead.next.next.next.next = ops.new ListNode(5);
    posNegHead.next.next.next.next.next = ops.new ListNode(-6);
    System.out.println("Original List for Positive/Negative Rearrangement:");
    ops.printList(posNegHead);
    ListNode rearrangedList = ops.rearrangePosNeg(posNegHead);
    System.out.println("List after alternating Positive and Negative Nodes:");
    ops.printList(rearrangedList);*/
  }
}
