package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import static StandardProblemDSA.II_LINKEDLIST.i_TRAVERSAL_BASIC_OPERATION.LinkedList.insert;
import static StandardProblemDSA.II_LINKEDLIST.i_TRAVERSAL_BASIC_OPERATION.LinkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.i_TRAVERSAL_BASIC_OPERATION.LinkedList;
import StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN.ListNode;

public class ReverseKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    // Edge case: If the list is empty or has less than k nodes, return as is
    if (head == null || k <= 1) return head;

    // Dummy node to track new head
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    // Pointers to track the previous group's tail and the start of the next group
    ListNode prevTail = dummy, current = head;

    while (true) {
      // Check if there are at least k nodes left to reverse
      ListNode temp = current;
      int count = 0;
      while (temp != null && count < k) {
        temp = temp.next;
        count++;
      }

      // If we don't have enough nodes, break
      if (count < k) break;

      // Reverse k nodes and get new head & tail
      ListNode reversedHead = reverse(current, k);

      // Connect previous part with newly reversed list
      prevTail.next = reversedHead;

      // Move prevTail and current pointers to the next segment
      prevTail = current;
      current = prevTail.next;
    }

    return dummy.next;
  }

  private ListNode reverse(ListNode head, int k) {
    ListNode prev = null, current = head, next = null;

    while (k-- > 0) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    // `head` is now the tail of the reversed segment, so it should point to the next segment
    head.next = current;

    // `prev` is the new head of the reversed segment
    return prev;
  }

  public static class ReverseLinkedList {

    public static LinkedList.Node reverseLinkedList(LinkedList.Node head) {

      // taking three pointers

      LinkedList.Node prev = null;
      LinkedList.Node current = head;

      while (current != null) {
        // Store next node
        LinkedList.Node next = current.next; // Store the next node (next = curr.next).
        // Reverse the link
        current.next = prev; // Reverse the link (curr.next = prev).
        // Move pointers one step forward
        prev = current; // Move the prev and curr pointers forward.
        current = next;
      }
      return prev;
    }

    public static void main(String[] args) {

      /* Start with the empty list. */
      LinkedList list = new LinkedList();
      // Insert the values
      list = insert(list, 1);
      list = insert(list, 2);
      list = insert(list, 3);
      list = insert(list, 4);
      printList(list);

      reverseLinkedList(list.head);

      printList(list);
    }
  }
}
