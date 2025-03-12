package StandardProblemDSA.ARRAY.SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAtmostKDistinctCharacter {
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
