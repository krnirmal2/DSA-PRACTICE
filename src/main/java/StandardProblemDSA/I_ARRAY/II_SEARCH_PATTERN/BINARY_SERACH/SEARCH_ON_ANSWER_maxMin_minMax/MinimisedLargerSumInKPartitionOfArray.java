package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

public class MinimisedLargerSumInKPartitionOfArray {
  /*
  Example 1:
  Input Format: N = 5, a[] = {1,2,3,4,5}, k = 3
  Result: 6
  Explanation: There are many ways to split the array a[] into k consecutive subarrays. The best way to do this is to split the array a[] into [1, 2, 3], [4], and [5], where the largest sum among the three subarrays is only 6.

  Example 2:
  Input Format: N = 3, a[] = {3,5,1}, k = 3
  Result: 5
  Explanation: There is only one way to split the array a[] into 3 subarrays, i.e., [3], [5], and [1]. The largest sum among these subarrays is 5.
  Upon close observation, we can understand that this problem is similar to the problem: BS-18. Allocate Books or Book Allocation | Hard Binary Search. In that case, we had to allocate books to the students. But actually, we were dividing that given array based on the subarray sum. We will do the same in this case.
  Assume the given array is {10, 20, 30, 40} and k = 2. Now, we can split the array in the following ways:
  10 | 20, 30, 40  → Maximum subarray sum  = 90
  10, 20 | 30, 40  → Maximum subarray sum = 70
  10, 20, 30 | 40  → Maximum subarray sum = 60

  From the above allocations, we can clearly observe that in the last case, the maximum subarray sum is the minimum possible. So, 60 will be the answer.*/
  /*Key Observations:
  -----------------
  - The answer will always lie in the range:
      - Lower bound = max(a[]) (since at least one subarray will contain the largest single element)
      - Upper bound = sum(a[]) (when we take all elements in one subarray)
  - This is a **minimize the maximum** problem → classic case of **Binary Search on Answer**.

  Approach:
  ---------
  1. Initialize search space:
     - `low = max(a[])`
     - `high = sum(a[])`
  2. While `low <= high`:
     - `mid = (low + high) / 2`
     - Check if it's possible to split array into ≤ k subarrays with each subarray sum ≤ mid.
       - Use `countPartitions(a, mid)` to find required partitions.
     - If partitions > k → `mid` is too small (increase lower bound: `low = mid + 1`)
     - Else → `mid` is feasible, try minimizing further (`high = mid - 1`).
  3. After loop ends, `low` is the minimized largest subarray sum.

  Helper Function:
  ----------------
  `countPartitions(int[] a, int maxSum)`:
  - Greedily create partitions ensuring each partition sum ≤ maxSum.
  - Returns the number of partitions required.

  Pattern:
  --------
  - **Binary Search on Answer** (a.k.a. Search Space Reduction).
  - Problems where you need to minimize/maximize something and the search space is monotonic.

  Complexity:
  -----------
  - Time: O(N * log(sum of array)) → each binary search step does O(N) partition check.
  - Space: O(1)

  Related LeetCode Problems:
  --------------------------


  Follow-ups:
  -----------
  1. What if we want to **maximize the minimum subarray sum**? → Adjust condition.
  2. What if we allow **non-contiguous** partitions? → Different greedy/DP approach.*/

  public static int countPartitions(int[] a, int maxSum) {
    int n = a.length; // size of array.
    int partitions = 1;
    long subarraySum = 0;
    for (int i = 0; i < n; i++) {
      if (subarraySum + a[i] <= maxSum) {
        // insert element to current subarray
        subarraySum += a[i];
      } else {
        // insert element to next subarray
        partitions++;
        subarraySum = a[i];
      }
    }
    return partitions;
  }

  public static int largestSubarraySumMinimized(int[] a, int k) {
    int low = a[0];
    int high = 0;
    // find maximum and summation:
    for (int i = 0; i < a.length; i++) {
      low = Math.max(low, a[i]);
      high += a[i];
    }

    // Apply binary search:
    while (low <= high) {
      int mid = (low + high) / 2;
      int partitions = countPartitions(a, mid);
      if (partitions > k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    int[] a = {10, 20, 30, 40};
    int k = 2;
    int ans = largestSubarraySumMinimized(a, k);
    System.out.println("The answer is: " + ans);
  }
}
