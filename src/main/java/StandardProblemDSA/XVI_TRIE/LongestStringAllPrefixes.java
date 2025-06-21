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

				Explanation: Insert Operations: “apple”, “apps” and “apxl” are inserted. */
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
