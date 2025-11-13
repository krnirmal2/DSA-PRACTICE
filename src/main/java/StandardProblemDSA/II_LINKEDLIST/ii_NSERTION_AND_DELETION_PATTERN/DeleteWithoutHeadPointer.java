package StandardProblemDSA.II_LINKEDLIST.ii_NSERTION_AND_DELETION_PATTERN;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;

public class DeleteWithoutHeadPointer {
  /* Problem Statement:
     You are given a reference to a node in a singly linked list, and you need to delete this node.
     The catch is that you are not given access to the head of the list.

     Constraints:
     - The node to delete is guaranteed not to be the last node of the list.
     - You cannot traverse backward since it's a singly linked list.

     Example:
     Input: Linked List = 1 -> 2 -> 3 -> 4 -> 5, node = 3
     Output: Linked List after deletion = 1 -> 2 -> 4 -> 5

     Approach:
     - We can't find the previous node without the head, so we "overwrite" the current node with the next node.
     - Copy the data of `node.next` into `node`.
     - Point `node.next` to `node.next.next`, effectively removing the next node.
     - This works as long as the node to delete is not the last node.

     Edge Cases:
     - Node is null: cannot delete.
     - Node is the last node: impossible to delete because we can't update the previous node.

     Time Complexity: O(1)
     Space Complexity: O(1)

     Pattern: Linked List Manipulation (In-place overwrite).

     Follow-up:
     - Why can't we delete the last node with this method?
     - How would you design a linked list API to safely handle this kind of operation?

     Related LeetCode Problem:
     - 237. Delete Node in a Linked List
  */

  public static void deleteNode(Node node) {
    if (node == null || node.next == null) {
      throw new IllegalArgumentException("Node to be deleted cannot be null or the last node.");
    }

    // Copy the data from the next node to the current node
    node.data = node.next.data;

    // Bypass the next node
    node.next = node.next.next;
  }

  // Main method to test the implementation
  public static void main(String[] args) {
    /*Edge Cases
    Null Node:
    If the node to be deleted is null, throw an exception or handle the error gracefully.

    Last Node:
    If the node to be deleted is the last node, the method cannot work since there’s no next node to copy data from. An exception is thrown in this case.

    Single Node List:
    Deleting the only node in a list is not possible using this method.*/
    // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);

    System.out.println("Original Linked List:");
    printList(head);

    // Delete the node with value 3 (we are given only the node, not the head)
    Node nodeToDelete = head.next.next; // Node with value 3
    deleteNode(nodeToDelete);

    System.out.println("Linked List after deleting node 3:");
    printList(head);
  }
}
