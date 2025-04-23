package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN;

import java.util.Arrays;

public class NoOfDistinctSubSequence {
  /*Given two strings s and t, return the number of distinct subsequences of s which equals t.
  The test cases are generated so that the answer fits on a 32-bit signed integer.

  Example 1:
  Input: s = "rabbbit", t = "rabbit"
  Output: 3
  Explanation:
  As shown below, there are 3 ways you can generate "rabbit" from s.
  rabbbit
  rabbbit
  rabbbit
  Example 2:
  Input: s = "babgbag", t = "bag"
  Output: 5
  Explanation:
  As shown below, there are 5 ways you can generate "bag" from s.
  babgbag
  babgbag
  babgbag
  babgbag
  babgbag

  Constraints:
  	• 1 <= s.length, t.length <= 1000
  s and t consist of English letters.*/

  /* Recursive Transition Relation:
     Let dp(i, j) be the number of distinct subsequences of s[0..i] that match t[0..j].
             • If s[i] == t[j]:
     dp(i, j) = dp(i - 1, j - 1) + dp(i - 1, j)
  	○ This is because you can either include s[i] to match t[j] or exclude it.
  • If s[i] != t[j]:
     dp(i, j) = dp(i - 1, j)
  	○ This is because you can only exclude s[i] and look for a subsequence in s[0..i-1] that matches t[0..j].
     Base Case:
             • dp(i, 0) = 1 for all i >= 0: This is because there is exactly one way to match an empty t (by deleting all characters from s).
     dp(0, j) = 0 for all j > 0: This is because it's impossible to form a non-empty t from an empty s.*/

  public int numDistinct(String s, String t) {
    // Create a memoization table
    int[][] memo = new int[s.length() + 1][t.length() + 1];

    // Initialize memo table for base cases
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }

    // Call the recursive function with memoization
    return helper(s, t, s.length() - 1, t.length() - 1, memo);
  }

  private int helper(String s, String t, int i, int j, int[][] memo) {
    // Base case: if t is empty, there's exactly one way to form t from s (by deleting all
    // characters)
    if (j == -1) return 1;
    // If s is empty and t is not, no way to form t
    if (i == -1) return 0;

    // If the result is already computed, return it
    if (memo[i][j] != -1) return memo[i][j];

    int result = 0;

    // If characters match, consider both including and excluding the character
    if (s.charAt(i) == t.charAt(j)) {
      result += helper(s, t, i - 1, j - 1, memo); // Include s[i]
    }

    // Consider excluding the character from s
    result += helper(s, t, i - 1, j, memo); // Exclude s[i]

    // Store the result in the memoization table
    memo[i][j] = result;
    return result;
  }
}
