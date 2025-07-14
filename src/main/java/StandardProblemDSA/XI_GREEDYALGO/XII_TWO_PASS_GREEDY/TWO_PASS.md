Here are **top "Two-Pass Greedy" algorithm problems** that are commonly asked in interviews — especially when you need to **scan twice (left→right and right→left)** to satisfy neighbor-based or bidirectional constraints.

---

## ✅ **Top "Two-Pass Greedy" Problems**

| #   | Problem                                         | Description                                                       | Why Two Pass?                                                                                   | Link                                                                                        |
| --- | ----------------------------------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| 1️⃣ | **Candy**                                       | Distribute minimum candies to children based on neighbor ratings. | First pass satisfies increasing trend (left to right), second fixes decreasing (right to left). | [LeetCode 135](https://leetcode.com/problems/candy/)                                        |
| 2️⃣ | **Trapping Rain Water**                         | Find how much water can be trapped between bars.                  | Left pass computes `leftMax`, right pass computes `rightMax`.                                   | [LeetCode 42](https://leetcode.com/problems/trapping-rain-water/)                           |
| 3️⃣ | **Minimum Swaps to Make Strings Equal**         | Equalize two strings with 'x' and 'y' by swapping mismatches.     | Count mismatches in 1st pass, calculate min swaps in 2nd.                                       | [LeetCode 1247](https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/)         |
| 4️⃣ | **Longest Mountain in Array**                   | Find longest subarray that increases then decreases.              | 1st pass: build increasing sequence; 2nd: decreasing from end.                                  | [LeetCode 845](https://leetcode.com/problems/longest-mountain-in-array/)                    |
| 5️⃣ | **Minimum Moves to Equal Array Elements II**    | Equalize all elements with min moves.                             | Sort, pick median, then do two passes for moves.                                                | [LeetCode 462](https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/)     |
| 6️⃣ | **Score After Flipping Matrix**                 | Maximize score by flipping rows and columns.                      | First pass: flip all rows with 0 at start; second: check cols.                                  | [LeetCode 861](https://leetcode.com/problems/score-after-flipping-matrix/)                  |
| 7️⃣ | **Wiggle Subsequence**                          | Find the longest wiggle subsequence.                              | Pass from left to right twice: one for up-down, one for down-up.                                | [LeetCode 376](https://leetcode.com/problems/wiggle-subsequence/)                           |
| 8️⃣ | **Daily Temperatures**                          | For each day, find how many days to wait for warmer temp.         | Right-to-left pass with greedy stack. Left pass not always used, but similar idea.              | [LeetCode 739](https://leetcode.com/problems/daily-temperatures/)                           |
| 9️⃣ | **Check Array Formation Through Concatenation** | Greedy set membership check.                                      | First: store parts, second: match against original array.                                       | [LeetCode 1640](https://leetcode.com/problems/check-array-formation-through-concatenation/) |
| 🔟  | **Pancake Sorting**                             | Sort array using pancake flips.                                   | Find max in subarray in left pass; then flip and re-check in right pass.                        | [LeetCode 969](https://leetcode.com/problems/pancake-sorting/)                              |

---

## 🧠 Why Two Pass?

Two-pass greedy is useful when:

1. **The decision for an index depends on both left and right neighbors**.
2. **One direction builds up partial info, the second fixes inconsistencies**.
3. **You can't guarantee correctness with a single-direction greedy**.

---

## 🔁 Patterns in Two-Pass Greedy

| Pattern                                         | Description                     |
| ----------------------------------------------- | ------------------------------- |
| **Build Left State → Fix from Right**           | e.g., Candy, Rain Water         |
| **Count or Prepare in First → Apply in Second** | e.g., Swaps, Matrix Flip        |
| **Compare Forward and Backward Runs**           | e.g., Longest Mountain          |
| **Construct State (prefix/suffix arrays)**      | Often seen in DP-Greedy hybrids |

---

## 🔧 Want Practice Set?

Would you like a **two-pass greedy problem set** ordered by difficulty with:

* ✅ Intuition
* ✅ Sample input/output
* ✅ Patterns/tips

Let me know — I can build it!
