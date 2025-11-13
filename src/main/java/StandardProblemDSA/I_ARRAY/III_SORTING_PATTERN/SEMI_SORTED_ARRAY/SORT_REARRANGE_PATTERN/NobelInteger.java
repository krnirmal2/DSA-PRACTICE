package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import StandardProblemDSA.Utility;

/*
Question:
You are given an integer array A. A "Noble Integer" is an integer x such that the number of integers
strictly greater than x in the array is exactly equal to x.
Return 1 if a Noble Integer exists, otherwise return -1.

Example:
Input: A = [3, 2, 1, 3]
Output: 1
Explanation:
- After sorting: [1, 2, 3, 3]
- For A[1] = 2 → count of elements greater than 2 = 2 → matches A[1].
- So 2 is a Noble Integer.

Approach:
1. Sort the array in ascending order.
2. Iterate through the sorted array:
   - For each element A[i], compute the number of elements strictly greater than it: count = n - 1 - i.
   - Skip duplicates by checking if A[i] == A[i+1].
   - If count equals A[i], return 1.
3. Special case: If the last element is 0, return 1 (since no elements are greater than it).
4. If no Noble Integer is found, return -1.

Pattern:
- Sorting + Counting Pattern.
- Uses array indexing to determine the count of greater elements efficiently.
- Based on properties of sorted arrays.

Time Complexity:
- Sorting: O(n log n)
- Iteration: O(n)
- Overall: O(n log n)
Space Complexity: O(1) (in-place sort).

Follow-up Questions:
1. Can we solve this without sorting (O(n)) using a hash map or frequency array?
2. What if there are negative numbers in the array? (still works)
3. Can there be more than one Noble Integer? Should we return all of them?
4. How to handle very large arrays efficiently?
5. Can we solve this if the array is already sorted?

Similar LeetCode/Interview Questions:
- Noble Integer (InterviewBit)
- LeetCode 75. Sort Colors (sorting pattern)
- LeetCode 274. H-Index (similar "count >= value" property)
*/

public class NobelInteger {
  public static int solve(int[] A) {
    int count = 0, i = 0, temp = 0, result = -1;
    int n = A.length;

    // Step1. iterate over the sorted array
    Utility.sortArrayWithArrySort(A); // 1,2,3,3
    while (i + 1 < n) {
      // checking if the next element is equal to current element
      if (A[i] == A[i + 1]) { // if there is duplicate element present
        temp =
            i; // index of the current element for whom we trying to find greater than its and count
        // of it else we go to next
        count = n - 1 - i; // his is the number of elements strictly greater than A[i].
        if (count == A[temp]) {
          result = 1;
        } else {
          i++;
        }
      } else if (A[i] != A[i + 1]) { // if distinct element present
        if (n - 1 - i == A[i]) {
          result = 1;
          break;
        } else {
          i++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = {3, 2, 1, 3};
    //        solve(a);
    System.out.println(solve(a));
  }
}
