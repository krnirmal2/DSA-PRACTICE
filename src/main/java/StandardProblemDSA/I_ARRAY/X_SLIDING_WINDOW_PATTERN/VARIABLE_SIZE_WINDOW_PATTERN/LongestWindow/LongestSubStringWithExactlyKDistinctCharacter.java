package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.LongestWindow;

import java.util.HashMap;
import java.util.Map;

/*
------------------------------------------------------
Question (Interviewer-style)
------------------------------------------------------
"Given a string s and an integer k, find the length of the longest substring
 that contains exactly k distinct characters.
 If no such substring exists, return -1."

Example:
Input:  s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring is "cbebebe".

------------------------------------------------------
Pattern
------------------------------------------------------
Pattern Name: Variable Size Sliding Window + HashMap
- Maintain a window that contains at most K distinct characters.
- Expand the window by moving the right pointer.
- When the number of distinct characters exceeds K, shrink from the left.
- Track the maximum window size where exactly K distinct characters exist.

------------------------------------------------------
Optimal Approach (O(n) time)
------------------------------------------------------
1. Initialize i = 0 (left), j = 0 (right), longest = -1, Map<Character, Integer>.
2. Expand right pointer j:
   - Add s[j] to map and increment its count.
3. If map.size() > K:
   - Shrink from left (i++) until we have at most K distinct characters.
4. If map.size() == K:
   - Update longest = max(longest, j - i + 1).
5. Continue until j reaches the end of s.
6. Return longest.

------------------------------------------------------
Follow-up Questions
------------------------------------------------------
1. What if we need "at most K" distinct characters instead of "exactly K"?
   - Remove the map.size() == K condition; update longest whenever map.size() ≤ K.
2. How to return the substring itself instead of length?
   - Track start and end indices when updating longest.
3. What happens if k > number of unique characters in s?
   - Return -1 (no substring possible).

------------------------------------------------------
Similar LeetCode Problems
------------------------------------------------------
- LeetCode 340 – Longest Substring with At Most K Distinct Characters
- LeetCode 159 – Longest Substring with At Most Two Distinct Characters
- LeetCode 3 – Longest Substring Without Repeating Characters (k = size of all unique chars)

------------------------------------------------------
Time & Space Complexity
------------------------------------------------------
- Time: O(n) – Each character is processed at most twice.
- Space: O(k) – For storing character frequency map.
*/

public class LongestSubStringWithExactlyKDistinctCharacter {
  public static int longestKSubstr(String s, int k) {
    int longestSubString = -1;

    if (s.length() < k) return -1; // Edge case: Not enough characters

    Map<Character, Integer> charMap = new HashMap<>();
    int i = 0, j = 0;

    while (j < s.length()) {
      // Expand the window
      charMap.put(s.charAt(j), charMap.getOrDefault(s.charAt(j), 0) + 1);

      // If we have more than K distinct characters, shrink the window
      while (charMap.size() > k) {
        charMap.put(s.charAt(i), charMap.get(s.charAt(i)) - 1);
        if (charMap.get(s.charAt(i)) == 0) {
          charMap.remove(s.charAt(i));
        }
        i++;
      }

      // If we have exactly K distinct characters, update the result
      if (charMap.size() == k) {
        longestSubString = Math.max(longestSubString, j - i + 1);
      }

      j++;
    }

    return longestSubString;
  }

  public static void main(String[] args) {
    System.out.println(longestKSubstr("aabacbebebe", 3)); // Output: 7 ("cbebebe")
    System.out.println(longestKSubstr("aaaa", 2)); // Output: -1 (only 1 distinct character)
    System.out.println(longestKSubstr("abcabc", 2)); // Output: 2 (longest "ab" or "bc")
  }
}
