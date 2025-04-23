package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.XII_LIS_PATTERN;

import java.util.*;

public class PrintLIS {
  /*In order to print the LIS, we maintain a separate array along with a dp array (say hash).
  Whenever we update our dp[i] value in the inner loop, we know that for index i, the previous index is prev_index.
  Therefore we simply store prev_index to hash[ i ]. In this way, we will have a way to trace back the LIS.
  Whenever we have computed the entire dp array and we find the maximum value in it. We store that maximum value’s index in a variable ( say last_index). Now with this last_index, and the hash array we can trace back the LIS elements.*/

  public class LIS {

    static int longestIncreasingSubsequence(int arr[], int n) {
      int[] dp = new int[n];
      Arrays.fill(dp, 1);

      int[] hash = new int[n];
      for (int i = 0; i < n; i++) hash[i] = i; // Initially, every element is parent of itself

      // Build the dp and hash array
      for (int i = 0; i < n; i++) {
        for (int prev_index = 0; prev_index < i; prev_index++) {
          if (arr[prev_index] < arr[i] && dp[prev_index] + 1 > dp[i]) {
            dp[i] = dp[prev_index] + 1;
            hash[i] = prev_index; // Store previous index for backtracking
          }
        }
      }

      // Find the index of maximum value in dp
      int ans = -1, lastIndex = -1;
      for (int i = 0; i < n; i++) {
        if (dp[i] > ans) {
          ans = dp[i];
          lastIndex = i;
        }
      }

      // Reconstruct the sequence
      ArrayList<Integer> temp = new ArrayList<>();
      temp.add(arr[lastIndex]);
      while (hash[lastIndex] != lastIndex) {
        lastIndex = hash[lastIndex];
        temp.add(arr[lastIndex]);
      }

      // Reverse the sequence to get correct order
      Collections.reverse(temp);
      System.out.print("The subsequence elements are: ");
      for (int num : temp) {
        System.out.print(num + " ");
      }
      System.out.println();

      return ans;
    }

    public static void main(String args[]) {
      int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};
      int n = arr.length;
      int len = longestIncreasingSubsequence(arr, n);
      System.out.println("Length of LIS is: " + len);
    }
  }
  /*🧠 Dry Run on arr = {10, 9, 2, 5, 3, 7, 101, 18}
  DP Table (dp):

          i arr[i] LISendingati	dp[i]
          0	10	[10]	1
          1	9	[9]	1
          2	2	[2]	1
          3	5	[2, 5]	2
          4	3	[2, 3]	2
          5	7	[2, 3, 7]	3
          6	101	[2, 3, 7, 101]	4
          7	18	[2, 3, 7, 18]	4
  Output:
  text
          Copy
  Edit
  The subsequence elements are: 2 3 7 101
  Length of LIS is: 4
          ✅ Time & Space Complexity
  Time Complexity: O(N^2)

  Space Complexity: O(N) for dp[] and hash[]*/
}

class LIS_Optimized {
  /*✅ Approach: Patience Sorting (Greedy + Binary Search)
  We maintain a list tail:
  It stores the smallest possible tail of an increasing subsequence of length i + 1 at index i.
  Use binarySearch to find the first element greater than or equal to the current number.

  This version does not reconstruct the actual subsequence, but gives the length of the LIS efficiently*/
  public static int lengthOfLIS(int[] nums) {
    List<Integer> tail = new ArrayList<>();

    for (int num : nums) {
      int idx = Collections.binarySearch(tail, num);

      if (idx < 0) idx = -idx - 1;

      if (idx == tail.size()) {
        tail.add(num);
      } else {
        tail.set(idx, num);
      }
    }

    return tail.size(); // Length of the longest increasing subsequence
  }

  public static void main(String[] args) {
    int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
    int length = lengthOfLIS(arr);
    System.out.println("Length of LIS is: " + length);
  }
  /*🔍 Dry Run (Step-by-step for arr = {10, 9, 2, 5, 3, 7, 101, 18})
  tail List Updates:

  10        → [10]
  9         → [9]
  2         → [2]
  5         → [2, 5]
  3         → [2, 3]
  7         → [2, 3, 7]
  101       → [2, 3, 7, 101]
  18        → [2, 3, 7, 18]   ← replaces 101
  ✅ Final tail.size() = 4

  ⏱️ Complexity
  Time: O(N log N) due to binary search for insertion.

  Space: O(N) for the tail list.*/
}
