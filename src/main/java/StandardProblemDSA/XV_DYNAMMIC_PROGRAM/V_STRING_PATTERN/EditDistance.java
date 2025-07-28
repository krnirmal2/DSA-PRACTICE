package StandardProblemDSA.XV_DYNAMMIC_PROGRAM.V_STRING_PATTERN;

public class EditDistance {
  /*Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
    You have the following three operations permitted on a word:
    	• Insert a character
    	• Delete a character
    	• Replace a character

    Example 1:
    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
    Example 2:
    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')

    Constraints:
    	• 0 <= word1.length, word2.length <= 500
    word1 and word2 consist of lowercase English letters.


  Why?
  - Classic DP problem for **string transformation**.
  - Widely used in spell checkers, auto-correct, and DNA sequence analysis.
  - Tests ability to model problems with multiple choices (Insert, Delete, Replace).

  Pattern:
  - **DP over Two Strings**
  - State: dp[i][j] = min operations to convert word1[0..i-1] → word2[0..j-1].
  - Recurrence:
      if word1[i-1] == word2[j-1]:
          dp[i][j] = dp[i-1][j-1]          // no change
      else:
          dp[i][j] = 1 + min(
                          dp[i-1][j],      // delete from word1
                          dp[i][j-1],      // insert into word1
                          dp[i-1][j-1]     // replace
                       )

  Base Cases:
  - dp[0][j] = j → Convert empty string to word2 by inserting j chars.
  - dp[i][0] = i → Convert word1 to empty string by deleting i chars.

  Time Complexity:
  - Recursive: O(3^(m+n)) → Exponential
  - Memoized/Tabulated: **O(m × n)**
  - Space Complexity: **O(m × n)** (can optimize to O(min(m, n))).

  Follow-ups:
  - Can you reconstruct the sequence of edits (operations)?
  - Can you optimize space to O(n)?
  - Can you solve **“Minimum Delete Operations to Make Two Strings Equal”** (LeetCode 583) using LCS?

  LeetCode:
  - [LeetCode 72 – Edit Distance](https://leetcode.com/problems/edit-distance/)
  - Related: 1143 (LCS), 1092 (Shortest Common Supersequence).

  Related Patterns:
  - DP over Strings (LCS, SCS, Delete Operations)
  - Matrix-based DP
    */

  public int minDistance(String word1, String word2) {
    return helper(word1, word2, word1.length(), word2.length());
  }

  // Recursive helper function to calculate the edit distance
  private int helper(String word1, String word2, int i, int j) {
    // Base cases
    if (i == 0) return j; // Need to insert all characters of word2
    if (j == 0) return i; // Need to delete all characters of word1

    // If characters match, no operation needed, move to the next
    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
      return helper(word1, word2, i - 1, j - 1);
    } else {
      // Take minimum of Insert, Delete, or Replace
      return 1
          + Math.min(
              Math.min(
                  helper(word1, word2, i - 1, j), // Deletion
                  helper(word1, word2, i, j - 1)), // Insertion
              helper(word1, word2, i - 1, j - 1) // Replacement
              );
    }
  }
}
