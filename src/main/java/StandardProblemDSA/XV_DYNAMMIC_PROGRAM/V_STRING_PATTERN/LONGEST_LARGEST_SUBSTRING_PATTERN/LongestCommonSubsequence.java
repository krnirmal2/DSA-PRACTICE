package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.LONGEST_LARGEST_SUBSTRING_PATTERN;

import java.util.Arrays;

/*Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
	• For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:
Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
*/
public class LongestCommonSubsequence {
  public static int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length()][text2.length()];
    for (int[] row : dp) Arrays.fill(row, -1);
    return lcs(text1, text2, text1.length() - 1, text2.length() - 1, dp);
  }

  private static int lcs(String s1, String s2, int i, int j, int[][] dp) {
    if (i < 0 || j < 0) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    //If matched reduce indexes of both
    if (s1.charAt(i) == s2.charAt(j)) {
      return dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
    } else {
      //if not matched reduce index of any one and then find the max out of them
      return dp[i][j] = Math.max(lcs(s1, s2, i - 1, j, dp), lcs(s1, s2, i, j - 1, dp));
    }
  }
  /*Recursive
      O(2^(n + m))
      O(n + m) (stack space)
      Top-Down with Memo
      O(n * m)
      O(n * m) + O(n + m)
  */
  public static void main(String[] args) {
    System.out.println(longestCommonSubsequence("AGGTAB", "GXTXAYB"));
  }
}
