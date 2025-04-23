package StandardProblemDSA.XVI_TRIE;

// create the node of the trie
class TrieNod {
  TrieNod links[] = new TrieNod[26];
  // here for counting things we need
  // to strore end with and prefix count
  int cntEndWith = 0;
  int cntPrefix = 0;

  boolean containsKey(char ch) {
    return (links[ch - 'a'] != null); //  check the end should nnot point to null character
  }

  TrieNod get(char ch) {
    return links[ch - 'a'];
  }

  void put(char ch, TrieNod node) {
    links[ch - 'a'] = node;
  }

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

public class TrieWithCountDelete {
  TrieNod root;

  // four funciton
  TrieWithCountDelete() {
    this.root = new TrieNod();
  }

  void insert(String word) {
    // initialise the root node
    TrieNod rootNode = root;
    for (int ch = 0; ch < word.length(); ch++) {
      // check if the character is not present create
      // a new trienode with the current node as reference
      char currCh = word.charAt(ch);
      if (!rootNode.containsKey(currCh)) {
        // create the new trie node
        rootNode.put(currCh, new TrieNod());
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
    TrieNod rootNode = root;
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
    TrieNod rootNode = root;
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
    TrieNod rootNode = root;
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
