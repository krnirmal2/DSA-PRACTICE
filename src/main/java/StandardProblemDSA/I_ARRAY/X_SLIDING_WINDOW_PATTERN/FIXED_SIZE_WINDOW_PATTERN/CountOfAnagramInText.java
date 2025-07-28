package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

import StandardProblemDSA.Utility;

import java.util.HashMap;
import java.util.Map;

/*
Question:
Given a text string and a pattern string, count how many substrings of the text are anagrams of the pattern.
Two strings are anagrams if they contain the same characters in the same frequency.

Example:
Input: text = "cbaebabacd", pattern = "abc"
Output: 2
Explanation: The anagram substrings are "cba" (index 0–2) and "bac" (index 6–8).

Approach:
1. Use the sliding window pattern with a fixed window size = length of the pattern.
2. Maintain two frequency maps:
   - patternMap → frequency of characters in the pattern.
   - windowMap → frequency of characters in the current window of the text.
3. Expand the window by adding one character at a time.
4. When the window size reaches pattern length:
   - Compare windowMap with patternMap.
   - If equal, increment the count (anagram found).
   - Remove the first character of the current window (shrink from the left).
5. Continue until the end of the text.

Pattern:
- Sliding Window (Fixed Size) + Hash Map for character frequency matching.

Time Complexity:
- O(n * k) in the worst case due to map comparisons, where n = text length, k = pattern length.
- Optimized versions can achieve O(n) using an integer frequency array.

Space Complexity:
- O(1) if the character set is fixed (e.g., lowercase English letters).

Follow-up Questions:
1. How to optimize map comparison to achieve O(n)?
2. How would you handle cases where text or pattern contains Unicode characters?
3. Can you find all starting indices of anagrams instead of just the count?
4. How would you solve this without using extra space for a map?

Similar LeetCode/Interview Questions:
- LeetCode 438. Find All Anagrams in a String
- LeetCode 567. Permutation in String
- LeetCode 76. Minimum Window Substring (variation of sliding window)
*/

public class CountOfAnagramInText {
  public static int countOfAnagram(String text, String pattern) {
    // Edge case when pattern length is less than the text then no anagram
    // then return 0
    if (text.length() < pattern.length() || text.length() == 0) return 0;

    // Window size will be length of pattern
    int k = pattern.length();
    int count = 0;

    // Approach
    // 1. create  Frequency map of pattern for put the character and its count
    Map<Character, Integer> patternMap = Utility.getCharFrequencyOfString(pattern);

    // 2. create ann new  map for the each window of size k
    // and when it reaches the k length characters
    // 3. now we will check both the map are equal or not if equals then
    // increase the count ;
    // 4. after that we will we will remove the first character from the map
    // by reducing the character count of the character at i
    Map<Character, Integer> windowMap = new HashMap<>();
    int i = 0, j = 0;

    while (j < text.length()) {
      // CASE 1: Expand window by put character on by one
      // put the character and its count in the map
      char ch = text.charAt(j);
      windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

      // CASE 2: When window size reaches size k then we will check
      if (j - i + 1 == k) {
        // Check if both maps are equal (i.e., anagram found)
        if (windowMap.equals(patternMap)) {
          count++;
        }
        // CASE 3: SHRINK WINDOW SIZE BY REMOVING THE CHARACTER FREQUNECY FROM THE MAP
        // Remove first character of the window
        char startChar = text.charAt(i);
        windowMap.put(startChar, windowMap.get(startChar) - 1);
        if (windowMap.get(startChar) == 0) {
          windowMap.remove(startChar);
        }
        i++; // Slide the window
      }
      j++; // Expand the window
    }

    return count;
  }

  public static void main(String[] args) {
    String text = "cbaebabacd";
    String pattern = "abc";
    System.out.println(countOfAnagram(text, pattern)); // Output: 2
  }
}
