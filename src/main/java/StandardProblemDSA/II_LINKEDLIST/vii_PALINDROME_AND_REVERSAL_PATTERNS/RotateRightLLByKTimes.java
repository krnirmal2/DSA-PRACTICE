package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

public class RotateRightLLByKTimes {
  /*
   Problem: Rotate a linked list to the right by k positions.

   Given a singly linked list, rotate it right by k nodes. This means moving the last k nodes to the front of the list.
   If k is greater than the length of the list, rotate by k % length.

   Example:
   Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2

   Step 1: Length = 5
   Step 2: Form circular list by connecting tail to head
   Step 3: Normalize k = 2 % 5 = 2
   Step 4: New head is at position length - k = 3 (node 4)
   Step 5: Break loop at new tail (node 3)

   Output: 4 -> 5 -> 1 -> 2 -> 3

   Pattern:
      - Linked List
      - Rotation
      - Circular linked list manipulation

   Similar LeetCode Problems:
      - 61. Rotate List
      - 189. Rotate Array (array version)
      - 328. Odd Even Linked List (manipulation in linked list)

   Follow-up Questions:
      - How to handle left rotation?
      - What if k is zero or multiple of list length?
      - Can it be done without circular linking?
      - How to extend for doubly linked lists?

   Time Complexity: O(n), n = number of nodes
   Space Complexity: O(1)
  */

  public static Node rotateRight(Node head, int k) {
    if (head == null || k == 0) return head;

    // Compute length and get tail.
    Node current = head;
    int length = Utility_linkedList.length(head);
    // Connect tail to head.
    current.next = head;

    // Effective rotations.
    k = k % length;
    // For right rotation, new head is at position length - k.
    int stepsToNewHead = length - k;

    Node newTail = head;
    for (int i = 1; i < stepsToNewHead; i++) {
      newTail = newTail.next;
    }
    Node newHead = newTail.next;
    newTail.next = null;
    return newHead;
  }

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {

    // Build a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    Node head = new Node(1);
    Node current = head;
    for (int i = 2; i <= 9; i++) {
      current.next = new Node(i);
      current = current.next;
    }

    // 4. Rotate Linked List Right by k = 2
    // Rebuild list.
    head = new Node(1);
    current = head;
    for (int i = 2; i <= 5; i++) {
      current.next = new Node(i);
      current = current.next;
    }
    System.out.println("Original List:");
    printList(head);
    Node rotatedRight = rotateRight(head, 2);
    System.out.println("After Right Rotation by 2:");
    printList(rotatedRight);
    // Expected Output (Right Rotate): 4 -> 5 -> 1 -> 2 -> 3
  }
}
