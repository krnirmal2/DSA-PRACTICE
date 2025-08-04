package StandardProblemDSA.XVI_TRIE;

/*
    Trie Node Implementation

    Problem:
    --------
    Design a node structure for a Trie (Prefix Tree) that supports:
        • Storing 26 lowercase English characters.
        • Tracking whether a word ends at the current node.
        • Keeping count of words ending at this node and prefixes passing through it.

    Components:
    -----------
    1. links[26] – Array of child TrieNodes for 'a' to 'z'.
    2. flag      – Boolean indicating if a word ends at this node.
    3. cntEndWith – Number of words that end at this node.
    4. cntPrefix  – Number of words sharing this prefix up to this node.

    Helper Methods:
    ---------------
    • containsKey(ch) – Checks if a child node for character ch exists.
    • get(ch)         – Retrieves the child node for character ch.
    • put(ch, node)   – Creates a link to the given node for character ch.
    • setEnd()        – Marks the node as the end of a word.
    • isEnd()         – Returns whether this node marks the end of a word.
    • incrementEnd(), deleteEnd(), getEnd() – Manage word-end counts.
    • incrementPrefix(), reducePrefix(), getCntPrefix() – Manage prefix counts.

    Usage:
    ------
    • Forms the building block for Trie operations:
        - Insertion: update cntPrefix and cntEndWith.
        - Search: traverse using containsKey() and get().
        - Deletion: decrease cntPrefix and cntEndWith appropriately.

    Pattern:
    --------
    • Trie Data Structure – Prefix-based storage and lookup.

    Complexity:
    -----------
    • Space: O(26 * n) in worst case for n inserted words (one node per character).
    • Time per operation: O(L) where L is the length of the word/prefix.

    Follow-ups:
    -----------
    1. Extend TrieNode to support:
        - Case-insensitive storage.
        - Unicode characters (use HashMap instead of array).
    2. Support auto-complete by storing frequency counts or lists of words.
    3. Implement compressed Tries (Radix Trees) for space optimization.

    Related Problems:
    -----------------
    • LeetCode 208 – Implement Trie (Prefix Tree)
    • LeetCode 211 – Add and Search Word – Data structure design
    • LeetCode 677 – Map Sum Pairs
*/

// create the node of the trie
public class TrieNode {
  // Array of Trienode which contain all the 26 character in each trienode
  TrieNode[] links = new TrieNode[26];
  boolean flag = false;

  boolean containsKey(char ch) {
    return (links[ch - 'a'] != null); //  check the end should nnot point to null character
  }

    // get the character position in the Trinode array if present with character
  TrieNode get(char ch) {
    return links[ch - 'a'];
  }

    // put the character and next node by assigning in the linked array
  void put(char ch, TrieNode node) {
    links[ch - 'a'] = node;
  }

  // if exist then set the end flag as true
  void setEnd() {
    flag = true;
  }

  // if we reached to the end then return current status of flag
  boolean isEnd() {
    return flag;
  }

  // here for counting things we need
  // to strore end with and prefix count
  int cntEndWith = 0;
  int cntPrefix = 0;

  void incrementEnd() {
    cntEndWith++;
  }

  void incrementPrefix() {
    cntPrefix++;
  }

  void deleteEnd() {
    cntEndWith--;
  }

  public int getEnd() {
    return cntEndWith;
  }

  public int getCntPrefix() {
    return cntPrefix;
  }

  public void reducePrefix() {
    cntPrefix--;
  }
}
