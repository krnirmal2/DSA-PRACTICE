package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN;

import java.util.HashMap;
import java.util.Map;

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

  public static class MiniSubArrayLengthOfSumK {
    /* Given an array of positive integers and a positive integer,
    write a function that returns the minimal length of a contiguous subarray,
    where the sum is greater than or equal to the integer being passed in.
    If there isn’t one, return 0.*/

    public static int minSubArrayLen(int[] arr, int target) {
      int minLength = Integer.MAX_VALUE;
      int sum = 0;
      int left = 0;
      int right = 0;

      while (left < arr.length) {
        if (sum >= target) {
          // store the current minimal length
          minLength = Math.min(minLength, (right - left));
          // shrink the window:
          // (1) subtract the value at left idx
          // (2) move the left panel one index further to the right
          sum -= arr[left];
          left++;
        } else if (sum < target && right < arr.length) {
          // expand the window:
          // (1) sum up the current value
          // (2) move the right panel one index further to the right
          sum += arr[right];
          right++;
        } else break;
      }

      return (minLength == Integer.MAX_VALUE ? 0 : minLength);
    }

    public static void main(String[] args) {
      int[] arr = {2, 3, 1, 2, 4, 3};
      int target = 1;
      System.out.println(minSubArrayLen(arr, target));
    }
  }
}
