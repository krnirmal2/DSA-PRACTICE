package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.CountSubarrayExactlyKConstraint;

import java.util.ArrayList;

/*
Problem Statement:
Given an array `a` of positive integers and an integer `k`,
find the indices of the largest subarray (longest length) whose sum equals `k`.

Example:
Input: a = [1, 2, 1, 0, 1, 1, 0], k = 4
Output: [1, 2, 3, 4]
Explanation:
- Subarray [2, 1, 0, 1] has sum 4 and length 4, which is maximum.

---

Approach:
1. Use the sliding window technique since the array contains non-negative numbers.
2. Maintain `start`, `end` pointers and a running `sum`.
3. Expand the `end` pointer until `sum` ≥ `k`.
4. If `sum` == `k`, update the maximum window size and store indices.
5. If `sum` > `k`, shrink the window from `start` until `sum` ≤ `k`.
6. Continue until `end` reaches the end of the array.

---

Time Complexity:
- O(n): each element is added and removed at most once.

Space Complexity:
- O(n): for storing indices of the largest window.

Follow-up:
- How to handle negative numbers?
  (Sliding window fails; we would need prefix sums + HashMap.)
- How to find all windows with sum exactly `k`?

*/
class IndexOfLargestWindowForSumK {

  public static ArrayList<Integer> solve(ArrayList<Integer> a, int k) {
    int size = a.size();
    ArrayList<Integer> result = new ArrayList<>();

    Integer start = 0;
    Integer end = 0;
    int sum = 0;
    int maxWindow = 0;

    while (end < size) {
      sum += a.get(end);
      // Expand window by right
      if (sum < k) {
        end++;
      } else if (sum == k) {
        // if matched find the end and max window size
        maxWindow = Math.max(maxWindow, end - start + 1);
        end++;

      } else if (sum > k) {
        // Shrinking window if sum>k
        while (sum > 0) {
          sum -= a.get(start);
          start++;
        }
        if (sum == k) {
          maxWindow = Math.max(maxWindow, end - start + 1);
        }
        end++;
      }
    }

    for (int i = start; i < end; i++) {
      result.add(i);
    }

    return result;
  }

  /* public int longestSubarrayWithSumK(List<Integer> a, int k) {
      Map<Integer, Integer> prefixSumIndex = new HashMap<>();
      int sum = 0;
      int maxWindow = 0;

      for (int end = 0; end < a.size(); end++) {
        sum += a.get(end);

        // if sum is equal to k return the maxwindow lengthh
        if (sum == k) {
          maxWindow = Math.max(maxWindow, end + 1);
        }
        // if the sum is already exists then
        // get the index of start by reduce of the k from sum and
        // update the max window with end-start
        if (prefixSumIndex.containsKey(sum - k)) {
          int start = prefixSumIndex.get(sum - k);
          maxWindow = Math.max(maxWindow, end - start);
        }

        // Only store the first occurrence to maximize window length
        //put the current sum and its last index
        if (!prefixSumIndex.containsKey(sum)) {
          prefixSumIndex.put(sum, end);
        }
      }
      return maxWindow;
    }
  */
  public static void main(String[] args) {

    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> re = new ArrayList<>();
    a.add(1);
    a.add(2);
    a.add(-2);
    a.add(4);
    a.add(-4);
    re = solve(a, 0);
    for (int i = 0; i < re.size(); i++) {
      System.out.println(a.get(i));
    }
  }
}
