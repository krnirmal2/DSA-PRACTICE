package StandardProblemDSA.II_LINKEDLIST.vi_MERGING_AND_SPLITTING_LL;

import StandardProblemDSA.II_LINKEDLIST.ListNode;
import StandardProblemDSA.II_LINKEDLIST.Utility_linkedList;

/*
Problem: Intersection of Two Singly Linked Lists
------------------------------------------------
Problem Statement:
Given the heads of two singly linked lists, return the node at which the two lists intersect.
If they do not intersect, return null.
Note: Intersection is determined by **reference**, not value.

Approach:
---------
1. **Find Lengths**:
   - Calculate lengths `lengthA` and `lengthB` of both lists.

2. **Align Pointers**:
   - Compute difference `|lengthA - lengthB|`.
   - Advance the head of the longer list by the difference so both pointers have equal nodes to traverse.

3. **Traverse Together**:
   - Move both heads one step at a time.
   - If `headA == headB` at any point, this is the intersection node.

4. **Return Null if No Intersection**:
   - If both lists reach the end with no match, return `null`.

Time Complexity: **O(n + m)** — traverse both lists once.
Space Complexity: **O(1)** — constant extra space.

Example:
--------
List A: 1 → 2 → 3 ↘
                    7 → 8
List B:       4 → 5 ↗

Output: Node with value 7 (intersection by reference)

Follow-ups:
-----------
- Alternative approach: Use two pointers switching heads (LeetCode 160).
- Detect if intersection forms a cycle — combine with Floyd's cycle detection.
- LeetCode Variant: Check if two lists overlap (Cracking the Coding Interview 2.7).
*/

public class IntersectionOfTwoLinkedLists {
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lengthA = Utility_linkedList.lengthOfListNode(headA);
    int lengthB = Utility_linkedList.lengthOfListNode(headB);
    int diffA = 0;
    int diffB = 0;
    // Step1: find the difference of the length of them
    if (lengthA > lengthB) {
      diffA = lengthA - lengthB;
    } else {
      diffB = lengthB - lengthA;
    }
    // Step 2: if any one is not 0 means there is difference between them
    // hence which ever the list i have to skip that many nodes for
    // equal two pointer
    if (diffA != 0 || diffB != 0) {

      while (diffA > 0) {
        headA = headA.next;
        diffA--;
      }
      while (diffB > 0) {
        headB = headB.next;
        diffB--;
      }
    }
    // step 3: check the node itself if they are equal
    // means got the intersection not by only value
    while (headA != null && headB != null) {
      if (headA == headB) {
        return headA;
      }
      headA = headA.next;
      headB = headB.next;
    }
    return null;
  }

  public static void main(String[] args) {
    int[] arrA = {4, 1, 8, 4, 5};
    int[] arrB = {5, 6, 1, 8, 4, 5};

    //        ListNode listA = Utility_linkedList.buildListNode(arrA);
    //        ListNode listB = Utility_linkedList. buildListNode(arrB);
    // Shared nodes (intersection)
    ListNode intersect = new ListNode(8);
    intersect.next = new ListNode(4);
    intersect.next.next = new ListNode(5);

    // List A: 4 → 1 → [8 → 4 → 5]
    ListNode headA = new ListNode(4);
    headA.next = new ListNode(1);
    headA.next.next = intersect;

    // List B: 5 → 6 → 1 → [8 → 4 → 5]
    ListNode headB = new ListNode(5);
    headB.next = new ListNode(6);
    headB.next.next = new ListNode(1);
    headB.next.next.next = intersect;

    ListNode result = getIntersectionNode(headA, headB);

    if (result != null) {
      System.out.println("Intersection at node with value: " + result.val);
    } else {
      System.out.println("No intersection found.");
    }
  }
}
