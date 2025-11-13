package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.LongestWindow;

import java.util.HashMap;
import java.util.Map;

/*
------------------------------------------------------
Question (Interviewer-style)
------------------------------------------------------
"Given a string s, find the length of the longest substring
 without repeating characters."

Example:
Input:  s = "abcabcbb"
Output: 3
Explanation: "abc" is the longest substring without duplicates.

------------------------------------------------------
Pattern
------------------------------------------------------
Pattern Name: Variable Size Sliding Window + HashMap
- Maintain a window with unique characters.
- Expand right pointer to include characters.
- If a character repeats, shrink left pointer until the substring is unique again.

Key Idea:
- Use a HashMap to track the frequency of each character in the current window.
- The window always satisfies the "no duplicates" constraint.

------------------------------------------------------
Optimal Approach (O(n) time)
------------------------------------------------------
1. Initialize i = 0 (left), j = 0 (right), longest = 0, Map<Character, Integer>.
2. Expand right pointer j:
   - Add s[j] to map, increment its count.
3. If s[j] appears more than once:
   - Shrink window from left (i++) until all characters are unique.
4. Update longest = max(longest, j - i + 1).
5. Return longest.

------------------------------------------------------
Follow-up Questions
------------------------------------------------------
1. What if we need the substring itself, not just length?
   - Track start and end indices when updating longest.
2. Can we solve it with an array instead of HashMap?
   - Yes, if s consists of ASCII characters (size 128 array).
3. How to modify if we allow at most K duplicates?
   - Use a counter to track duplicates and adjust shrinking logic.

------------------------------------------------------
Similar LeetCode Problems
------------------------------------------------------
- LeetCode 3 – Longest Substring Without Repeating Characters
- LeetCode 159 – Longest Substring with At Most Two Distinct Characters
- LeetCode 340 – Longest Substring with At Most K Distinct Characters

------------------------------------------------------
Time & Space Complexity
------------------------------------------------------
- Time: O(n) – Each character is visited at most twice.
- Space: O(k) – k is the size of the character set in use.
*/

public class LongestSubStringUniqueCharacter {
  public static int lengthOfLongestSubstring(String s) {
    int longestSubString = 0;

    if (s.length() == 0) return 0; // Edge case: Empty string
    if (s.length() == 1) return 1; // Edge case: Single character

    Map<Character, Integer> charMap = new HashMap<>();
    int i = 0, j = 0;

    while (j < s.length()) {
      // Expand the window
      charMap.put(s.charAt(j), charMap.getOrDefault(s.charAt(j), 0) + 1);

      // If a character appears more than once, shrink the window from 'i'
      while (charMap.get(s.charAt(j)) > 1) {
        charMap.put(s.charAt(i), charMap.get(s.charAt(i)) - 1);
        if (charMap.get(s.charAt(i)) == 0) {
          charMap.remove(s.charAt(i));
        }
        i++; // Move left pointer to remove duplicates
      }

      // Update longest substring length
      longestSubString = Math.max(longestSubString, j - i + 1);

      j++; // Expand right pointer
    }

    return longestSubString;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3
    //        System.out.println(sol.lengthOfLongestSubstring("bbbbb")); // Output: 1
    //        System.out.println(sol.lengthOfLongestSubstring("pwwkew")); // Output: 3
    //        System.out.println(sol.lengthOfLongestSubstring("dvdf")); // Output: 3
  }
}
