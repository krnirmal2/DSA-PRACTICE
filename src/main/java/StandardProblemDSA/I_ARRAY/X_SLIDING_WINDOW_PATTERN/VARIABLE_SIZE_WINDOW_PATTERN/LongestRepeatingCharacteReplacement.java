package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN;

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
    There may exists other ways to achieve this answer too.*/
    if (s.length() > k) return s.length();
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
      if ((j - i + 1) - maxFrequecy > k) {

        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        i++;
      }
      longSubStringWithRepeatingCh = Math.max(longSubStringWithRepeatingCh, (j - i + 1));
    }
    return longSubStringWithRepeatingCh;
  }

  public static void main(String[] args) {

    System.out.println(characterReplacement("ABAB", 2)); // Output: 4
    //        System.out.println(sol.characterReplacement("AABABBA", 1)); // Output: 4
    //        System.out.println(sol.characterReplacement("AAABBC", 2)); // Output: 5
  }
}
