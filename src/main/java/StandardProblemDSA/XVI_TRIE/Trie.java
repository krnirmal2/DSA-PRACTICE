package StandardProblemDSA.XVI_TRIE;

import java.util.ArrayList;
import java.util.List;

/*
    Problem:
    --------
    Implement a basic Trie (Prefix Tree) that supports:
      • insert(word) – Adds a word into the Trie.
      • search(word) – Returns true if the exact word exists in the Trie.
      • startsWith(prefix) – Returns true if there is any word in the Trie with the given prefix.
      • countWordsEqualTo(word) – (incorrect here) intended to count words equal to input, but current implementation only checks existence.

    Approach:
    ---------
    • Each TrieNode stores:
        - links[26] to children (a-z)
        - boolean flag `isEnd` indicating if a word ends at this node.
    • insert():
        - Traverse the word’s characters.
        - Create nodes if missing.
        - Mark the last node as `isEnd`.
    • search():
        - Traverse characters; return true only if `isEnd` is set at the end.
    • startsWith():
        - Traverse prefix; return true if traversal completes without missing nodes.
    • countWordsEqualTo():
        - Should return a count; but in current implementation, only checks existence.

    Pattern:
    --------
    Trie Data Structure – stores words character by character in a tree-like structure.

    Time Complexity:
    ----------------
    • insert(), search(), startsWith(), countWordsEqualTo() → O(L)
      where L = length of the input word or prefix.

    Space Complexity:
    -----------------
    • O(26 × N × L) in worst case for N words of average length L.

    Follow-ups:
    -----------
    1. Fix countWordsEqualTo() to return the number of times a word was inserted (requires count in TrieNode).
    2. Support delete(word) to remove words.
    3. Extend to handle case-insensitive or Unicode characters by using HashMap instead of array.

    Related Problems:
    -----------------
    • LeetCode 208 – Implement Trie (Prefix Tree)
    • LeetCode 1804 – Implement Trie II (Prefix Tree) with counts
*/

public class Trie {
  private final TrieNode root;

  // create a trienode on declaration
  public Trie() {
    root = new TrieNode();
  }

  // insert a word in to the trie O(length of the Word)
  void insert(String word) {
    // Step 1 : intialise the root node to the new trienode
    TrieNode newNode = root;
    // Step2 : iterate over the given string's character
    for (int ch = 0; ch < word.length(); ch++) {
      // Step 3 ;  we check if the trie node contain the character of the word or not
      // if not put new character to it
      // newNode have linked of character
      if (!newNode.containsKey(word.charAt(ch))) {
        newNode.put(word.charAt(ch), new TrieNode()); // need to create new reference after insert
      }
      // step 4 : move to new reference current trie node
      newNode = newNode.get(word.charAt(ch));
    }
    // Step 5 :  at last  after creating the trie node
    // need the flag to be set to true
    newNode.setEnd();
  }

  // search from the rooot node always O(length of the Word)
  public boolean search(String word) {
    // Step1 : Initialise the a new trinode with root node (global trie node which hold each
    // character)
    // from root node to compare each character
    TrieNode node = root;
    // Step 2: check string's character present in the global node or not
    for (int ch = 0; ch < word.length(); ch++) {
      // Step  3: if any character is not found return false else true;
      if (!node.containsKey(word.charAt(ch))) {
        return false;
      }
      // Step 4: else if present then give the next node
      node = node.get(word.charAt(ch));
    }
    // step 6: if we reached to the end then flag will return false or true
    return node.isEnd();
  }

  // Return if theere is any word in the trie that starts with the given prefix O(length of the
  // Word)

  public boolean startsWith(String prefix) {
    TrieNode rootNode = root;
    for (int ch = 0; ch < prefix.length(); ch++) {
      if (!rootNode.containsKey(prefix.charAt(ch))) {
        return false;
      }
      rootNode = rootNode.get(prefix.charAt(ch));
    }
    return true;
  }

  public void countWordsEqualTo(String word) {
    // Write your code here.<
    int count = 0;
    TrieNode rootNode = root;
    for (int ch = 0; ch < word.length(); ch++) {
      if (!rootNode.containsKey(word.charAt(ch))) {
        return;
      }
      rootNode = rootNode.get(word.charAt(ch));
    }
    if (rootNode.isEnd() || rootNode.links != null) {
      count++;
    }
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("apple");
    trie.insert("coding");
    trie.search("apple"); // return True
    trie.search("app"); // return False
    trie.startsWith("app"); // return True
    trie.insert("app");
    trie.countWordsEqualTo("coding");
    trie.search("app"); // return True
    List<String> a = new ArrayList<>();
    LongestStringAllPrefixes.completeString("hello", a);
  }
}
