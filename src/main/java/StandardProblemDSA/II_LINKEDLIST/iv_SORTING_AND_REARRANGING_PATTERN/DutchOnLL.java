package StandardProblemDSA.II_LINKEDLIST.iv_SORTING_AND_REARRANGING_PATTERN;

public class DutchOnLL {
  /*
  Problem: Sort a Linked List of 0's, 1's, and 2's (Dutch National Flag on Linked List)
  -------------------------------------------------------------------------------------
  Problem Statement:
  Given the head of a singly linked list consisting of only values 0, 1, and 2,
  sort the list in-place and return the head of the modified list.

  Constraints:
  - 0 <= number of nodes <= 10^5
  - Node values are only 0, 1, or 2

  Approach: **Dutch National Flag algorithm using 3 dummy nodes**
  ---------------------------------------------------------------
  1. **Idea**:
     - We can use three dummy nodes to build three separate lists:
       one for 0's, one for 1's, and one for 2's.
     - Then we concatenate the three lists in order: 0's -> 1's -> 2's.

  2. **Steps**:
     - Create three dummy nodes: `zeroD`, `oneD`, `twoD`.
     - Maintain three pointers: `zero`, `one`, `two` to track the tails of respective lists.
     - Traverse the original list:
       - Append each node to the corresponding list (based on its value).
     - After traversal, concatenate:
       - `zero.next = oneD.next` (or `twoD.next` if 1's list is empty)
       - `one.next = twoD.next`
       - `two.next = null`
     - Return `zeroD.next` as the head of the new list.

  3. **Time Complexity**: O(n), where n = number of nodes
  4. **Space Complexity**: O(1), constant extra space (no new nodes)

  Example:
  Input:  head → 1 → 0 → 2 → 0 → 1
  Output: head → 0 → 0 → 1 → 1 → 2

  Follow-Up:
  - Can also be solved by counting number of 0s, 1s, and 2s and rewriting the values (if node values can be modified).
  - This problem is analogous to "Sort Colors" (Dutch National Flag Problem) from arrays.

  LeetCode:
  - Related: [Sort Colors](https://leetcode.com/problems/sort-colors/) (LC 75) — similar logic applied on arrays
  - Custom implementation needed for linked list version
  */
}
