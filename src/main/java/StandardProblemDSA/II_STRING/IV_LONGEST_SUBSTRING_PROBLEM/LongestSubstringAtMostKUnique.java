package StandardProblemDSA.II_STRING.IV_LONGEST_SUBSTRING_PROBLEM;

import java.util.HashMap;

public class LongestSubstringAtMostKUnique {
  public static int longestSubstringAtMostK(String s, int k) {
    if (s.length() == 0 || k == 0) return 0; // Edge case: Empty string or k = 0

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
            + longestSubstringAtMostK("aabacbebebe", 3)); // Output: 9
  }
}
