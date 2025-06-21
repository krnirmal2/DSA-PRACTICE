package StandardProblemDSA.XVI_TRIE;

// create the node of the trie
// class TrieNode {
//  TrieNode[] links = new TrieNode[26];
//  // here for counting things we need
//  // to strore end with and prefix count
//  int cntEndWith = 0;
//  int cntPrefix = 0;
//
//  boolean containsKey(char ch) {
//    return (links[ch - 'a'] != null); //  check the end should nnot point to null character
//  }
//
//  TrieNode get(char ch) {
//    return links[ch - 'a'];
//  }
//
//  void put(char ch, TrieNode node) {
//    links[ch - 'a'] = node;
//  }
//
//
//
//
// }

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
