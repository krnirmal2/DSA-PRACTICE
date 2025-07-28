package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.LONGEST_LARGEST_SUBSTRING_PATTERN;

public class LongestPalindromicSubsequence {
  /*
  516. Longest Palindromic Subsequence

  Why?
  - Frequently asked in interviews.
  - Tests your understanding of subsequences vs substrings.
  - Forms the basis for problems like "Minimum Insertions to Make String Palindrome" and "Palindrome Partitioning".

  Pattern:
  - Dynamic Programming (DP) on substrings.
  - Compare characters at both ends (`i`, `j`):
      - If match → take both ends + solve inside (i+1, j-1).
      - If not → try removing one end (i+1, j) or (i, j-1), take max.
  - State: `dp[i][j]` = length of LPS in substring `s[i..j]`.

  Approach:
  - Recursive relation:
      - `lps(i, j) = 2 + lps(i+1, j-1)` if `s[i] == s[j]`
      - Else → `max(lps(i+1, j), lps(i, j-1))`
  - Base cases:
      - `i == j` → 1 (single char)
      - `i > j` → 0 (invalid range)

  Time Complexity:
  - Plain recursion: **O(2^n)** (explores all subsequences).
  - DP memoization/tabulation: **O(n²)**.
  - Space Complexity: **O(n²)** (can be optimized to O(n)).

  Edge Cases:
  - Empty string → 0.
  - String with all identical characters → length of the string.
  - Single character string → 1.

  Follow-up:
  - Can you retrieve the actual subsequence, not just its length?
  - Can you optimize space to O(n)?
  - How would you modify it to find the Longest Palindromic Substring (continuous)?

  LeetCode:
  - [LeetCode 516](https://leetcode.com/problems/longest-palindromic-subsequence/)
  - Related: 1312 (Minimum Insertion Steps to Make a String Palindrome), 5 (Longest Palindromic Substring), 1143 (LCS).

  Related Patterns:
  - LCS-based problems (LPS = LCS(s, reverse(s)))
  - Palindrome DP
  - Interval DP
  */

  public int longestPalindromeSubseq(String s) {
    return lps(s, 0, s.length() - 1);
  }

  private int lps(String s, int i, int j) {
    if (i == j) return 1; // Single character is always a palindrome
    if (i > j) return 0; // Invalid case
    if (s.charAt(i) == s.charAt(j)) {
      return 2 + lps(s, i + 1, j - 1); // take and increment i and decrement j if matched
    } else {
      return Math.max(
          lps(s, i + 1, j),
          lps(s, i, j - 1)); // if not matched , exclude i include j or exclude j include i
    }
  }
  /*  public int longestPalindromeSubseq(String s) {
          int n = s.length();
          int[][] memo = new int[n][n]; // Cache results
          for (int[] row : memo) Arrays.fill(row, -1);
          return lps(s, 0, n - 1, memo);
      }
      private int lps(String s, int i, int j, int[][] memo) {
          if (i == j) return 1;
          if (i > j) return 0;
          if (memo[i][j] != -1) return memo[i][j]; // Retrieve from cache
          if (s.charAt(i) == s.charAt(j)) {
              memo[i][j] = 2 + lps(s, i + 1, j - 1, memo);
          } else {
              memo[i][j] = Math.max(lps(s, i + 1, j, memo), lps(s, i, j - 1, memo));
          }
          return memo[i][j];
      }
      O(n*m) length of the strings
  */
}
