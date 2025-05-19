package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

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
  public static Node rearrangePosNeg(Node head) {
    if (head == null) return null;
    // 1.create two dummy node with value zero
    Node posDummy = Utility_linkedList.createNewNode(0),
        negDummy = Utility_linkedList.createNewNode(0);
    // 2. assign this dummy node another two nodes
    Node posTail = posDummy, negTail = negDummy;
    // 3. now iterate over the head node and create the two list
    while (head != null) {
      if (head.data >= 0) {
        posTail.next = head;
        posTail = posTail.next;
      } else {
        negTail.next = head;
        negTail = negTail.next;
      }
      head = head.next;
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
    posNegHead.next.next.next = new Node(-4);
    posNegHead.next.next.next.next = new Node(5);
    posNegHead.next.next.next.next.next = new Node(-6);
    System.out.println("Original List for Positive/Negative Rearrangement:");
    printList(posNegHead);
    Node rearrangedList = rearrangePosNeg(posNegHead);
    System.out.println("List after alternating Positive and Negative Nodes:");
    printList(rearrangedList);
  }
}
