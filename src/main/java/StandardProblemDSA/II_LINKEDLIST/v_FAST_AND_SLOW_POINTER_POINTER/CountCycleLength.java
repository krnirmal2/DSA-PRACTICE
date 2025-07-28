package StandardProblemDSA.II_LINKEDLIST.v_FAST_AND_SLOW_POINTER_POINTER;

import StandardProblemDSA.II_LINKEDLIST.ListNode;

/*
Problem: Detect the Length of a Cycle in a Linked List
------------------------------------------------------
Problem Statement:
Given the head of a singly linked list, determine if the list contains a cycle.
If a cycle exists, return the length of the cycle. Otherwise, return 0.

Approach:
---------
1. **Cycle Detection (Floyd’s Tortoise and Hare Algorithm)**:
   - Use two pointers, `slow` and `fast`.
   - Move `slow` by 1 step and `fast` by 2 steps at a time.
   - If `slow` and `fast` meet, a cycle exists.

2. **Cycle Length Calculation**:
   - When `slow` and `fast` meet, fix one pointer at the meeting point.
   - Move another pointer around the cycle until it comes back to the meeting point.
   - Count the number of steps taken; this is the cycle length.

3. **Time Complexity**:
   - O(n) — Each pointer visits each node at most once.

4. **Space Complexity**:
   - O(1) — No extra data structures used.

Example:
--------
Input: 1 → 2 → 3 → 4 → 5 ↘
                     ↑----↙
Output: 3
Explanation: Cycle is 3 → 4 → 5 → 3 (length = 3).

Edge Cases:
-----------
- Empty list (`head = null`) → returns 0.
- List without a cycle → returns 0.
- List where the cycle starts at the head.

Follow-Up:
----------
- Can you detect the starting node of the cycle? (Yes, using Floyd's algorithm.)
- LeetCode 142: **Linked List Cycle II** — detect the node where the cycle begins.
*/

public class CountCycleLength {

  public class DetectCycleLength {

    public static int findCycleLength(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;

      // Step 1: Detect cycle using Floyd’s algorithm
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
          // Step 2: Calculate length of the cycle
          // slow at the meeting point
          // for calculating length , we can fix the meeting point
          // and another pointer will traverse till again reach this meeting
          // point gives us the length
          return countCycleLength(slow);
        }
      }
      return 0; // No cycle
    }

    private static int countCycleLength(ListNode meetingPoint) {

      int count = 1;
      ListNode current = meetingPoint.next; // this will traverse and again reach and
      // we will get count
      while (current != meetingPoint) {
        count++;
        current = current.next;
      }
      return count;
    }

    public void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = new ListNode(5);
      // Creating a cycle: Node 5 -> Node 3
      head.next.next.next.next.next = head.next.next;

      int cycleLength = findCycleLength(head);
      System.out.println("Cycle Length: " + cycleLength);
    }
  }
}
