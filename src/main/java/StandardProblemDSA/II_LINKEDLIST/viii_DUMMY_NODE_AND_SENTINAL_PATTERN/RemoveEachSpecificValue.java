package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

/*
 Problem: Remove all nodes with a specific value from a linked list.

 Given the head of a linked list and a value val, remove all nodes with value val and return the new head.

 Example:
 Input: head = 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6
 Output: 1 -> 2 -> 3 -> 4 -> 5

 Pattern:
    - Linked List
    - Dummy Node / Sentinel Node
    - In-place Deletion

 Similar LeetCode Problems:
    - 203. Remove Linked List Elements
    - 19. Remove Nth Node From End of List
    - 237. Delete Node in a Linked List

 Follow-up Questions:
    - How to do it without dummy node? (handle head separately)
    - Can this be done recursively?
    - How to remove multiple values in one pass?
    - How to handle doubly linked lists?

 Time Complexity: O(n), n = number of nodes
 Space Complexity: O(1)
*/

public class RemoveEachSpecificValue {
  public ListNode removeElements(ListNode head, int val) {
    // Create a dummy node to handle edge cases for head removal
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode current = dummy; // start from the dummy node

    while (current.next != null) {
      if (current.next.val == val) {
        // Skip the node with the value `val`
        current.next = current.next.next;
      } else {
        // Move to the next node
        current = current.next;
      }
    }

    return dummy.next; // return the new head (which might have changed)
  }
}
