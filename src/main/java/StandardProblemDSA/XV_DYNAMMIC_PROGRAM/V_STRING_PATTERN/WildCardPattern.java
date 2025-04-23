package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN;

public class WildCardPattern {
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
