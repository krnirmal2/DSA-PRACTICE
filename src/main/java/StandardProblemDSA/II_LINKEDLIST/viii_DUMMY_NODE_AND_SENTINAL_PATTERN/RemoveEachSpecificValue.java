package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

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
    - 203. Remove Linked List Elements done
    - 19. Remove Nth Node From End of List
    - 237. Delete Node in a Linked List
Remove Element
Easy
Delete Node in a Linked List
Medium
Delete the Middle Node of a Linked List
Medium
Delete Nodes From Linked List Present in Array
Medium
Convert Doubly Linked List to Array I
Easy
Convert Doubly Linked List to Array II
Medium
 Follow-up Questions:
    - How to do it without dummy node? (handle head separately)
    - Can this be done recursively?
    - How to remove multiple values in one pass?
    - How to handle doubly linked lists?

 Time Complexity: O(n), n = number of nodes
 Space Complexity: O(1)
*/

public class RemoveEachSpecificValue {
  public static ListNode removeElements(ListNode head, int val) {
    // Step 1 : Create a dummy node to keep track of the head node at last we return
    ListNode temp = new ListNode(-1);
    temp.next = head;
    // Step 2 : we have set the dummy node
    ListNode current = temp; // start from the dummy node

    // Step 3 : iterate over the each value and check the next of it is equal to the target
    // value or not , if yes than skip current next = current .next .next so the delete or ignore
    // by the temp head node
    while (current.next != null) {
      if (current.next.val == val) {
        // Skip the node with the value `val`
        current.next = current.next.next;
      } else {
        // Move to the next node
        current = current.next;
      }
    }

    return temp; // return the new head (which might have changed)
  }

  public static void main(String[] args) {
    //      int [] linkedllist = {1,2,6,3,4,5,6};
    int[] linkedllist = {7, 7, 7, 7};
    ListNode removeList = removeElements(Utility_linkedList.arrayToLinkedList(linkedllist), 7);
    Utility_linkedList.printList(removeList);
  }
}
