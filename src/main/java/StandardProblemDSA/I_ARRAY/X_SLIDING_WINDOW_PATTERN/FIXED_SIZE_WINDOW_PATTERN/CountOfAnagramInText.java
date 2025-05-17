package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.FIXED_SIZE_WINDOW_PATTERN;

import StandardProblemDSA.Utility;

import java.util.HashMap;
import java.util.Map;

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

      //CASE 2: When window size reaches size k then we will check
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
