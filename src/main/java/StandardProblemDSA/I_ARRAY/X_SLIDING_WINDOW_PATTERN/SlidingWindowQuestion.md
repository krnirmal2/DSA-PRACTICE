Awesome! Here's a **curated list of Sliding Window problems**, organized from **basic to advanced**, ideal for preparing for **FAANG interviews**:

---

## 🟢 Basic Level (Fixed-size Window)

1. **Maximum Sum Subarray of Size K**  
   _Find max sum of any contiguous subarray of size `k`_  
   🔗 [Leetcode 643](https://leetcode.com/problems/maximum-average-subarray-i/)

2. **Maximum Product Subarray of Size K**  
   _Handle zeros and negatives carefully_  
   ✅ Practice with dry run (you just did this!)

3. **Count Occurrences of Anagrams**  
   _Count how many substrings are anagrams of a given pattern_  
   🔗 [GeeksforGeeks Link](https://www.geeksforgeeks.org/count-occurrences-of-anagrams/)

4. **Number of Substrings Containing Exactly K Distinct Characters**  
   🔗 [Leetcode 992](https://leetcode.com/problems/subarrays-with-k-different-integers/)

---

## 🟡 Intermediate Level (Variable-size Window)

5. **Longest Substring Without Repeating Characters**  
   🔗 [Leetcode 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

6. **Minimum Size Subarray Sum ≥ Target**  
   🔗 [Leetcode 209](https://leetcode.com/problems/minimum-size-subarray-sum/)

7. **Longest Substring with At Most K Distinct Characters**  
   🔗 [Leetcode 340](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)

8. **Longest Repeating Character Replacement**  
   🔗 [Leetcode 424](https://leetcode.com/problems/longest-repeating-character-replacement/)

9. **Permutation in String**  
   🔗 [Leetcode 567](https://leetcode.com/problems/permutation-in-string/)

---

## 🔴 Advanced Level (Optimization + Tricky Conditions)

10. **Sliding Window Maximum**  
    _Use deque for O(n)_  
    🔗 [Leetcode 239](https://leetcode.com/problems/sliding-window-maximum/)

11. **Substring with Concatenation of All Words**  
    _Match substrings in any order_  
    🔗 [Leetcode 30](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)

12. **Minimum Window Substring**  
    _Classic problem: smallest window containing all chars of another string_  
    🔗 [Leetcode 76](https://leetcode.com/problems/minimum-window-substring/)

13. **Count Number of Nice Subarrays**  
    _Count subarrays with exactly K odd numbers_  
    🔗 [Leetcode 1248](https://leetcode.com/problems/count-number-of-nice-subarrays/)

14. **Fruit Into Baskets** (Max subarray with at most 2 distinct numbers)  
    🔗 [Leetcode 904](https://leetcode.com/problems/fruit-into-baskets/)

15. **Max Consecutive Ones III** (Flip at most K zeros)  
    🔗 [Leetcode 1004](https://leetcode.com/problems/max-consecutive-ones-iii/)

---

### ✅ Suggested Practice Order:
- Start with **1 to 4** to master the fixed window template.
- Then move on to **5 to 9** to solidify variable window logic.
- Finally tackle **10 to 15** to prepare for **real FAANG-level** challenges.

    
    
    Variable Sliding Window
    ├── 1. Longest / Maximum Length Problems
    │   ├── Longest Substring Without Repeating Characters
    │   ├── Longest Substring With At Most K Distinct Characters
    │   ├── Replace K characters to get longest same-char substring
    │   ├── Fruits Into Baskets (at most 2 distinct)
    │   └── 🔁 Template:
    │       for (right in range):
    │           update window
    │           while (window invalid):
    │               shrink from left
    │           update max length
    │
    ├── 2. Count Subarrays with Constraints
    │   ├── Subarrays with Exactly K distinct elements
    │   ├── Subarrays with Exactly K odd numbers
    │   ├── Substrings with at least one a, b, c
    │   ├── 🔁 Trick: count(atMostK) - count(atMostK-1)
    │   └── 🔁 Template:
    │       int countAtMostK(int K)
    │
    ├── 3. Min/Max Length with Sum Constraints
    │   ├── Min length subarray with sum ≥ K
    │   ├── Max subarray sum ≤ K
    │   └── 🔁 Template:
    │       expand right to include nums[right]
    │       while (sum > K): shrink from left
    │       update minLength if valid
    │
    ├── 4. Binary Array Specials
    │   ├── Max consecutive 1s after flipping at most 1 zero
    │   ├── Maximize 0s by flipping one subarray (Kadane's trick)
    │   └── 🔁 Binary count and sum flipping
    │
    ├── 5. Edge Selection / Dual-End
    │   ├── cardPoints: pick k cards from ends
    │   └── 🔁 Trick:
    │       maxSum = total - minSum(subarray of size n-k)
    │
    ├── 6. Minimum Window Problems
    │   ├── Minimum Window Substring (all of t in s)
    │   └── 🔁 Two hash maps: needCount vs. windowCount
    │       while (valid): shrink from left
    │
    ├── 7. Partitioning
    │   ├── Partition array into k subarrays with equal sum
    │   └── Often solved with backtracking, not window
