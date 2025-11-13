package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.LongestWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacteReplacement {

  //
  public static int characterReplacement(String s, int k) {
    /*You are given a string s and an integer k.
             You can choose any character of the string and change it to any other uppercase English character.
             You can perform this operation at most k times.
        Return the length of the longest substring containing the same letter you can get after performing the
         above operations.
        Example 1:
        Input: s = "ABAB", k = 2
        Output: 4
        Explanation: Replace the two 'A's with two 'B's or vice versa.
        Example 2:
        Input: s = "AABABBA", k = 1
        Output: 4
        Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
        The substring "BBBB" has the longest repeating letters, which is 4.
        There may exists other ways to achieve this answer too.

    ------------------------------------------------------
    Pattern
    ------------------------------------------------------
    Pattern Name: Sliding Window (Variable Size)
    - Maintain a window [i..j] that contains at most k characters to change.
    - Keep track of:
      - `map`: frequency of each character in the window.
      - `maxFrequency`: frequency of the most frequent character in the current window.
    - Window size = (j - i + 1).
    - If (window size - maxFrequency) > k → too many changes needed → shrink window from the left.

    Key insight:
    - We don’t need to decrease `maxFrequency` when shrinking the window.
      It always represents the largest frequency seen so far, which is fine for our condition check.

    ------------------------------------------------------
    Algorithm (Optimized O(n)):
    ------------------------------------------------------
    1. Initialize pointers i = 0, j = 0, maxFrequency = 0, longest = 0, and map<Character, Integer>.
    2. Expand window by adding s[j] to the map.
    3. Update `maxFrequency`.
    4. If (window size - maxFrequency) > k → shrink window by incrementing i and updating map.
    5. Update `longest` with the current valid window size.
    6. Repeat until j reaches the end.

    ------------------------------------------------------
    Follow-up Questions
    ------------------------------------------------------
    1. Why do we not reduce `maxFrequency` when shrinking?
       - Even if it’s outdated, the condition still holds:
         (window size - maxFrequency) > k guarantees correctness.
    2. How to modify if lowercase letters or arbitrary Unicode characters are allowed?
       - Use an array of size 26 for lowercase or a HashMap for general cases.
    3. Can this solve "Longest substring with at most k distinct characters"?
       - No, that’s a different problem (use map.size() instead of window size - maxFrequency).

    ------------------------------------------------------
    Similar LeetCode Problems
    ------------------------------------------------------
    - LeetCode 424 – Longest Repeating Character Replacement (this problem)
    - LeetCode 1004 – Max Consecutive Ones III
    - LeetCode 340 – Longest Substring with At Most K Distinct Characters

    ------------------------------------------------------
    Time & Space Complexity
    ------------------------------------------------------
    - Time: O(n) – each character is processed at most twice (once added, once removed).
    - Space: O(1) – since we store frequencies of at most 26 uppercase letters.*/
    if (s.length() < k) return s.length();
    // now store the map character frequency so that we will get atmost k
    // distinct charater in substring and if we over that then need to udate
    Map<Character, Integer> map = new HashMap<>();

    int longSubStringWithRepeatingCh = 0;

    int maxFrequecy = 0;
    int i = 0, j = 0;
    while (j < s.length()) {
      map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
      // now update the max fequency present in the array
      maxFrequecy = Math.max(maxFrequecy, map.get(s.charAt(j)));

      // now we have to only take care if the frequency of that character is
      // exceed the k
      // In a window, to make all letters the same, I only need to change the non-majority letters.
      if ((j - i + 1) - maxFrequecy > k) { // window size - maxFreq = number of letters to change
        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        i++;
      }
      longSubStringWithRepeatingCh = Math.max(longSubStringWithRepeatingCh, (j - i + 1));
    }
    return longSubStringWithRepeatingCh;
  }

  /*
            | Step | left | right | Window  | Freq Map | maxFreq | Window Size | Changes Needed `(size - maxFreq)` | Valid? | Max Length |
            | ---- | ---- | ----- | ------- | -------- | ------- | ----------- | --------------------------------- | ------ | ---------- |
            | 1    | 0    | 0     | "A"     | A:1      | 1       | 1           | 0                                 | ✅      | 1          |
            | 2    | 0    | 1     | "AA"    | A:2      | 2       | 2           | 0                                 | ✅      | 2          |
            | 3    | 0    | 2     | "AAB"   | A:2, B:1 | 2       | 3           | 1                                 | ✅      | 3          |
            | 4    | 0    | 3     | "AABA"  | A:3, B:1 | 3       | 4           | 1                                 | ✅      | 4          |
            | 5    | 0    | 4     | "AABAB" | A:3, B:2 | 3       | 5           | 2                                 | ❌      | 4          |
            |      | 1    | 4     | "ABAB"  | A:2, B:2 | 2       | 4           | 2                                 | ❌      | 4          |
            |      | 2    | 4     | "BAB"   | A:1, B:2 | 2       | 3           | 1                                 | ✅      | 4          |
            | 6    | 2    | 5     | "BABB"  | A:1, B:3 | 3       | 4           | 1                                 | ✅      | 4          |
            | 7    | 2    | 6     | "BABBA" | A:2, B:3 | 3       | 5           | 2                                 | ❌      | 4          |
            |      | 3    | 6     | "ABBA"  | A:2, B:2 | 2       | 4           | 2                                 | ❌      | 4          |
            |      | 4    | 6     | "BBA"   | A:1, B:2 | 2       | 3           | 1                                 | ✅      | 4          |
  */

  public static void main(String[] args) {

    //    System.out.println(characterReplacement("ABAB", 2)); // Output: 4
    System.out.println(characterReplacement("AABABBA", 1)); // Output: 4
    //        System.out.println(sol.characterReplacement("AAABBC", 2)); // Output: 5
  }
}
