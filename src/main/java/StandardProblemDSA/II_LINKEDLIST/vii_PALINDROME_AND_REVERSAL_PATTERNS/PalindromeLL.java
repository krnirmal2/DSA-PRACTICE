package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

public class PalindromeLL {

  public static int isPalindrome(ListNode head) {
    if (head == null || head.next == null) return 1; // empty or single-node list is palindrome

    // Step 1: Find the middle using slow and fast pointers
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // Step 2: Split the list and reverse the second half
    ListNode secondHalfStart = slow.next;
    slow.next = null; // break the list into two halves

    ListNode prev = null;
    ListNode current = secondHalfStart;
    while (current != null) {
      ListNode nextTemp = current.next;
      current.next = prev;
      prev = current;
      current = nextTemp;
    }

    ListNode reversedSecondHalf = prev;

    // Step 3: Compare both halves node-by-node
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

  // Definition of singly linked list node
  static class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
