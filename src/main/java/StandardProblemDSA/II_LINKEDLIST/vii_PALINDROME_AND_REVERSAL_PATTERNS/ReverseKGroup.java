package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

class Main {

  // Function to reverse nodes in groups of K
  static Node kReverse(Node head, int k) {
    // Initialize a temporary
    // node to traverse the list
    Node temp = head;

    // Initialize a pointer to track the
    // last node of the previous group
    Node prevLast = null;

    // Traverse through the linked list
    while (temp != null) {

      // Get the Kth node of the current group
      Node kThNode = Utility_linkedList.getKthNode(temp, k);

      // If the Kth node is NULL
      // (not a complete group)
      if (kThNode == null) {

        // If there was a previous group,
        // link the last node to the current node
        if (prevLast != null) {
          prevLast.next = temp;
        }

        // Exit the loop
        break;
      }

      // Store the next node
      // after the Kth node
      Node nextNode = kThNode.next;

      // Disconnect the Kth node
      // to prepare for reversal
      kThNode.next = null;

      // Reverse the nodes from
      // temp to the Kth node
      Utility_linkedList.reverseNodes(temp);

      // Adjust the head if the reversal
      // starts from the head
      if (temp == head) {
        head = kThNode;
      } else {
        // Link the last node of the previous
        // group to the reversed group
        prevLast.next = kThNode;
      }

      // Update the pointer to the
      // last node of the previous group
      prevLast = temp;

      // Move to the next group
      temp = nextNode;
    }

    // Return the head of the
    // modified linked list
    return head;
  }

  public static void main(String[] args) {
    // Create a linked list with
    // values 5, 4, 3, 7, 9 and 2
    Node head = new Node(5);
    head.next = new Node(4);
    head.next.next = new Node(3);
    head.next.next.next = new Node(7);
    head.next.next.next.next = new Node(9);
    head.next.next.next.next.next = new Node(2);

    // Print the original linked list
    System.out.print("Original Linked List: ");
    printList(head);

    // Reverse the linked list
    head = kReverse(head, 4);

    // Print the reversed linked list
    System.out.print("Reversed Linked List: ");
    printList(head);
  }
}
