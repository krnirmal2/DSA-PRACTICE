package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class TwoHalfOfCircle {
  /*
   Problem: Split a circular linked list into two equal halves.

   Given a circular singly linked list, split it into two circular linked lists of (almost) equal size.

   Example:
   Input: Circular list 1 -> 2 -> 3 -> 4 -> (back to 1)
   Output:
     First half: 1 -> 2 -> (back to 1)
     Second half: 3 -> 4 -> (back to 3)

   Pattern:
      - Linked List
      - Floyd’s Cycle (Slow & Fast pointers)
      - Circular List Manipulation
      - Two Pointer Technique

   Similar LeetCode Problems:
      - 876. Middle of the Linked List (finding middle) done
      - 141. Linked List Cycle (cycle detection) done
      - 142. Linked List Cycle II (cycle start node detection) done

   Follow-up Questions:
      - How to handle odd number of nodes? (one half longer by one)
      - Can this be done for doubly circular lists?
      - How to merge two circular lists back into one?
      - What if list is not circular?

   Time Complexity: O(n), n = number of nodes
   Space Complexity: O(1)
  */

  public static void splitList(ListNode head) {
    // Step 1 : check if their is only one one node , by check head.next = head and also empty list
    if (head == null || head.next == head) {
      System.out.println("List is too small to split.");
      return;
    }
    // Step 2 : use two pointer floyd's cycle detection to detect cycle present using two pointer
    ListNode slow = head;
    ListNode fast = head;

    // Use Floyd’s cycle to find mid point
    while (fast.next != head && fast.next.next != head) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // Step 3 : assign two dummy node with one with head and another with slow's next
    ///  means two half are now creating using this two head
    ListNode head1 = head; // first half is head start from head to till slow
    ListNode head2 =
        slow.next; // second half head will start from slow next as this is where split of circle is
    // done

    // Make two halves circular
    ///  to make first half circular simply point slow's next to original head which is head1 here
    // above
    slow.next = head1;
    ///  second half will circular by make the link
    // we have to shift the earlier circular link that was we point fast next to original head
    // but now this loop will be till the new head2 so we have to make fast pointer next to head2
    if (fast.next == head) fast.next = head2;
    else fast.next.next = head2;

    // Print both halves
    printList(head1);
    printList(head2);
  }

  public void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = head; // circular link

    splitList(head);
  }
}
