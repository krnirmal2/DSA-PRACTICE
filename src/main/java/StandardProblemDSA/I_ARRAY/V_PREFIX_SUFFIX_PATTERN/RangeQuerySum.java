package StandardProblemDSA.I_ARRAY.V_PREFIX_SUFFIX_PATTERN;

import StandardProblemDSA.Utility;

/*
Question:
Given an integer array A and a list of queries B (each query consists of a pair [L, R]),
find the sum of elements from index L to R for each query.

Example:
Input:
A = [7, 3, 1, 5, 5, 5, 1, 2, 4, 5]
B = [[7, 10], [3, 10], [3, 5], [1, 10]]
Output:
[11, 27, 11, 38]

Explanation:
- Query [7, 10]: sum = A[7] + A[8] + A[9] + A[10] = 11
- Query [3, 10]: sum = A[3] + ... + A[10] = 27
- Query [3, 5]: sum = A[3] + A[4] + A[5] = 11
- Query [1, 10]: sum = A[1] + ... + A[10] = 38

Approach:
1. Precompute the prefix sum array:
   - prefixSum[i] = A[0] + A[1] + ... + A[i].
2. For each query [L, R]:
   - sum = prefixSum[R] - prefixSum[L - 1] (handle L = 0 separately).
3. Return an array of sums for all queries.

Pattern:
- Prefix Sum Pattern for range queries.
- Efficiently handles multiple range sum queries.

Time Complexity:
- O(N) to build the prefix sum array.
- O(Q) to answer Q queries.
Space Complexity:
- O(N) for prefix sum storage.

Follow-up Questions:
1. Can you handle updates to the array (turning it into a Range Sum Query with updates problem)?
2. How to handle 2D range queries (submatrices)?
3. Can you solve it for a streaming array where queries arrive online?
4. What if indices are 1-based instead of 0-based?
5. How to optimize for very large arrays and many queries (Segment Tree or Fenwick Tree)?

Similar LeetCode/Interview Questions:
- LeetCode 303. Range Sum Query - Immutable
- LeetCode 304. Range Sum Query 2D - Immutable
- LeetCode 307. Range Sum Query - Mutable (Fenwick Tree/Segment Tree)
*/

public class RangeQuerySum {
  public static void main(String[] args) {
    int[] A = {7, 3, 1, 5, 5, 5, 1, 2, 4, 5};
    int[][] B = {{7, 10}, {3, 10}, {3, 5}, {1, 10}};
    int[] result = rangeQuerySum(A, B);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }

  private static int[] rangeQuerySum(int[] a, int[][] b) {
    int size = a.length;
    int[] result = new int[100];
    int sum = a[0];
    int[] prefixSum = new int[size];
    // find the prefix sum of the given aray a
    Utility.prefixSum(a, prefixSum);
    for (int j = 0, k = 1; j < b[0].length; j++) {
      int leftIndex, rightIndex;
      leftIndex = b[j][0];
      rightIndex = b[j][1];
      if (leftIndex >= 0 && rightIndex < a.length) {
        result[j] = prefixSum[rightIndex] - prefixSum[leftIndex - 1];
      }
    }
    return result;
  }
}

// public class Solution {
//    public long[] rangeSum(int[] A, int[][] B) {
//        int n = A.length;
//        int M = B.length;
//        long [] PS = new long[n];
//        PS[0] = A[0];
//        for(int i =1;i<n;i++){
//            PS[i] = PS[i-1] + A[i];
//        }
//        long [] ans = new long[M];
//        for(int i = 0;i<M;i++){
//            int l = B[i][0];
//            int r = B[i][1];
//            if(l==1){
//                ans[i] = PS[r-1];
//            }
//            else{
//                ans[i] = PS[r-1]-PS[l-2];
//            }
//        }
//        return ans;
//    }
// }
