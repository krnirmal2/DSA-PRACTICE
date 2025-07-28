package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN;

public class CountKOddNoWindowNiceSubarray {
  /*
  -----------------------------------------------------------------------------------
  📌 Question:
  -----------------------------------------------------------------------------------
  "Given an integer array `nums` and an integer `k`,
   return the number of **continuous subarrays** that contain exactly `k` odd numbers."

  Example 1:
  Input: nums = [1, 3, 2, 1, 1], k = 3
  Output: 2
  Explanation: The only subarrays with exactly 3 odd numbers are [3,2,1,1] and [1,2,1,1].

  Example 2:
  Input: nums = [2, 4, 6], k = 1
  Output: 0
  Explanation: There are no odd numbers in the array.

  Example 3:
  Input: nums = [2, 2, 2, 1, 2, 2, 1, 2, 2, 2], k = 2
  Output: 16

  -----------------------------------------------------------------------------------
  🧠 Pattern: Variable Size Sliding Window + Mathematical Trick
  -----------------------------------------------------------------------------------
  - We want **exactly k** odd numbers in a window.
  - **Trick**:
    - #subarrays with exactly k =
      (#subarrays with at most k) – (#subarrays with at most k-1)
  - Use a helper sliding window function `countSubarraysWithAtMostKOdds()`
    to compute subarrays having at most `k` odd numbers.

  **How `countSubarraysWithAtMostKOdds` works**:
  1️⃣ Maintain two pointers `left` and `right`, and `oddCount` for current window.
  2️⃣ Expand `right` pointer and count odd numbers.
  3️⃣ Shrink `left` pointer when `oddCount > k`.
  4️⃣ For each `right`, add `(right - left + 1)` to `count`:
     - because all subarrays ending at `right` and starting anywhere between `left` and `right` are valid.

  **Why (right - left + 1)?**
  - Suppose window = [left..right] is valid.
  - Subarrays ending at `right` are:
    [right], [right-1..right], ..., [left..right] → count = window size.

  -----------------------------------------------------------------------------------
  ⏱ Complexity:
  -----------------------------------------------------------------------------------
  Time: O(N)
  - Each element is visited at most twice (once by right, once by left)
  Space: O(1)
  - Constant extra variables used

  -----------------------------------------------------------------------------------
  🔁 Follow-up Questions:
  -----------------------------------------------------------------------------------
  1️⃣ What if we need subarrays with exactly `k` even numbers?
     → Same logic, just count evens instead of odds.

  2️⃣ What if we need subarrays where the number of odds ≤ k (at most k)?
     → Directly return `countSubarraysWithAtMostKOdds(nums, k)`.

  3️⃣ Can we find the subarrays themselves, not just the count?
     → Yes, but would require storing and iterating through all valid windows (O(N²)).

  4️⃣ How to handle when elements are very large or negative?
     → Odd/even check uses `num % 2`, works for negatives too.

  -----------------------------------------------------------------------------------
  🔗 Similar LeetCode Questions:
  -----------------------------------------------------------------------------------
  - Leetcode 1248 – Count Number of Nice Subarrays (Exact same problem)
  - Leetcode 930 – Binary Subarrays With Sum (same trick: exactly k = at most k – at most (k-1))
  - Leetcode 992 – Subarrays with K Different Integers (same pattern, but counting distinct elements)
  */

  public static int countSubarraysWithAtMostKOdds(int[] nums, int k) {
    int count = 0;
    int left = 0;
    int oddCount = 0;

    for (int right = 0; right < nums.length; right++) {
      if (nums[right] % 2 != 0) oddCount++;

      // shrink window while too many odds
      while (oddCount > k) {
        if (nums[left] % 2 != 0) oddCount--;
        left++;
      }

      // Add number of subarrays ending at right
      count += (right - left + 1);
    }

    return count;
  }

  public static int kOddNumSubarray(int[] nums, int k) {
    /*| Step | Thought Process                                                     | Code                                    |
    | ---- | ------------------------------------------------------------------- | --------------------------------------- |
    | 1️⃣  | Let’s try sliding window like sum ≥ k                               | Almost worked but counted 1 window only |
    | 2️⃣  | Wait, there could be **multiple valid subarrays** ending at `right` | Missed those                            |
    | 3️⃣  | Oh! Use **at-most-K trick** from earlier pattern                    | `ExactlyK = atMost(K) - atMost(K - 1)`  |
    | 4️⃣  | Final optimal answer is built from two reusable functions           | Clean and fast                          |*/

    return countSubarraysWithAtMostKOdds(nums, k) - countSubarraysWithAtMostKOdds(nums, k - 1);
  }

  public static void main(String[] args) {
    int[] nums = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
    kOddNumSubarray(nums, 2);
  }
  /*
            When oddCount == k, there could be many possible starting points for the subarray:
   [1,1,2,1,1]
            ↑
          right = 4
  At this point, the following subarrays end at 4:

  [1, 1, 2, 1, 1] → 4 odds ❌

  [1, 2, 1, 1] → 3 odds ✅

  [2, 1, 1] → 2 odds ❌

  [1, 1] → 2 odds ❌

  [1] → 1 odd ❌
  | left | right | window       | oddCount | count this step | total count |
  | ---- | ----- | ------------ | -------- | --------------- | ----------- |
  | 0    | 0     | \[1]         | 1        | 1               | 1           |
  | 0    | 1     | \[1,1]       | 2        | 2               | 3           |
  | 0    | 2     | \[1,1,2]     | 2        | 3               | 6           |
  | 0    | 3     | \[1,1,2,1]   | 3 ✅      | 4               | 10          |
  | 0    | 4     | \[1,1,2,1,1] | 4 ❌      | shrink window   | —           |
  | 1    | 4     | \[1,2,1,1]   | 3 ✅      | 4               | 14          |

   atMost(3) = 14

  | left | right | window     | oddCount | count this step | total count |
  | ---- | ----- | ---------- | -------- | --------------- | ----------- |
  | 0    | 0     | \[1]       | 1        | 1               | 1           |
  | 0    | 1     | \[1,1]     | 2        | 2               | 3           |
  | 0    | 2     | \[1,1,2]   | 2        | 3               | 6           |
  | 0    | 3     | \[1,1,2,1] | 3 ❌      | shrink window   | —           |
  | 1    | 3     | \[1,2,1]   | 2 ✅      | 3               | 9           |
  | 1    | 4     | \[1,2,1,1] | 3 ❌      | shrink again    | —           |
  | 2    | 4     | \[2,1,1]   | 2 ✅      | 3               | 12          |
  atMost(2) = 12

  ExactlyK = atMost(3) - atMost(2) = 14 - 12 = 2 ✅


  */

}
