/*
Problem Statement:
------------------
You are given two sorted arrays `a` and `b` of sizes n1 and n2.
Find the median of the two sorted arrays.
The overall run-time complexity should be O(log(min(n1, n2))).

Definitions:
- Median:
  - If the total number of elements (n1 + n2) is odd, the median is the middle element.
  - If even, it is the average of the two middle elements.

Example 1:
Input: a = [1, 4, 7, 10, 12], b = [2, 3, 6, 15]
Output: 6.0
Explanation: Combined sorted array = [1, 2, 3, 4, 6, 7, 10, 12, 15], median = 6.

Example 2:
Input: a = [1, 3], b = [2]
Output: 2.0
Explanation: Combined sorted array = [1, 2, 3], median = 2.

Approach:
---------
- Use **Binary Search** on the smaller array.
- Partition both arrays such that:
    - Left half of `a` + Left half of `b` = (n1 + n2 + 1) / 2
    - Ensure all elements in the left half ≤ all elements in the right half.
- Key idea:
    - Compare `l1` (max of left of `a`) and `r2` (min of right of `b`)
      and `l2` (max of left of `b`) and `r1` (min of right of `a`).
    - If partitions are valid: return median.
    - Else adjust binary search boundaries.

Pattern:
--------
- **Binary Search on Partition Index**
- Classic problem: Divide arrays into left and right halves.

Complexity:
-----------
- Time: O(log(min(n1, n2))) - binary search on smaller array
- Space: O(1)

Related LeetCode Problems:
--------------------------
- 4. Median of Two Sorted Arrays (Hard)

Follow-ups:
-----------
1. What if arrays are unsorted? → Need to sort first (O(n log n)).
2. What if arrays are streams (infinite)? → Use two heaps.
3. Can we find the kth element instead of the median? → Yes, generalize partition logic.

*/
