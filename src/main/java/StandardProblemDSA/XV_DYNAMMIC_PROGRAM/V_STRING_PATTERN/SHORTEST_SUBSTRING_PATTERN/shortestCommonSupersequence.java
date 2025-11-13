package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.SHORTEST_SUBSTRING_PATTERN;

import static StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN.LONGEST_LARGEST_SUBSTRING_PATTERN.LongestCommonSubsequence.longestCommonSubsequence;

public class shortestCommonSupersequence {
  /* ✅ Shortest Common Supersequence (SCS):
        Given two strings str1 and str2, the SCS is the shortest possible string that is a supersequence of both.

                ➡️ That means both str1 and str2 are subsequences of this new string.

    📌 Example:
        Let’s say:
        str1 = "AGGTAB"
        str2 = "GXTXAYB"
        LCS = "GTAB" (common part)
        So we use the formula:

        SCS length = str1.length() + str2.length() - LCS length
               = 6 + 7 - 4
                       = 9
                       👉 So, a possible Shortest Common Supersequence could be: "AGXGTXAYB"

                ✔️ It contains all characters of "AGGTAB" in order
    ✔️ It contains all characters of "GXTXAYB" in order

    🧠 Analogy:
        Think of:
        Subsequence: You’re erasing parts (cutting things out).
        Supersequence: You’re inserting things (expanding it) but keeping the original stuff in order.
  Why?
  - Classic DP problem based on the relationship between **LCS** and **SCS**.
  - Tests understanding of subsequences vs. supersequences.
  - Widely used in text merging, data synchronization, and genome sequence analysis.

  Pattern:
  - **LCS-based Formula**
    - First compute LCS (Longest Common Subsequence).
    - Then apply:
        SCS length = |str1| + |str2| - |LCS(str1, str2)|

  Intuition:
  - Both strings share `LCS` characters only once in SCS.
  - Remaining characters from each string are added.

  Time Complexity:
  - LCS computation: **O(n × m)** where n = |str1|, m = |str2|.
  - Space Complexity: **O(n × m)** (can optimize to O(min(n, m))).

  Edge Cases:
  - If one string is empty → SCS length = length of the other string.
  - If strings are identical → SCS length = length of one string.
  - If no common subsequence → SCS length = |str1| + |str2|.

  Follow-ups:
  - Can you **print the SCS string**? (Use LCS DP table + backtracking.)
  - Can you **optimize space** for very large strings?
  - Can you find all possible SCS strings (not just one)?

  LeetCode:
  - [LeetCode 1092](https://leetcode.com/problems/shortest-common-supersequence/) – Print SCS
  - Related: 1143 (Longest Common Subsequence), 583 (Delete Operations for Two Strings).

  Related Patterns:
  - LCS-based Optimization
  - String Reconstruction Problems
  - DP over Two Strings
    */
  public static int shortestCommonSupersequence(String text1, String text2) {
    int lcsLength = longestCommonSubsequence(text1, text2);
    return text1.length() + text2.length() - lcsLength;
  }

  public static void main(String[] args) {

    System.out.println(shortestCommonSupersequence("AGGTAB", "GXTXAYB"));
  }
}
