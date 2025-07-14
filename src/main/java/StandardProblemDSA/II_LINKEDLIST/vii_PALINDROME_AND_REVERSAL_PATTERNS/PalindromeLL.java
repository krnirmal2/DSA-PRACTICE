package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

public class PalindromeLL {
  // Creating test case: 1 → 2 → 3 → 4 → 3 → 2 → 1
  public static int isPalindrome(ListNode head) {
    if (head == null || head.next == null) return 1; // empty or single-node list is palindrome
    // step 1 : find middle of the list
    ListNode middle = Utility_linkedList.findMiddle(head);

    // Step 2: Split the list and reverse the second half
    ListNode secondHalfStart = middle.next;
    middle.next = null; // break the list into two halves

    // Step 3: reverese the second half using secondHalfStart as head node
    ListNode reversedSecondHalf = Utility_linkedList.reverseList(secondHalfStart);
    // reversedSecondHalf is the head node after reverse now

    // Step 4: Compare both halves list become two list and compare node-by-node
    ListNode firstHalfPointer = head;
    ListNode secondHalfPointer = reversedSecondHalf;

    while (firstHalfPointer != null && secondHalfPointer != null) {
      if (firstHalfPointer.val != secondHalfPointer.val) {
        return 0; // not a palindrome
      }
      firstHalfPointer = firstHalfPointer.next;
      secondHalfPointer = secondHalfPointer.next;
    }

    return 1; // list is a palindrome
  }

  public static void main(String[] args) {
    // Creating test case: 1 → 2 → 3 → 4 → 3 → 2 → 1
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(3);
    ListNode six = new ListNode(2);
    ListNode seven = new ListNode(1);

    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;
    five.next = six;
    six.next = seven;

    System.out.println("Is Palindrome? " + isPalindrome(one)); // Output: 1
  }
}
