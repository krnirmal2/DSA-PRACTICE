package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN;

public class WildCardPattern {
  /*
  44. Wildcard Matching

  Given an input string (s) and a pattern (p), implement wildcard pattern matching
  with support for '?' and '*' where:

      - '?' Matches any single character.
      - '*' Matches any sequence of characters (including the empty sequence).

  The matching should cover the entire input string (not partial).

  Example 1:
  Input: s = "aa", p = "a"
  Output: false
  Explanation: "a" does not match the entire string "aa".

  Example 2:
  Input: s = "aa", p = "*"
  Output: true
  Explanation: '*' matches any sequence.

  Example 3:
  Input: s = "cb", p = "?a"
  Output: false
  Explanation: '?' matches 'c', but 'a' != 'b'.

  Constraints:
      • 1 <= s.length, p.length <= 2000
      • s and p consist of only lowercase English letters and characters '?' and '*'.

  ---
  ❓ Why:
  We must check if the entire string matches a pattern where '*' can match
  any number of characters and '?' matches exactly one. Direct recursion
  would lead to exponential complexity due to multiple '*' expansions,
  hence DP.

  ---
  💡 Pattern:
  - DP[i][j] = does s[0..i-1] match p[0..j-1]?
  - If p[j-1] == s[i-1] or p[j-1] == '?': DP[i][j] = DP[i-1][j-1]
  - If p[j-1] == '*': DP[i][j] = DP[i][j-1] (empty match) || DP[i-1][j] (match one or more)
  - Base: DP[0][0] = true, and handle leading '*' in pattern.

  ---
  ⏱ Time Complexity: O(m × n)
  📦 Space Complexity: O(m × n) → can be optimized to O(n)

  ---
  🔄 Follow-up:
  - Optimize to O(n) space using rolling arrays.
  - Implement greedy two-pointer solution (faster but trickier).
  - Modify to support regex-like patterns (e.g., character sets).

  ---
  🔗 LeetCode:
  - 44. Wildcard Matching (Hard)
  - Related: 10. Regular Expression Matching, 72. Edit Distance, 115. Distinct Subsequences
  */

  /*🔹 Approach
     We will use a 2D DP table dp[i][j], where:
             • dp[i][j] = true → First i characters of text match first j characters of pattern.
  • Base Cases:
             ○ Empty pattern matches an empty string → dp[0][0] = true.
             ○ * can match an empty string → If pattern starts with *, we set dp[0][j] = dp[0][j-1].
             • Transitions:
             ○ If text[i-1] == pattern[j-1] OR pattern[j-1] == '?' → Carry forward dp[i-1][j-1].
             ○ If pattern[j-1] == '*', it can either:
             § Match 0 characters (dp[i][j-1]).
     Match 1 or more characters (dp[i-1][j]).*/
  public static boolean isMatch(String text, String pattern) {
    int m = text.length(), n = pattern.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    // Base case: Empty pattern matches empty string
    dp[0][0] = true;
    // Handle leading '*' in pattern
    for (int j = 1; j <= n; j++) {
      if (pattern.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 1]; // '*' matches empty string
      }
    }
    // Fill the DP table
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        char textChar = text.charAt(i - 1);
        char patternChar = pattern.charAt(j - 1);
        if (textChar == patternChar || patternChar == '?') {
          dp[i][j] = dp[i - 1][j - 1]; // Match found, continue
        } else if (patternChar == '*') {
          dp[i][j] = dp[i][j - 1] || dp[i - 1][j]; // '*' matches empty or multiple
        }
      }
    }
    return dp[m][n]; // Final result
  }

  public static void main(String[] args) {
    System.out.println(isMatch("abcde", "a*c?e")); // true
    System.out.println(isMatch("abcdef", "a*d")); // false
    System.out.println(isMatch("ab", "*")); // true
    System.out.println(isMatch("abcd", "a*c")); // false
  }
}
