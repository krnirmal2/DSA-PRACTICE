package StandardProblemDSA.XV_DYNAMMIC_PROGRAM;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
  /*139. Word Break
  Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
  Note that the same word in the dictionary may be reused multiple times in the segmentation.
  Example 1:
  Input: s = "leetcode", wordDict = ["leet","code"]
  Output: true
  Explanation: Return true because "leetcode" can be segmented as "leet code".
  Example 2:
  Input: s = "applepenapple", wordDict = ["apple","pen"]
  Output: true
  Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
  Note that you are allowed to reuse a dictionary word.
  Example 3:
  Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
  Output: false


  Constraints:

          1 <= s.length <= 300
          1 <= wordDict.length <= 1000
          1 <= wordDict[i].length <= 20
  s and wordDict[i] consist of only lowercase English letters.
  All the strings of wordDict are unique.*/
  class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

      // approach for the recursion is
      // check for the each character
      // and use substring should be present
      // for unique use set
      // put all words into a hashset
      Set<String> set = new HashSet<>(wordDict);
      return wb(s, set);
    }

    private boolean wb(String s, Set<String> set) {
      int len = s.length();
      if (len == 0) {
        return true;
      }
      for (int i = 1; i <= len; ++i) {
        if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
          return true;
        }
      }
      return false;
    }

    public static void main(String[] args) {
      /* s = "leetcode", wordDict = ["leet","code"]*/
    }
  }
}
