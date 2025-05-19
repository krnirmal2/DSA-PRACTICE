package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class RotateLeftByKTimes {
  // ---------------------------------------------------
  // 3. Rotate Linked List Left/Right by K
  // ---------------------------------------------------
  /*
    Problem Statement:
       Given the head of a linked list and an integer k, rotate the list to the left or right by k positions.

    Brute Force Idea:
       - Repeatedly remove one node from the beginning (or end) and append it to the other side.
       - Time Complexity: O(n*k)

    Optimal Approach:
       - Compute the length of the list.
       - Connect the list into a circle.
       - Compute the effective rotations needed (k modulo length).
       - Break the circle to form the new list.
       - For left rotation, move (k % length) nodes; for right rotation, move (length - (k % length)) nodes.
       - Time Complexity: O(n)

    Example:
       Left Rotation:
         Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2
         Output: 3 -> 4 -> 5 -> 1 -> 2
       Right Rotation:
         Input: 1 -> 2 -> 3 -> 4 -> 5, k = 2
         Output: 4 -> 5 -> 1 -> 2 -> 3
  */
  public static Node rotateLeft(Node head, int k) {
    if (head == null || k == 0) return head;

    // Compute length and get tail.
    Node current = head;
    int length = Utility_linkedList.length(head);
    // Connect tail to head to form a circle.
    current.next = head;

    // Effective rotations.
    k = k % length;
    int stepsToNewHead = k; // for left rotation

    // Find the new tail: (stepsToNewHead - 1) steps from head.
    Node newTail = head;
    for (int i = 1; i < stepsToNewHead; i++) {
      newTail = newTail.next;
    }

    // New head is next of newTail.
    Node newHead = newTail.next;
    // Break the circle.
    newTail.next = null;
    return newHead;
  }

  public static void main(String[] args) {

    // Build a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    Node head = new Node(1);
    Node current = head;
    for (int i = 2; i <= 9; i++) {
      current.next = new Node(i);
      current = current.next;
    }

    // 3. Rotate Linked List Left by k = 2
    // Rebuild list.
    head = new Node(1);
    current = head;
    for (int i = 2; i <= 5; i++) {
      current.next = new Node(i);
      current = current.next;
    }
    System.out.println("Original List:");
    printList(head);
    Node rotatedLeft = rotateLeft(head, 2);
    System.out.println("After Left Rotation by 2:");
    printList(rotatedLeft);
    // Expected Output (Left Rotate): 3 -> 4 -> 5 -> 1 -> 2

  }
}
