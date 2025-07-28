package StandardProblemDSA.II_LINKEDLIST.vii_PALINDROME_AND_REVERSAL_PATTERNS;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

/*
Problem: Check if a Linked List is a Palindrome
------------------------------------------------
Given the head of a singly linked list, determine whether the list reads the same forwards and backwards.

Approach:
---------
1. **Edge Case**:
   - If the list is empty or has only one node → it's trivially a palindrome.

2. **Find the Middle**:
   - Use slow and fast pointers to locate the middle node of the list.

3. **Reverse the Second Half**:
   - Split the list into two halves at the middle.
   - Reverse the second half in-place.

4. **Compare Both Halves**:
   - Traverse both halves node by node.
   - If any mismatch occurs, return `0` (not a palindrome).

5. **Return Result**:
   - If traversal completes without mismatches, return `1` (palindrome).

Time Complexity: O(n) — single traversal to find middle, reverse, and compare.
Space Complexity: O(1) — in-place reversal, no extra storage.

Example:
--------
Input:  1 → 2 → 3 → 2 → 1
Output: 1 (Palindrome)

Follow-up:
-----------
- Optionally restore the original list by reversing the second half back.
- LeetCode Reference: **LeetCode 234** (Palindrome Linked List)
*/

public class PalindromeLL {
  // Creating test case: 1 → 2 → 3 → 4 → 3 → 2 → 1
  public static int isPalindrome(ListNode head) {
    if (head == null || head.next == null) return 1; // empty or single-node list is palindrome
    if (Utility_linkedList.lengthOfListNode(head) == 2) {
      if (head.val == head.next.val) return 1;
      else return 0;
    }
      // step 1 : find middle of the list
    ListNode middle = Utility_linkedList.findMiddle(head);
    // Step 2: Split the list and reverse the second half
    ListNode reversedSecondHalf = Utility_linkedList.reverseList(middle);
    //    ListNode secondHalfStart = middle.next;
    middle.next = null; // break the list into two halves

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
    //    ListNode three = new ListNode(3);
    //    ListNode four = new ListNode(4);
    //    ListNode five = new ListNode(3);
    //    ListNode six = new ListNode(2);
    //    ListNode seven = new ListNode(1);

    one.next = two;
    //    two.next = three;
    //    three.next = four;
    //    four.next = five;
    //    five.next = six;
    //    six.next = seven;

    System.out.println("Is Palindrome? " + isPalindrome(one)); // Output: 1
  }
}
