package StandardProblemDSA.II_STRING.IV_LONGEST_SUBSTRING_PROBLEM;

import java.util.HashMap;

/**
 * Problem: Find the length of the longest substring containing at most K distinct characters.
 * Example: s = "eceba", k = 2 → "ece" (length 3).
 *
 * <p>Pattern: Sliding Window + HashMap to track character frequencies and maintain at most K unique
 * chars.
 *
 * <p>Follow-ups: 1. Find the longest substring with exactly K distinct characters. 2. Modify to
 * return the substring itself, not just its length. 3. Optimize for large alphabets using arrays
 * instead of HashMaps.
 *
 * <p>LeetCode Similar Problems: 340. Longest Substring with At Most K Distinct Characters, 159.
 * Longest Substring with At Most Two Distinct Characters
 *
 * <p>Time Complexity: O(N) — each character processed at most twice (expand and shrink window).
 * Space Complexity: O(K) — HashMap stores at most K distinct characters.
 */
public class LongestSubstringAtMostKUniqueCharacter {
  // similar of same like subarray with atmmost k unique element or integer
  public static int LongestSubstringAtMostKUniqueCharacter(String s, int k) {
    if (s.isEmpty() || k == 0) return 0; // Edge case: Empty string or k = 0

    HashMap<Character, Integer> charMap = new HashMap<>();
    int left = 0, right = 0;
    int maxLength = 0;

    while (right < s.length()) {
      // Expand the window by adding the rightmost character
      charMap.put(s.charAt(right), charMap.getOrDefault(s.charAt(right), 0) + 1);

      // If we exceed K unique characters, shrink the window
      while (charMap.size() > k) {
        charMap.put(s.charAt(left), charMap.get(s.charAt(left)) - 1);
        if (charMap.get(s.charAt(left)) == 0) {
          charMap.remove(s.charAt(left)); // Remove character when count is zero
        }
        left++; // Move left pointer to shrink the window
      }

      // Update the maximum length
      maxLength = Math.max(maxLength, right - left + 1);
      right++; // Expand the window
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(
        "Longest Substring Length (At Most K): "
            + LongestSubstringAtMostKUniqueCharacter("aabacbebebe", 3)); // Output: 9
  }
}
