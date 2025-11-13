package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

import StandardProblemDSA.Utility;

/*
Question:
Check if a given pattern's permutation exists as a substring in the text.
Return true if any permutation of `pattern` exists inside `text`.

Example:
Input: pattern = "ab", text = "eidbaooo"
Output: true
Explanation:
- "ba" is a permutation of "ab" and appears in text.

Approach:
1. Use a sliding window of size equal to `pattern.length()`.
2. Maintain two frequency arrays of size 26 (for lowercase English letters):
   - `patFreq` → frequency of characters in the pattern.
   - `winFreq` → frequency of characters in the current window in text.
3. Iterate through `text`:
   - Add the current character to `winFreq`.
   - If window size exceeds `pattern.length()`, remove the leftmost character.
   - Compare `patFreq` and `winFreq`. If equal, permutation found → return true.
4. If no matching window found, return false.

Pattern:
- Sliding Window (fixed size) + Frequency Array Comparison.

Time Complexity:
- O(n * 26) ~ O(n), where n = length of `text`.

Space Complexity:
- O(1), since frequency arrays are constant size (26).

Follow-up Questions:
1. How would you modify this for case-insensitive matching?
2. How would you handle Unicode characters efficiently?
3. Can you optimize frequency array comparison to avoid checking all 26 characters every time?

Similar LeetCode/Interview Questions:
- LeetCode 567. Permutation in String
- LeetCode 438. Find All Anagrams in a String (variation)
- GFG: Check if one string is a permutation of another
*/

public class IsPermutaionContainOrNot {
  public static boolean checkInclusion(String pattern, String text) {
    // edge case , pattern length if greater than the string length return false
    if (pattern.length() > text.length()) {
      return false;
    }
    // create two frequency array pattern earlier
    // and during traversal of the window
    int[] patFreq = new int[26];
    int[] winFreq = new int[26];

    Utility.createCharacterFrequencyArray(pattern, patFreq);

    int i = 0;
    for (int j = 0; j < text.length(); j++) {
      // CASE 1: EXPAND WINDOW
      // Add current char to window
      winFreq[text.charAt(j) - 'a']++;
      // CASE 2: EQUAL WINDOW SIZE TO K
      // Window size larger than pattern -> shrink from left
      if (j - i + 1 > pattern.length()) {
        winFreq[text.charAt(i) - 'a']--;
        // CASE 3: SHRINK WINDOW
        i++; // shrinking the window if the characcter is greater in the window
      }

      // Compare pattern frequency and window frequency
      if (Utility.matches(patFreq, winFreq)) {
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "eiobaooo"));
  }
}
