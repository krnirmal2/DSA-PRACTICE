package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.LONGEST_LARGEST_SUBSTRING_PATTERN;

public class LongestPalindromicSubsequence {
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
