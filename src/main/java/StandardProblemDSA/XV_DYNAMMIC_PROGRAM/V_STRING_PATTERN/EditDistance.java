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
  word1 and word2 consist of lowercase English letters.*/

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
