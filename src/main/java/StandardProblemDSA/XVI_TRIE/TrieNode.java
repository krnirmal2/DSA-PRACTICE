package StandardProblemDSA.XVI_TRIE;

// create the node of the trie
public class TrieNode {
  // Array of Trienode which contain all the 26 character in each trienode
  TrieNode[] links = new TrieNode[26];
  boolean flag = false;

  boolean containsKey(char ch) {
    return (links[ch - 'a'] != null); //  check the end should nnot point to null character
  }

  // get the character if present with character
  TrieNode get(char ch) {
    return links[ch - 'a'];
  }

  // put the character and next node by assigning
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
