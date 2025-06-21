package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY.SORT_REARRANGE_PATTERN;

import StandardProblemDSA.Utility;

import java.util.Arrays;
/*You are given an integer array A. A Nobel Integer is an integer x such that the number of
integers strictly greater than x in the array is exactly equal to x.
Input: A = [3, 2, 1, 3]
Output: 1
Explanation:
- Number of elements greater than 2 = 2 → which is equal to 2 ⇒ Nobel integer found.
Sort the array A in ascending order.

So that all smaller elements appear before larger ones.

This helps us easily count how many elements are strictly greater than a given number using index position.

Iterate through the sorted array from left to right (from index 0 to n-2)
For each index i:

If A[i] == A[i+1]:

Skip to the next unique element to avoid false positives due to duplicates.

Else:

Let count = n - 1 - i → This is the number of elements strictly greater than A[i].

If count == A[i]:

✅ Found a Nobel Integer → return 1

Special Case:

If the last element is 0, and no previous Nobel integer was found, then:

It satisfies the condition: 0 elements greater than it == 0 ⇒ return 1.

If no such element found after complete iteration:

❌ Return -1
*/
public class NobelInteger {
  public static int solve(int[] A) {
    int count = 0, i = 0, temp = 0, result = -1;
    int n = A.length;

    // Step1. iterate over the sorted array
    Utility.sortArrayWithArrySort(A);//1,2,3,3
    while (i + 1 < n) {
      // checking if the next element is equal to current element
      if (A[i] == A[i + 1]) {// if there is duplicate element present
        temp = i; // index of the current element for whom we trying to find greater than its and count of it else we go to next
        count = n - 1 - i;//his is the number of elements strictly greater than A[i].
        if (count == A[temp]) {
          result = 1;
        } else {
          i++;}
      } else if (A[i] != A[i + 1]) {// if distinct element present
        if (n - 1 - i == A[i]) {
          result = 1;
          break;
        } else {
          i++;}
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
