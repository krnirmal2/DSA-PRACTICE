package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

public class AlternatePositiveNegativeNo {
  /* Problem: Rearrange List Alternately (Positive and Negative Nodes)
     -----------------------------------------------------------------
     Problem Statement:
     Given a singly linked list, rearrange it so that positive and negative numbers alternate.
     The order of appearance should be maintained as in the original list.

     Approach:
     1. **Separate Lists**:
        - Create two dummy nodes (`posDummy` and `negDummy`) to hold positive and negative nodes.
        - Traverse the original list:
          - Append positive nodes to the positive list.
          - Append negative nodes to the negative list.
        - Maintain tail pointers (`posTail` and `negTail`) for each list.
     2. **Terminate Lists**:
        - Set `posTail.next = null` and `negTail.next = null` to mark the end of each list.
     3. **Merge Alternately**:
        - Merge positive and negative lists alternately, preserving the order of nodes within each.
        - The merged list's head is the first available node (`posDummy.next` or `negDummy.next`).

     Example:
        Input:  1 -> -2 -> 3 -> -4 -> 5 -> -6
        Output: 1 -> -2 -> 3 -> -4 -> 5 -> -6

     Time Complexity: O(n), one traversal to split and one to merge.
     Space Complexity: O(1), rearranging pointers in place.

     Edge Cases:
     - All positive or all negative nodes (one of the lists will be empty).
     - Empty list (`head == null`).

     Follow-up:
     - Modify the function to start with a negative node if the first node is negative.

     Related LeetCode Problems:
     - 143. Reorder List
     - 328. Odd Even Linked List
  */

  public static Node rearrangePosNeg(Node head) {
    if (head == null) return null;
    // 1.create two dummy node with value zero Remain fixed — we never move them.
    // After list creation, their .next points to the actual head of the respective list.
    Node posDummy = Utility_linkedList.createNewNode(0), // act as head node
        negDummy = Utility_linkedList.createNewNode(0);
    // 2. assign this dummy node another two nodes beacuse earlier node will remain intact as it is
    // and this two node
    // create new node Keep track of the current tail of the positive and negative lists
    // respectively.
    Node posTail = posDummy,
        negTail = negDummy; // These are moving pointers used to build the lists by appending nodes.
    // 3. now iterate over the head node and create the two list
    while (head != null) {
      if (head.data >= 0) {
        // only create positive no. list
        posTail.next = head;
        posTail = posTail.next;
      } else {
        // only create negative no. list with negative pointer not head pointer
        negTail.next = head;
        negTail = negTail.next;
      }
      head = head.next; // it just iterating over each element
    }
    // End the lists. with null if element traverse is end
    posTail.next = null;
    negTail.next = null;

    // Merge alternately: choose the list that comes first in original order.
    // now we will take just next of dummy nodes is present or not as they start from 0
    Node newHead = posDummy.next != null ? posDummy.next : negDummy.next;
    // 4. condition to make a single list
    Utility_linkedList.mergeListWithTwoDummyNode(posDummy, negDummy);
    return newHead;
  }

  public static void main(String[] args) {

    // Example for Rearranging Alternately (Positive and Negative):
    // Build list: 1 -> -2 -> 3 -> -4 -> 5 -> -6
    Node posNegHead = new Node(1); // head is already the first element of the list
    posNegHead.next = new Node(-2);
    posNegHead.next.next = new Node(3);
    posNegHead.next.next.next = new Node(4);
    posNegHead.next.next.next.next = new Node(5);
    posNegHead.next.next.next.next.next = new Node(-6);
    System.out.println("Original List for Positive/Negative Rearrangement:");
    printList(posNegHead);
    Node rearrangedList = rearrangePosNeg(posNegHead);
    System.out.println("List after alternating Positive and Negative Nodes:");
    printList(rearrangedList);
  }
}
