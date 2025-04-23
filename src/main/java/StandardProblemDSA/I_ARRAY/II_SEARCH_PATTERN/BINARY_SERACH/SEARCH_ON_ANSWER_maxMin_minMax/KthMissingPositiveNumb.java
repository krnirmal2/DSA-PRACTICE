package StandardProblemDSA.I_ARRAY.II_SEARCH_PATTERN.BINARY_SERACH.SEARCH_ON_ANSWER_maxMin_minMax;

public class KthMissingPositiveNumb {

  /*
  Problem Statement: You are given a strictly increasing array ‘vec’ and a positive integer 'k'. Find the 'kth' positive integer missing from 'vec'.

  Examples

  Example 1:
  Input Format: vec[]={4,7,9,10}, k = 1
  Result: 1
  Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 1, the first missing element is 1.
  Example 2:
  Input Format: vec[]={4,7,9,10}, k = 4
  Result: 5
  Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 4, the fourth missing element is 5.

  Disclaimer: Don’t jump directly to the solution, try it out yourself first.

  Brute Force Approach
  Algorithm / Intuition
  Naive Approach:
  There might be many brute-force approaches to solve this problem. But we are going to use the following simple steps to solve the problem.

  Algorithm:
  We will use a loop to traverse the array.
  Inside the loop,
  If vec[i] <= k: we will simply increase the value of k by 1.
  Otherwise, we will break out of the loop.
  Finally, we will return the value of k.
  Note: The main idea is to shift k by 1 step if the current element is smaller or equal to k. And whenever we get a number > k, we can conclude that k is the missing number.

          Dry-run: Please refer to the video for the dry-run.*/

  public class tUf {
    public static int missingK(int[] vec, int n, int k) {
      for (int i = 0; i < n; i++) {
        if (vec[i] <= k) k++; // shifting k
        else break;
      }
      return k;
    }

    public static void main(String[] args) {
      int[] vec = {4, 7, 9, 10};
      int n = 4, k = 4;
      int ans = missingK(vec, n, k);
      System.out.println("The missing number is: " + ans);
    }
  }

  /*   Basically you are finding if the number-(index+1) is is greater than k
      or not and number-(index+1) indicates how many missing element
      we have in the left. If it's less than k then we move forward and
          if we get greater than or equal to k then we move back. If we
      cross the pointers i.e low>high there it gets terminated and the index
      low points to that index which has missing elements greater than or equal
      to k in left. Atlast we just add k with the low pointer and that's our
      missing kth positive number.
  */
  public int findKthPositive(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] - (mid + 1) >= k) high = mid - 1;
      else low = mid + 1;
    }
    return low + k;
  }
}
