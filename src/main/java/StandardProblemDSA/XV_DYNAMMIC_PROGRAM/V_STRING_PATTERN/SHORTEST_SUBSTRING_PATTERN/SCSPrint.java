package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.SHORTEST_SUBSTRING_PATTERN;

public class SCSPrint {
  public static String printSCS(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    // Step 1: Build the LCS dp table
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    // Step 2: Backtrack to build the SCS string
    int i = n, j = m;
    StringBuilder scs = new StringBuilder();

    while (i > 0 && j > 0) {
      if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        scs.append(s1.charAt(i - 1));
        i--;
        j--;
      } else if (dp[i - 1][j] > dp[i][j - 1]) {
        scs.append(s1.charAt(i - 1));
        i--;
      } else {
        scs.append(s2.charAt(j - 1));
        j--;
      }
    }

    // If any characters are left in either string
    while (i > 0) {
      scs.append(s1.charAt(i - 1));
      i--;
    }
    while (j > 0) {
      scs.append(s2.charAt(j - 1));
      j--;
    }

    return scs.reverse().toString(); // Since we built it backwards
  }

  public static void main(String[] args) {
    String s1 = "abcde";
    String s2 = "ace";
    String scs = printSCS(s1, s2);
    System.out.println("Shortest Common Supersequence: " + scs);
  }
  /* 🧠 Step-by-Step Plan to Print SCS
      We'll:

      Build the DP table for LCS like before.
      Backtrack the table to construct the actual SCS.
      If characters match → include that character once.
      If characters don’t match → include the character from the direction we came from (either from s1 or s2).

      🔁 Backtracking for SCS:
  Start from bottom-right dp[5][3]:

  s1[4] == s2[2] → both are 'e' → add 'e' → go to dp[4][2]

  s1[3] = 'd', s2[1] = 'c' → not equal

  dp[3][2] > dp[4][1] → go up → add 'd'

  s1[2] == s2[1] = 'c' → add 'c' → go to dp[2][1]

  s1[1] = 'b', s2[0] = 'a' → not equal

  dp[1][1] > dp[2][0] → go up → add 'b'

  s1[0] == s2[0] = 'a' → add 'a'

  Now i == 0, j == 0 → Done!

  🟢 Collected in reverse: "e" + "d" + "c" + "b" + "a" → reverse it → "abcde"

  Shortest Common Supersequence: abcde
  🧠 You can notice:

  "ace" is common.

  "b" and "d" are added to cover full "abcde" and "ace".


      */
}
