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
  /*Algorithm / Intuition
  Optimal Approach(Using Binary Search):
  We are going to use the Binary Search algorithm to optimize the approach.

  The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

  Upon closer observation, we can recognize that our answer space, represented as [max(arr[]), sum(arr[])], is actually sorted. Additionally, we can identify a pattern that allows us to divide this space into two halves: one consisting of potential answers and the other of non-viable options. So, we will apply binary search on the answer space.

  Algorithm:
  Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to max(arr[]) and the high will point to sum(arr[]).
  Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
  mid = (low+high) // 2 ( ‘//’ refers to integer division)
  Eliminate the halves based on the number of subarrays returned by countPartitions():
  We will pass the potential value of ‘maxSum’, represented by the variable 'mid', to the ‘countPartitions()' function. This function will return the number of partitions we can make.
  If partitions > k: On satisfying this condition, we can conclude that the number ‘mid’ is smaller than our answer. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
  Otherwise, the value mid is one of the possible answers. But we want the minimum value. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
  Finally, outside the loop, we will return the value of low as the pointer will be pointing to the answer.
  The steps from 3-4 will be inside a loop and the loop will continue until low crosses high.

  Note: Please make sure to refer to the video and try out some test cases of your own to understand, how the pointer ‘low’ will be always pointing to the answer in this case. This is also the reason we have not used any extra variable here to store the answer.*/

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
