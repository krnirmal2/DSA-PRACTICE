package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

public class AlternatingSplitLLWithDeepCopy {
  /*
  Problem: Split Linked List Alternately (Deep Copy)
  --------------------------------------------------
  Problem Statement:
  Given the head of a singly linked list, split it into two separate lists:
  - List 1: nodes at even positions (0, 2, 4, …)
  - List 2: nodes at odd positions (1, 3, 5, …)
  Create **new nodes** for the split lists (deep copy, do not reuse original nodes).

  Approach:
  ---------
  1. **Dummy Nodes**:
     - Create `dummyHead1` and `dummyHead2` to simplify list building.
     - Use `tail1` and `tail2` to keep track of the current ends of the new lists.

  2. **Traverse with Boolean Toggle**:
     - Maintain a `turn` flag to alternate appending between List 1 and List 2.
     - For each node in the original list, create a deep copy (`new Node(head.data)`).

  3. **Return Heads**:
     - Return new heads by skipping dummy nodes.

  Time Complexity: **O(n)** — traverses the list once.
  Space Complexity: **O(n)** — creates new nodes for both lists.

  Example:
  --------
  Input: 1 → 2 → 3 → 4 → 5
  Output:
  - List 1: 1 → 3 → 5
  - List 2: 2 → 4

  Follow-up:
  ----------
  - Modify to perform **in-place splitting** (without creating new nodes) for O(1) extra space.
  - Related Problem: LeetCode 328 (Odd-Even Linked List).
  */

  public static Node[] splitAlternate(Node head) {
    // step 1: create two dummy node with -1
    Node dummyHead1 = Utility_linkedList.createNewNode(-1);
    Node dummyHead2 = Utility_linkedList.createNewNode(-1);
    // step 2; create two extra node and assign them
    Node tail1 = dummyHead1;
    Node tail2 = dummyHead2;
    // Step 3 : iterate over the list and processed for the question
    boolean turn = true;
    while (head != null) {
      // Create a new node (deep copy)
      Node newNode = new Node(head.data);

      if (turn) {
        tail1.next = newNode; // assign the new node next of the last tail
        tail1 = tail1.next; // update the previous tell
      } else {
        tail2.next = newNode;
        tail2 = tail2.next;
      }
      // continue the head to iterate
      head = head.next;
      // make the turn opposite to its last state
      turn = !turn;
    }

    // step 4: here  Return actual heads (skip dummy nodes) and not merge two list as we need
    // separate list
    return new Node[] {dummyHead1.next, dummyHead2.next};
  }

  // Example usage
  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);
    head.next.next.next.next.next = new Node(60);

    Node[] result = splitAlternate(head);

    System.out.println("List 1:");
    printList(result[0]);

    System.out.println("List 2:");
    printList(result[1]);
  }
}
