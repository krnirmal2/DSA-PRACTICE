package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class PartitionLLOnANumber {
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

  public static ListNode partitionAroundValue(ListNode head, int x) {
    // step  1.create two dummy ListNode with value zero

    // Tip : IF WE DIDN'T USE DUMMY NODES, WE'D HAVE TO HANDLE A SPECIAL CASES
    // What if the first node is <x or >= x or one of the lists ends up empty?
    // ---> dummy nodes act as fixed starting points for the two new lists ,
    // we can always attach new nodes without worrying about whether the list is empty.
    // As this all are not value assigned we assing the address means what ever will change will
    // reflect everywhere

    /*  initial setup
            beforeDummy (0) → null
            afterDummy  (0) → null
            before = beforeDummy
            after  = afterDummy
            head   = 1 → 4 → 3 → 2 → 5 → 2
    */
    ListNode beforeDummy = new ListNode(0); // sstart of the "less than x" list
    ListNode afterDummy = new ListNode(0); // start of the greaer or equal to x list
    //  step  2. assign this dummy node another two ListNodes
    ListNode before = beforeDummy,
        after = afterDummy; // assign the address of dummy to before and after

    //  step  3. now iterate over the head ListNode
    while (head != null) {
      // case 1: ListNode whose value less than x, we will assing it to before ListNode
      if (head.val < x) {
        before.next =
            head; // here swallow copy is done  , as we just put the address of current head
        before =
            before
                .next; // for its next pointer like head ListNode is moving similarly this ListNode
        // also need to move
      } else {
        // case 2: ListNode whose value is greater than x, we will assign it to after ListNode
        after.next = head;
        after = after.next;
      }
      // after each iteration head will goes to its next
      head = head.next;
    }
    //  step  4. condition to make a single list
    after.next = null; // as the after ListNode will reach till the end no ListNode present
    before.next = afterDummy.next;
    return beforeDummy.next;
  }

  public static void main(String[] args) {

    // Example for Partition Around a Value:
    // Build list: 1 -> 4 -> 3 -> 2 -> 5 -> 2, with x = 3
    ListNode partitionHead = new ListNode(1);
    partitionHead.next = new ListNode(4);
    partitionHead.next.next = new ListNode(3);
    partitionHead.next.next.next = new ListNode(2);
    partitionHead.next.next.next.next = new ListNode(5);
    partitionHead.next.next.next.next.next = new ListNode(2);
    System.out.println("Original List for Partitioning:");
    printList(partitionHead);
    ListNode partitionedList = partitionAroundValue(partitionHead, 3);
    System.out.println("List after Partitioning around value 3:");
    printList(partitionedList);
  }
}
/*
`1 → 4 → 3 → 2 → 5 → 2` with `x = 3`, showing the role of the dummy nodes and moving pointers:

        | Step | `head.val` | Condition (`< x`?) | Action Taken         | **beforeDummy list** | **afterDummy list** | `before` points to | `after` points to |
        |------|------------|--------------------|--------------        |----------------------|---------------------|--------------------|-------------------|
        | 0    | —          | —                  | Init                 | 0 → null             | 0 → null            | beforeDummy (0)    | afterDummy (0)    |
        | 1    | 1          | Yes                | Append to **before** | 0 → 1               | 0 → null            | 1                  | 0                 |
        | 2    | 4          | No                 | Append to **after**  | 0 → 1               | 0 → 4               | 1                  | 4                 |
        | 3    | 3          | No                 | Append to **after**  | 0 → 1               | 0 → 4 → 3           | 1                  | 3                 |
        | 4    | 2          | Yes                | Append to **before** | 0 → 1 → 2           | 0 → 4 → 3           | 2                  | 3                 |
        | 5    | 5          | No                 | Append to **after**  | 0 → 1 → 2           | 0 → 4 → 3 → 5       | 2                  | 5                 |
        | 6    | 2          | Yes                | Append to **before** | 0 → 1 → 2 → 2       | 0 → 4 → 3 → 5       | 2 (last)           | 5                 |
        | End  | —          | —                  | Merge lists (`before.next = afterDummy.next`) | 0 → 1 → 2 → 2 → 4 → 3 → 5 | — | — | — |
*/
