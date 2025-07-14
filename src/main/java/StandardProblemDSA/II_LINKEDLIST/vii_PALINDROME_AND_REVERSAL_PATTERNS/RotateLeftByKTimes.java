package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.Node;

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
    if (head == null || head.next == null || k == 0) return head;

    // Step 1: Compute length and reach tail
    Node current = head;
    int length = 1;
    while (current.next != null) {
      current = current.next;
      length++;
    }

    // Step 2: Connect tail to head to form a circular list
    current.next = head;

    // Step 3: Normalize k
    k = k % length;
    if (k == 0) {
      current.next = null; // Break the loop
      return head;
    }

    // Step 4: Move to new tail
    Node newTail = head;
    for (int i = 1; i < k; i++) {
      newTail = newTail.next;
    }

    // Step 5: New head is next of new tail
    Node newHead = newTail.next;
    newTail.next = null; // Break the loop

    return newHead;
  }

  public static void main(String[] args) {

    // Build a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
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
    // Expected Output (Left Rotate): 3 -> 4 -> 5 -> 1 -> 2->null

  }
}
/*
class Solution {

  // Utility method to get length
  public static int length(ListNode head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) return head;

    // Step 1: Find length and last node
    int len = length(head);
    k = k % len;
    if (k == 0) return head;

    // Step 2: Make it a circular list
    ListNode tail = head;
    while (tail.next != null) {
      tail = tail.next;
    }
    tail.next = head; // circle

    // Step 3: Find new tail (len - k steps from head)
    int stepsToNewTail = len - k;
    ListNode newTail = head;
    for (int i = 1; i < stepsToNewTail; i++) {
      newTail = newTail.next;
    }

    // Step 4: Set new head and break the loop
    ListNode newHead = newTail.next;
    newTail.next = null;

    return newHead;
  }
}*/
