package StandardProblemDSA.XVI_TRIE;

import java.util.List;

/*Implement Trie - II
Problem Statement: Implement a Trie data structure that supports the following methods:
Insert (word): To insert a string `word` in the Trie.
Count Words Equal To (word): Return the count of occurrences of the string word in the Trie.
Count Words Starting With (prefix): Return the count of words in the Trie that have the string “prefix” as a prefix.
Erase (word): Delete one occurrence of the string word from the Trie.
Note:

The Erase(word) function is guaranteed to be called only when a word is present in the Trie.
Release the memory associated with variables using dynamic memory allocation at the end of your solution.
Examples
                Example 1:
				Input:
				Insert: ‘apple’, ‘apps’, ‘apxl’
				Count Number of Words Equal to: ‘apple’
				Count Number of Words Starting with: ‘app’, ‘ap’
				Erase word: ‘apxl’

				Output:
				Inserted ‘apple’, Inserted ‘apps’,Inserted, ‘apxl’.
				Number of Words Equal to ‘apple’: 1
				Number of Words Starting with ‘app’: 2 and ‘ap’: 3
				Erased ‘apxl’

				Explanation: Insert Operations: “apple”, “apps” and “apxl” are inserted.

	  Approach:
    ---------
    • TrieNode stores:
        - links[26] to children (a-z)
        - boolean `isEnd` to mark end of a word
        - counters: `cntEndWith` (number of times word ends here), `cntPrefix` (prefix count).

    • completeString(prefix, list):
        - Iterate through all words.
        - For each word, check if all its prefixes exist in the Trie (`checkIfPrefixExist`).
        - Track the longest valid word.

    • checkIfPrefixExist(word):
        - Traverse the Trie character by character.
        - At each step, verify the node exists and `isEnd` is true.
        - Return true if all prefixes are valid.

    Pattern:
    --------
    Trie with count operations + "longest complete string" check.

    Time Complexity:
    ----------------
        • insert(), countWordsEqualTo(), countWordsStartingWith(), erase() → O(L)
          where L = length of the word/prefix.
        • completeString(): O(N × L) for N words of average length L.

    Space Complexity:
    -----------------
        • O(26 × N × L) in worst case (all unique paths).

    Follow-ups:
    -----------
    1. Fix `checkIfPrefixExist()` — must start from the actual Trie’s root, not `new TrieNode()`.
    2. Tie-breaking: if multiple strings have the same max length, pick lexicographically smallest.
    3. Support erase() with memory cleanup.

    Related Problems:
    -----------------
        • LeetCode 1804 – Implement Trie II (Prefix Tree)
        • "Longest Word in Dictionary" (LeetCode 720)
*/
public class LongestStringAllPrefixes {
  public static String completeString(String prefix, List<String> a) {
    // iterate over each string
    // if it is exist then we check the earlier length and the
    // current length of the string , if current length string is
    // greater then update the longest string and at last return the lenght of the
    // longest string length

    String longest = "";
    for (var it : a) {
      if (checkIfPrefixExist(it)) {
        //
        if (it.length() > longest.length()) {
          longest = it;
        } else if (it.length() == longest.length() && it.length() < longest.length()) {
          longest = it;
        }
      }
    }
    if (longest.equals("")) {
      return "none";
    }

    return longest;
  }

  private static boolean checkIfPrefixExist(String word) {
    TrieNode rootNod = new TrieNode();
    boolean flag = true;
    for (int ch = 0; ch < word.length(); ch++) {
      if (rootNod.containsKey(word.charAt(ch))) {
        rootNod = rootNod.get(word.charAt(ch));
        flag = flag & rootNod.isEnd();
      } else {
        return false;
      }
    }
    return flag;
  }
}
