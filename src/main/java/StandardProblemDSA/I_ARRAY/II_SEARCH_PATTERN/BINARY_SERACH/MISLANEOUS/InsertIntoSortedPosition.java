package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.MISLANEOUS; // package

/*
Problem Statement:
------------------
You are given a **sorted array** `A` of size `n` and a target value `B`.
You need to find the index of `B` in the array using **binary search**.
- If `B` exists, return its index.
- If it does not exist, return `-1`.

Example 1:
----------
Input: A = [1, 2, 3, 5, 6, 7, 9], B = 5
Output: 3
Explanation: Element 5 is found at index 3.

Example 2:
----------
Input: A = [1, 2, 3, 5, 6, 7, 9], B = 4
Output: -1
Explanation: Element 4 is not present in the array.

Constraints:
------------
- 1 <= n <= 10^5
- -10^9 <= A[i], B <= 10^9
- Array `A` is sorted in ascending order.

Pattern Used:
-------------
- **Binary Search Pattern**
    - Time Complexity: O(log N)
    - Space Complexity: O(log N) due to recursive calls.

Follow-up Questions:
--------------------
1. Can you return the **insert position** if `B` is not found (like in LeetCode 35: Search Insert Position)?
2. Can you implement it iteratively to reduce space complexity to O(1)?
3. How would you handle duplicates (first or last occurrence)?
4. Can you adapt this for a rotated sorted array?
*/

public class InsertIntoSortedPosition {

  public static void main(String[] args) {
    int[] A = {1, 2, 3, 5, 6, 7, 9};
    int left = 0;
    int right = A.length - 1;

    System.out.println(solve(A, left, right, 4));
  }

  private static int solve(int[] A, int left, int right, int B) {
    if (left > right) return -1; // base case: not found

    int mid = (left + right) / 2;
    if (A[mid] == B) return mid;

    if (A[mid] > B) return solve(A, left, mid - 1, B);
    else return solve(A, mid + 1, right, B);
  }
  /*O(log N)
    Where N is the number of elements in array A.
    At each step, the array is divided in half (binary division).
    So the number of steps required to search an element in N elements is:
  )*/
}
