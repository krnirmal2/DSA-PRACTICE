package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.SHORTEST_SUBSTRING_PATTERN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class All_SCS_PRINT {

  public static List<String> printAllSCS(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    // Step 1: Build LCS DP table
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1]; // diagonal move and add the count to it
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // move either up or left
        }
      }
    }

    // Step 2: Backtrack recursively to collect all SCS
    return backtrackAll(s1, s2, n, m, dp);
  }

  private static List<String> backtrackAll(String s1, String s2, int i, int j, int[][] dp) {
    List<String> result = new ArrayList<>();

    // Base cases
    if (i == 0 && j == 0) {
      result.add("");
      return result;
    }
    if (i == 0) {
      result.add(s2.substring(0, j));
      return result;
    }
    if (j == 0) {
      result.add(s1.substring(0, i));
      return result;
    }

    // If chars match, include it in SCS
    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
      for (String str : backtrackAll(s1, s2, i - 1, j - 1, dp)) {
        result.add(str + s1.charAt(i - 1));
      }
    } else {
      // If s1 choice is better
      if (dp[i - 1][j] > dp[i][j - 1]) {
        for (String str : backtrackAll(s1, s2, i - 1, j, dp)) {
          result.add(str + s1.charAt(i - 1));
        }
      }
      // If s2 choice is better
      else if (dp[i - 1][j] < dp[i][j - 1]) {
        for (String str : backtrackAll(s1, s2, i, j - 1, dp)) {
          result.add(str + s2.charAt(j - 1));
        }
      }
      // If both choices are equal → explore both
      else {
        for (String str : backtrackAll(s1, s2, i - 1, j, dp)) {
          result.add(str + s1.charAt(i - 1));
        }
        for (String str : backtrackAll(s1, s2, i, j - 1, dp)) {
          result.add(str + s2.charAt(j - 1));
        }
      }
    }

    return result;
  }

  // Driver
  public static void main(String[] args) {
    String s1 = "AGGTAB";
    String s2 = "GXTXAYB";

    List<String> scsList = printAllSCS(s1, s2);
    Set<String> unique = new HashSet<>(scsList); // remove duplicates
    System.out.println("All possible SCS: " + unique);
  }
}
