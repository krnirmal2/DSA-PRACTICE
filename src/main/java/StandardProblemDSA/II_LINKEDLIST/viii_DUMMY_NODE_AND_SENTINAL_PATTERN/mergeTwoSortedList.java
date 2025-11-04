package StandardProblemDSA.II_LINKEDLIST.viii_DUMMY_NODE_AND_SENTINAL_PATTERN;

import StandardProblemDSA.II_LINKEDLIST.Node;

public class mergeTwoSortedList {
  /*
  Problem: Merge Two Sorted Linked Lists
  --------------------------------------
  Given two sorted singly linked lists, merge them into one sorted linked list and return its head.

  Approach:
  ---------
  1. **Dummy Node + Tail Pointer**:
     - Use a dummy node to simplify edge cases.
     - Compare current nodes of both lists.
     - Append the smaller node to `tail.next`, advance that list pointer.
     - Move `tail` forward.
  2. **Attach Remaining Nodes**:
     - After one list is exhausted, append the remainder of the other list.

  Time Complexity:
  - `O(m + n)` where `m` and `n` are lengths of the two lists.

  Space Complexity:
  - `O(1)` (in-place, no extra structures).

  Example:
  --------
  Input:
    list1 = 1 → 3 → 5
    list2 = 2 → 4 → 6
  Output:
    1 → 2 → 3 → 4 → 5 → 6

  Follow-ups:
  ------------
  - Can we do it recursively? → Yes, using recursion for cleaner code.
  - LeetCode Reference: **LeetCode 21** (Merge Two Sorted Lists)
  */

  public static Node mergeTwoLists(Node list1, Node list2) {
    // Approach : 1. iterate over the two linked list with two pointer
    //   2. compare each pointer data and which pointer data will be less put it to result list
    // and increament both pointer
    // 3. if still data left in any list so we will take the that pointer and add to the result list
    // Dummy node to simplify edge cases
    Node dummy = new Node(-1);
    Node tail = dummy; // Tail pointer to build the new list

    // Merge lists using two-pointer approach
    while (list1 != null && list2 != null) {
      if (list1.data <= list2.data) {
        tail.next = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
      }
      tail = tail.next;
    }

    // If any Node are left in either list, attach them
    if (list1 != null) {
      tail.next = list1;
    } else if (list2 != null) {
      tail.next = list2;
    }

    return dummy.next; // Return the merged list (skip dummy node)
  }

  public static void main(String[] args) {
    mergeTwoSortedList solution = new mergeTwoSortedList();
    //
    //    Node list1 = new Node(1, new Node(3, new Node(5)));
    //    Node list2 = new Node(2, new Node(4, new Node(6)));
    //
    //    System.out.println("List 1:");
    //    printList(list1);
    //    System.out.println("List 2:");
    //    printList(list2);

    //    Node mergedList = mergeTwoSortedList.mergeTwoLists(list1, list2);

    System.out.println("Merged List:");
    //    printList(mergedList);
  }
}
