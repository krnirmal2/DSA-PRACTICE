package StandardProblemDSA.XVI_TRIE;

import java.util.ArrayList;
import java.util.List;

// create the node of the trie
class TrieNode {
  TrieNode links[] = new TrieNode[26];
  boolean flag = false;

  boolean containsKey(char ch) {
    return (links[ch - 'a'] != null); //  check the end should nnot point to null character
  }

  TrieNode get(char ch) {
    return links[ch - 'a'];
  }

  void put(char ch, TrieNode node) {
    links[ch - 'a'] = node;
  }

  void setEnd() {
    flag = true;
  }

  boolean isEnd() {
    return flag;
  }
}

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // insert a word in to the trie O(length of the Word)
  void insert(String word) {

    TrieNode newNode = root;
    for (int ch = 0; ch < word.length(); ch++) {
      // we check if the trie node contain the character of the word or not
      // if not put new character to it
      if (!newNode.containsKey(word.charAt(ch))) {
        newNode.put(word.charAt(ch), new TrieNode()); // need to create new reference after insert
      }
      // move to new reference current trie node
      newNode = newNode.get(word.charAt(ch));
    }
    // at last  after creating the trie node
    // need the flag to be set to true
    newNode.setEnd();
  }

  // search from the rooot node always O(length of the Word)
  public boolean search(String word) {
    // from root node to compare each character
    TrieNode node = root;
    for (int ch = 0; ch < word.length(); ch++) {
      if (!node.containsKey(word.charAt(ch))) {
        return false;
      }
      // if present then give the next node
      node = node.get(word.charAt(ch));
    }

    if (node.isEnd()) {
      return true;
    }
    return false;
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

  public int countWordsEqualTo(String word) {
    // Write your code here.<
    int count = 0;
    TrieNode rootNode = root;
    for (int ch = 0; ch < word.length(); ch++) {
      if (!rootNode.containsKey(word.charAt(ch))) {
        return count;
      }
      rootNode = rootNode.get(word.charAt(ch));
    }
    if (rootNode.isEnd() || rootNode.links != null) {
      count++;
    }
    return count;
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
