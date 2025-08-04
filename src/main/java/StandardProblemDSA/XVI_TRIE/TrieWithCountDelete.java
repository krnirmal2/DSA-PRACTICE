package StandardProblemDSA.XVI_TRIE;

/*
    Problem:
    --------
    Implement a Trie (Prefix Tree) with support for:
      • insert(word) – Adds a word into the Trie, tracking prefix and word counts.
      • countWordsEqualTo(word) – Returns how many times a given full word was inserted.
      • countWordStartingWith(prefix) – Returns how many words share the given prefix.
      • erase(word) – Removes one occurrence of a word, updating counts.

    Approach:
    ---------
    • Each TrieNode stores:
        - links[26] for child nodes
        - cntPrefix: how many words pass through this node
        - cntEndWith: how many words end at this node
    • insert():
        - For each character, create a node if missing, move down, increment cntPrefix.
        - After final character, increment cntEndWith.
    • countWordsEqualTo():
        - Traverse characters; if path breaks, return 0.
        - Return cntEndWith at final node.
    • countWordStartingWith():
        - Traverse prefix; if path breaks, return 0.
        - Return cntPrefix at final node.
    • erase():
        - Traverse characters; decrement cntPrefix for each node.
        - At end, decrement cntEndWith.

    Pattern:
    --------
    Trie Data Structure with counts and deletion.

    Time Complexity:
    ----------------
    • insert(), countWordsEqualTo(), countWordStartingWith(), erase() → O(L)
      where L = length of the word/prefix.

    Space Complexity:
    -----------------
    • O(26 × N × L) in worst case for N words of average length L.

    Follow-ups:
    -----------
    1. Handle case-insensitivity or Unicode characters by using HashMap instead of array.
    2. Auto-delete unused nodes for memory optimization.
    3. Extend to store frequency counts for autocomplete.

    Related Problems:
    -----------------
    • LeetCode 208 – Implement Trie
    • LeetCode 1804 – Implement Trie II (Prefix Tree)
*/

public class TrieWithCountDelete {
  TrieNode root;

  // four funciton
  TrieWithCountDelete() {
    this.root = new TrieNode();
  }

  void insert(String word) {
    // initialise the root node
    TrieNode rootNode = root;
    for (int ch = 0; ch < word.length(); ch++) {
      // check if the character is not present create
      // a new TrieNodee with the current node as reference
      char currCh = word.charAt(ch);
      if (!rootNode.containsKey(currCh)) {
        // create the new trie node
        rootNode.put(currCh, new TrieNode());
      }
      // else we will increase the prefix and update the root node
      rootNode = root.get(currCh);
      rootNode.incrementPrefix();
    }
    // when the word is actually set then we can say the word count has been set
    rootNode.incrementEnd();
  }

  // countwordsEqueal to a given word (whole word)
  int countWordsEqualTo(String word) {
    TrieNode rootNode = root;
    for (int ch = 0; ch < word.length(); ch++) {
      char currCh = word.charAt(ch);
      if (rootNode.containsKey(currCh)) {
        rootNode = root.get(currCh);
      } else {
        return 0;
      }
    }
    // at last the end count give the no. of word present
    return rootNode.getEnd();
  }

  // count prefix how many prsent
  int countWordStartingWith(String word) {
    TrieNode rootNode = root;
    for (int ch = 0; ch < word.length(); ch++) {
      char currCh = word.charAt(ch);
      if (rootNode.containsKey(currCh)) {
        rootNode = root.get(currCh);
      } else {
        return 0;
      }
    }
    // at last the end count give the no. of word present
    return rootNode.getCntPrefix();
  }

  // Delete a word from the trie , As lets say this is exist
  public void erase(String word) {
    TrieNode rootNode = root;
    for (int ch = 0; ch < word.length(); ch++) {
      char currCh = word.charAt(ch);
      if (rootNode.containsKey(currCh)) {
        rootNode = rootNode.get(currCh);
        rootNode.reducePrefix();
      } else {
        return;
      }
    }
    // at last when the count is zero
    // reduce endWithcnt value
    rootNode.deleteEnd();
  }
}
