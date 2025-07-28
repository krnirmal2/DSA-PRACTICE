package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

public class PartitionLinkedList {
  /*
  Problem: Partition Linked List Around a Value
  ---------------------------------------------
  Problem Statement:
  Given the head of a linked list and an integer x, rearrange the list so that all nodes
  with values less than x come before nodes with values greater than or equal to x.
  The relative order of nodes in each partition should remain unchanged.

  Approach:
  ---------
  1. **Key Idea**:
     - Use two separate linked lists: one for nodes `< x` and one for nodes `>= x`.
     - Maintain dummy heads (`beforeDummy`, `afterDummy`) and current tails (`before`, `after`) for both lists.
     - Traverse the original list and partition nodes into the two lists.
     - Merge the two lists by connecting the `before` list to the `after` list.

  2. **Steps**:
     - Traverse `head`, append each node to either `before` or `after` list.
     - After traversal, terminate the `after` list (`after.next = null`).
     - Connect `before` list to `after` list (`before.next = afterDummy.next`).
     - Return `beforeDummy.next` as the new head.

  3. **Time Complexity**: O(n) — single traversal of the list.
  4. **Space Complexity**: O(1) — no extra data structures used, only pointers.

  Example:
  --------
  Input:  1 → 4 → 3 → 2 → 5 → 2, x = 3
  Output: 1 → 2 → 2 → 4 → 3 → 5

  Edge Cases:
  -----------
  - Empty list (head = null) → return null.
  - All nodes < x or all nodes >= x.
  - x not present in the list.

  Follow-Up:
  ----------
  - Can we do this in-place without using extra dummy nodes? (Yes, but it complicates pointer management.)

  LeetCode:
  ---------
  - [86. Partition List](https://leetcode.com/problems/partition-list/)
  */

  public static Node partitionAroundValue(Node head, int x) {
    // 1.create two dummy node with value zero
    Node beforeDummy = Utility_linkedList.createNewNode(0);
    Node afterDummy = Utility_linkedList.createNewNode(0);
    // 2. assign this dummy node another two nodes
    Node before = beforeDummy, after = afterDummy;

    // 3. now iterate over the head node
    while (head != null) {
      // case 1: node whose value less than x, we will assing it to before node
      if (head.data < x) {
        before.next = head;
        before = before.next;
      } else {
        // case 2: node whose value is greater than x, we will assign it to after node
        after.next = head;
        after = after.next;
      }
      // after each iteration head will goes to its next
      head = head.next;
    }
    // 4. condition to make a single list
    after.next = null;
    before.next = afterDummy.next;
    return beforeDummy.next;
  }

  public static void main(String[] args) {

    // Example for Partition Around a Value:
    // Build list: 1 -> 4 -> 3 -> 2 -> 5 -> 2, with x = 3
    Node partitionHead = new Node(1);
    partitionHead.next = new Node(4);
    partitionHead.next.next = new Node(3);
    partitionHead.next.next.next = new Node(2);
    partitionHead.next.next.next.next = new Node(5);
    partitionHead.next.next.next.next.next = new Node(2);
    System.out.println("Original List for Partitioning:");
    printList(partitionHead);
    Node partitionedList = partitionAroundValue(partitionHead, 3);
    System.out.println("List after Partitioning around value 3:");
    printList(partitionedList);
  }
}
