package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import static StandardProblemDSA.II_LINKEDLIST.Utility_linkedList.printList;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

public class RotateRightLLByKTimes {

  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) return head;

    // Compute length and get tail.
    ListNode current = head;
    int length = 1;
    while (current.next != null) {
      current = current.next;
      length++;
    }
    // Connect tail to head.
    current.next = head;

    // Effective rotations.
    k = k % length;
    // For right rotation, new head is at position length - k.
    int stepsToNewHead = length - k;

    ListNode newTail = head;
    for (int i = 1; i < stepsToNewHead; i++) {
      newTail = newTail.next;
    }
    ListNode newHead = newTail.next;
    newTail.next = null;
    return newHead;
  }

  // ---------------------------------------------------
  // Main method for demonstration of functionalities.
  // ---------------------------------------------------
  public static void main(String[] args) {

    // Build a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
    ListNode head = new ListNode(1);
    ListNode current = head;
    for (int i = 2; i <= 9; i++) {
      current.next = new ListNode(i);
      current = current.next;
    }

    // 4. Rotate Linked List Right by k = 2
    // Rebuild list.
    head = new ListNode(1);
    current = head;
    for (int i = 2; i <= 5; i++) {
      current.next = new ListNode(i);
      current = current.next;
    }
    System.out.println("Original List:");
    printList(head);
    ListNode rotatedRight = rotateRight(head, 2);
    System.out.println("After Right Rotation by 2:");
    printList(rotatedRight);
    // Expected Output (Right Rotate): 4 -> 5 -> 1 -> 2 -> 3
  }
}
