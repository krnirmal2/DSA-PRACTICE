package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

public class MinimumDaysToMakeMBouquets {
  /*Problem Statement: You are given 'N’ roses and you are also given an array 'arr'  where 'arr[i]'  denotes that the 'ith' rose will bloom on the 'arr[i]th' day.
  You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.
  Find the minimum number of days required to make at least ‘m' bouquets each containing 'k' roses. Return -1 if it is not possible.

  Examples

  Example 1:
  Input Format: N = 8, arr[] = {7, 7, 7, 7, 13, 11, 12, 7}, m = 2, k = 3
  Result: 12
  Explanation: On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, one with the first 3 and another with the last 3 flowers.

  Example 2:
  Input Format: N = 5, arr[] = {1, 10, 3, 10, 2}, m = 3, k = 2
  Result: -1
  Explanation: If we want to make 3 bouquets of 2 flowers each, we need at least 6 flowers. But we are given only 5 flowers, so, we cannot make the bouquets.


  Let's grasp the question better with the help of an example. Consider an array: {7, 7, 7, 7, 13, 11, 12, 7}. We aim to create bouquets with k, which is 3 adjacent flowers, and we need to make m, which is 2 such bouquets. Now, if we try to make bouquets on the 11th day, the first 4 flowers and the 6th and the last flowers would have bloomed. So, we will be having 6 flowers in total on the 11th day. However, we require two groups of 3 adjacent flowers each. Although we can form one group with the first 3 adjacent flowers, we cannot create a second group. Therefore, 11 is not the answer in this case.


  If we choose the 12th day, we can make 2 such groups, one with the first 3 adjacent flowers and the other with the last 3 adjacent flowers. Hence, we need a minimum of 12 days to make 2 bouquets.*/

  /*  Optimal Approach(Using Binary Search):
  We are going to use the Binary Search algorithm to optimize the approach.

  The primary objective of the Binary Search algorithm is to efficiently determine the appropriate half to eliminate, thereby reducing the search space by half. It does this by determining a specific condition that ensures that the target is not present in that half.

  Now, we are not given any sorted array on which we can apply binary search. But, if we observe closely, we can notice that our answer space i.e. [mini(arr[]), max(arr[])] is sorted. So, we will apply binary search on the answer space.

          Algorithm:
  If m*k > arr.size: This means we have insufficient flowers. So, it is impossible to make m bouquets and we will return -1.
  Next, we will find the maximum element i.e. max(arr[]), and the minimum element i.e. min(arr[]) in the array.
  Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to min(arr[]) and the high will point to max(arr[]).
  Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
  mid = (low+high) // 2 ( ‘//’ refers to integer division)
  Eliminate the halves based on the value returned by possible():
  We will pass the potential answer, represented by the variable 'mid' (which corresponds to a specific day), to the 'possible()' function.
          If possible() returns true: On satisfying this condition, we can conclude that the number ‘mid’ is one of our possible answers. But we want the minimum number. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
  Otherwise, the value mid is smaller than the number we want. This means the numbers greater than ‘mid’ should be considered and the right half of ‘mid’ consists of such numbers. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
  Finally, outside the loop, we will return the value of low as the pointer will be pointing to the answer.
  The steps from 3-5 will be inside a loop and the loop will continue until low crosses high.

  Note: Please make sure to refer to the video and try out some test cases of your own to understand, how the pointer ‘low’ will be always pointing to the answer in this case. This is also the reason we have not used any extra variable here to store the answer.*/
  public class tUf {
    public static boolean possible(int[] arr, int day, int m, int k) {
      int n = arr.length; // Size of the array
      int cnt = 0;
      int noOfB = 0;
      // Count the number of bouquets:
      for (int i = 0; i < n; i++) {
        if (arr[i] <= day) {
          cnt++;
        } else {
          noOfB += (cnt / k);
          cnt = 0;
        }
      }
      noOfB += (cnt / k);
      return noOfB >= m;
    }

    public static int roseGarden(int[] arr, int k, int m) {
      long val = (long) m * k;
      int n = arr.length; // Size of the array
      if (val > n) return -1; // Impossible case.
      // Find maximum and minimum:
      int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        mini = Math.min(mini, arr[i]);
        maxi = Math.max(maxi, arr[i]);
      }

      // Apply binary search:
      int low = mini, high = maxi;
      while (low <= high) {
        int mid = (low + high) / 2;
        if (possible(arr, mid, m, k)) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      return low;
    }

    /* Complexity Analysis

    Time Complexity: O(log(max(arr[])-min(arr[])+1) * N), where {max(arr[]) -> maximum element of the array, min(arr[]) -> minimum element of the array, N = size of the array}.
    Reason: We are applying binary search on our answers that are in the range of [min(arr[]), max(arr[])]. For every possible answer ‘mid’, we will call the possible() function. Inside the possible() function, we are traversing the entire array, which results in O(N).

    Space Complexity: O(1) as we are not using any extra space to solve this problem.*/
    public static void main(String[] args) {
      int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
      int k = 3;
      int m = 2;
      int ans = roseGarden(arr, k, m);
      if (ans == -1) System.out.println("We cannot make m bouquets.");
      else System.out.println("We can make bouquets on day " + ans);
    }
  }
}
