package StandardProblemDSA.XI_GREEDYALGO;

public class LIS_Triplet {
  /*
              ## Step 1. Restate the problem in your own words

      We need to check:
              👉 Does there exist **i < j < k** such that
  `nums[i] < nums[j] < nums[k]`?
      We don’t care about the subsequence itself, just **existence**.
              ## Step 2. First thought (DP / LIS)
      You recall LIS (Longest Increasing Subsequence). If LIS length ≥ 3 → answer is true.
      But LIS is O(n²) or O(n log n). That’s heavy for such a small goal (just length ≥ 3).

      So: **Do I really need full LIS?**
      No. I don’t need the whole subsequence, just a triplet.
          ## Step 3. Reframe the problem

      What does it mean to have an increasing triplet?
              * There exists a **smallest number** (first element).
              * Then a **bigger number after it** (second element).
              * Then an **even bigger number after that** (third element).

      So if I can keep track of “the smallest so far” and “the next bigger one”, then any time I find a third bigger number, I’m done.

      This suggests **tracking just two values**.
              ## Step 4. Greedy idea
  1. Start with two sentinels:
              * `first = ∞` (smallest seen so far)
              * `second = ∞` (second smallest seen so far)
              2. Iterate left → right:

              * If current `num` ≤ `first`:
      update `first = num` (new smallest).
              * Else if current `num` ≤ `second`:
      update `second = num` (new candidate second).
              * Else:
      we found `num > second > first` ⇒ triplet exists.
              ## Step 5. Why is this greedy correct?

              * Because we always keep the **smallest possible `first`**, which maximizes chances of finding a valid `second`.
              * For `second`, we keep the **smallest possible candidate larger than `first`**, which maximizes chances of finding a `third`.
              * As soon as we see a number bigger than `second`, we guarantee a triplet.

      So we don’t need to look back or recompute subsequences: the greedy choice (always keep the smallest viable first and second) never hurts and always helps.
              ## Step 6. Walkthrough example
      Input: `[5, 1, 6, 2, 3]`

              * `first = ∞, second = ∞`
              * num=5 → first=5
              * num=1 → first=1 (better smallest)
              * num=6 → second=6 (greater than 1)
              * num=2 → second=2 (smaller second, better chance)
              * num=3 → 3 > second=2 ⇒ found triplet (1,2,3).

      Answer: true ✅
              ## Step 7. Final greedy code
          ⏱ O(n), 📦 O(1)
          💡 **Key thinking pattern for greedy vs DP:**

              * Ask: *Do I need the whole subsequence/structure, or just existence of a small condition?*
              * If it’s just existence, often you can maintain a few tracking variables instead of full DP.
              * For subsequence problems:

              * Full length → DP/LIS.
    * Just “is there a triplet?” → greedy.

  ---
  */

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true; // found num > second > first
            }
        }
        return false;
    }
}
