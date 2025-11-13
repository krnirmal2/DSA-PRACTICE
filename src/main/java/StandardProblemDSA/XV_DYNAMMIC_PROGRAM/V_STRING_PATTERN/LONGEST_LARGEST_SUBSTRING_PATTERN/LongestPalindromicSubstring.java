package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.LONGEST_LARGEST_SUBSTRING_PATTERN;

public class LongestPalindromicSubstring {
  /*
  5. Longest Palindromic Substring

  Why?
  - Classic string DP/center expansion problem.
  - Common interview question testing understanding of palindrome properties.
  - Useful in applications like DNA sequence analysis, error correction, and text search.

  Pattern:
  - Expand Around Center (Two Pointers):
      - Every palindrome can be expanded from its center.
      - A string of length n has 2n-1 possible centers (n odd + n-1 even).

  Approach:
  1. Iterate over all indices `i` of the string.
  2. Expand around two centers:
      - Odd-length: (i, i)
      - Even-length: (i, i+1)
  3. Track the maximum length and update `start` and `end` indices.

  Time Complexity:
  - **O(n²)**: For each of n centers, expansion can take up to O(n) in the worst case.
  - **O(1)** extra space.

  Edge Cases:
  - Empty string → return `""`.
  - Single character string → return the string itself.
  - Entire string is already a palindrome.

  Follow-up:
  - Can you solve it in **O(n)** using Manacher’s Algorithm?
  - Can you return the **count** of all palindromic substrings (LeetCode 647)?
  - Difference between Longest Palindromic Substring (continuous) vs Longest Palindromic Subsequence (non-contiguous).

  LeetCode:
  - [LeetCode 5](https://leetcode.com/problems/longest-palindromic-substring/)
  - Related: 516 (Longest Palindromic Subsequence), 647 (Count Palindromic Substrings), 1312 (Min Insertions to Make String Palindrome).

  Related Patterns:
  - Expand Around Center
  - Dynamic Programming on substrings
  - Manacher’s Algorithm for optimized solution
  */

  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i); // Odd length
      int len2 = expandAroundCenter(s, i, i + 1); // Even length
      int len = Math.max(len1, len2);
      if (len > end - start) { // Update longest palindrome range
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }
}
