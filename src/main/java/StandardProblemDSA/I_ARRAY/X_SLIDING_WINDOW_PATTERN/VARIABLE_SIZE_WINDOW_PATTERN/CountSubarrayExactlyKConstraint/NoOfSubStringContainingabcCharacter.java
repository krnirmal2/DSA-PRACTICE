package StandardProblemDSA.I_ARRAY.X_SLIDING_WINDOW_PATTERN.VARIABLE_SIZE_WINDOW_PATTERN.CountSubarrayExactlyKConstraint;

public class NoOfSubStringContainingabcCharacter {
  /*Given a string s consisting only of characters a, b and c.
  Return the number of substrings containing at least one occurrence of all these characters a, b and c.
  Example 1:
  Input: s = "abcabc"
  Output: 10
  Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
  Example 2:
  Input: s = "aaacb"
  Output: 3
  Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
  Example 3:

  Input: s = "abc"
  Output: 1


   */
  public int numberOfSubstrings(String s) {
    /*🧠 Why (s.length() - right)?
    ✅ Insight:
    Once we reach a window where the substring [left, right] contains all 3 characters,
    then every longer substring starting at left and ending at or after right is also valid.
    ✅ Example:
    Suppose:
    s =  "abcabc"
             ↑
          right = 3 (character = 'a')
          left = 0
    Substring: "abca" (from left = 0 to right = 3)
    → It has all 3 characters ✅
    Now, consider substrings that:
    Start at index left = 0
    End at any index from right = 3 to end of string (s.length() - 1 = 5)
    These are:
    s[0..3] → "abca"
    s[0..4] → "abcab"
    s[0..5] → "abcabc"

    That’s s.length() - right = 6 - 3 = 3 substrings
    ✅ All of them are valid and contain 'a', 'b', 'c'

    📦 In General:
    At any point when the window from left to right contains all 3 chars:
    answer += (s.length() - right);
    Because:
    Substrings: [left..right], [left..right+1], ..., [left..s.length()-1]
    Count = s.length() - right
    These substrings start at left and end at or beyond right
    All are guaranteed valid, since we are only appending more characters after an already valid base.

    ✅ Why Is This Efficient?
    Instead of checking each substring one by one, this line:
    answer += (s.length() - right);
    counts them all in constant time, which makes the solution O(n).*/
    int[] map = new int[3]; // for 'a', 'b', 'c'
    int left = 0, right = 0;
    int answer = 0;

    while (right < s.length()) {
      // Expand window: include current character
      char curr = s.charAt(right);
      map[curr - 'a']++;

      // Shrink window until it still contains all 3 characters
      while (map[0] > 0 && map[1] > 0 && map[2] > 0) { // frequency of a, b, c
        // All substrings from left to end at right are valid
        answer += (s.length() - right);

        // Shrink window from left
        char leftChar = s.charAt(left);
        map[leftChar - 'a']--; // reduce frequency
        left++;
      }

      right++;
    }

    return answer;
  }
  /* public int numberOfSubstrings(String s) {
      // use hashmap for character and its frequency
      Map<Character,Integer> map = new HashMap<>();
      int left=0,right=0;
      int answer =0;
      while(right<s.length() ){
          // expand phase
          map.put(s.charAt(right), map.getOrDefault(s.charAt(i),0)+1);

          //shrink phase
          if(map.size()==3){
              while( map.get(s.charAt(left)>0){
                  map.put(s.charAt(left), map.get(s.charAt(left)-1));
                  if( map.get(s.charAt(left)==0))map.remove(s.charAt(left));
                  answer++;
                    left++;
              }

          }
          right ++;

      }
      return answer;
  }*/
}
