package StandardProblemDSA.ARRAY.SLIDING_WINDOW_PATTERN;

import java.util.HashMap;
import java.util.Map;

public class CountOfAnagramInText {
    public static int countOfAnagram(String text, String pattern) {
        // Edge case
        if (text.length() < pattern.length() || text.length() == 0) return 0;

        // Window size will be length of pattern
        int k = pattern.length();
        int count = 0;

        // Frequency map of pattern
        Map<Character, Integer> patternMap = new HashMap<>();
        for (char ch : pattern.toCharArray()) {
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        // Sliding window
        Map<Character, Integer> windowMap = new HashMap<>();
        int i = 0, j = 0;

        while (j < text.length()) {
            char ch = text.charAt(j);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            // When window size reaches k
            if (j - i + 1 == k) {
                // Check if both maps are equal (i.e., anagram found)
                if (windowMap.equals(patternMap)) {
                    count++;
                }

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
