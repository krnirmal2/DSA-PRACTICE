package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class PartitionLinkedList {

  // ---------------------------------------------------
  // 5. Partition Linked List Around a Value
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given a linked list and a value x, partition it such that all nodes less than x
       come before nodes greater than or equal to x. The original relative order should be preserved.

    Brute Force Approach:
       - Convert list to an array, partition the array, then rebuild the list.

    Optimal Approach:
       - Use two dummy nodes: one for nodes less than x, another for nodes greater or equal.
       - Traverse the list, appending nodes to the appropriate list.
       - Merge the two lists.
       - Time Complexity: O(n)
       - Space Complexity: O(1)

    Example:
       Input: 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
       Output: 1 -> 2 -> 2 -> 4 -> 3 -> 5
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
