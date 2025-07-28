package StandardProblemDSA.I_ARRAY.III_SORTING_PATTERN.SEMI_SORTED_ARRAY;

import StandardProblemDSA.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Question:
Given an integer array A, rearrange it to form the lexicographically next greater permutation.
If such arrangement is not possible, rearrange it into the smallest possible order (sorted ascending).

Example:
Input: A = [1, 2, 3]
Output: [1, 3, 2]
Explanation:
- Next lexicographical permutation after [1,2,3] is [1,3,2].

Input: A = [3, 2, 1]
Output: [1, 2, 3]
Explanation:
- [3,2,1] is the highest permutation, so return the lowest one.

Approach:
1. Find the first index `breakInd` from the right where A[breakInd] < A[breakInd + 1].
   - This identifies the "pivot" where the ascending order breaks.
2. If no such index exists, the array is in descending order → reverse it to get the smallest permutation.
3. Otherwise, find the smallest number larger than A[breakInd] to the right of it and swap them.
4. Reverse the subarray to the right of `breakInd` to get the next smallest lexicographical order.

Pattern:
- Array Rearrangement Pattern.
- Works on properties of permutations and lexicographic ordering.

Time Complexity:
- O(n), as we scan the array a few times.
Space Complexity:
- O(1), in-place rearrangement.

Follow-up Questions:
1. Can you implement the same logic for strings (next lexicographical string)?
2. How do you find the previous permutation?
3. How to handle arrays with duplicate elements?
4. Can we find the kth next permutation efficiently?
5. Is there a direct mathematical way to jump to any kth permutation?

Similar LeetCode Questions:
- LeetCode 31. Next Permutation
- LeetCode 556. Next Greater Element III
- LeetCode 60. Permutation Sequence
*/

public class NextPermutation {
  /*next_permutation : find next lexicographically greater permutation
  Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
  If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).*/

  // find the next permutation based on lexicographical order for integer here
  public static List<Integer> nextGreaterPermutation(List<Integer> A) {
    int n = A.size();
    List<Integer> result = new ArrayList<Integer>();
    int breakInd = -1;
    // if we need to use two utility method reverse and swap method
    //        step1 : Need to find out the index from the backend where the breaking is happedn
    for (int ind = n - 2; ind >= 0; ind--) {
      if (A.get(ind) < A.get(ind + 1)) {
        breakInd = ind;
        // now break the loop
        break;
      }
    }
    // if we don't find any break index than we are sure that this array already sorted with
    // decrement order
    if (breakInd == -1) {
      Utility.reverseList(A, 0, n - 1);
      return A;
    }
    // step 2 : we have to find the element from the back of the array which is just greate than
    // braek index value
    for (int ind = n - 1; ind >= 0; ind--) {
      if (A.get(breakInd) < A.get(ind)) {
        //                 if we got just swap breakInd and currIndex
        Collections.swap(A, breakInd, ind);
        break;
      }
    }
    // step 3. now we have to check the right subarray element should be just greateer than current
    // element
    // so we will reverse that array
    Utility.reverseList(A, breakInd + 1, n - 1);
    return A;
  }

  public static void main(String[] args) {
    List<Integer> A = Arrays.asList(2, 1, 5, 4, 3, 0, 0);
    List<Integer> ans = nextGreaterPermutation(A);

    System.out.print("The next permutation is: [");
    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }
    System.out.println("]");
  }
}
