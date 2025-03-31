package StandardProblemDSA.X_GRAPH.I_BASIC_TRAVERSAL.BFS_TRAVERSAL;

import java.util.*;

public class Word_II {
  /*126. Word Ladder II
  Attempted
  Hard
  Topics
  Companies
  A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

  Every adjacent pair of words differs by a single letter.
  Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
  sk == endWord
  Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].



  Example 1:

  Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
  Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
  Explanation: There are 2 shortest transformation sequences:
  "hit" -> "hot" -> "dot" -> "dog" -> "cog"
  "hit" -> "hot" -> "lot" -> "log" -> "cog"
  Example 2:

  Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
  Output: []
  Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


  Constraints:

  1 <= beginWord.length <= 5
  endWord.length == beginWord.length
  1 <= wordList.length <= 500
  wordList[i].length == beginWord.length
  beginWord, endWord, and wordList[i] consist of lowercase English letters.
  beginWord != endWord
  All the words in wordList are unique.
  The sum of all shortest transformation sequences does not exceed 105.*/

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    List<List<String>> result = new ArrayList<>();

    if (!wordSet.contains(endWord)) return result; // No path possible

    Map<String, List<String>> graph = new HashMap<>(); // Adjacency list
    Set<String> startSet = new HashSet<>(), endSet = new HashSet<>();
    startSet.add(beginWord);
    endSet.add(endWord);
    boolean found = bidirectionalBFS(wordSet, startSet, endSet, graph, false);

    if (found) {
      List<String> path = new ArrayList<>();
      path.add(beginWord);
      backtrack(result, graph, path, beginWord, endWord);
    }
    return result;
  }

  private boolean bidirectionalBFS(
      Set<String> wordSet,
      Set<String> startSet,
      Set<String> endSet,
      Map<String, List<String>> graph,
      boolean reversed) {
    if (startSet.isEmpty()) return false;

    if (startSet.size() > endSet.size())
      return bidirectionalBFS(wordSet, endSet, startSet, graph, !reversed);

    wordSet.removeAll(startSet);
    Set<String> nextLevel = new HashSet<>();
    boolean found = false;

    for (String word : startSet) {
      char[] arr = word.toCharArray();

      for (int i = 0; i < arr.length; i++) {
        char originalChar = arr[i];

        for (char c = 'a'; c <= 'z'; c++) {
          if (c == originalChar) continue;

          arr[i] = c;
          String newWord = new String(arr);

          if (wordSet.contains(newWord)) {
            nextLevel.add(newWord);

            String key = reversed ? newWord : word;
            String value = reversed ? word : newWord;
            graph.computeIfAbsent(key, k -> new ArrayList<>()).add(value);

            if (endSet.contains(newWord)) found = true;
          }
        }
        arr[i] = originalChar; // Restore the original character
      }
    }

    return found || bidirectionalBFS(wordSet, nextLevel, endSet, graph, reversed);
  }

  private void backtrack(
      List<List<String>> result,
      Map<String, List<String>> graph,
      List<String> path,
      String word,
      String endWord) {
    if (word.equals(endWord)) {
      result.add(new ArrayList<>(path));
      return;
    }

    if (!graph.containsKey(word)) return;

    for (String nextWord : graph.get(word)) {
      path.add(nextWord);
      backtrack(result, graph, path, nextWord, endWord);
      path.remove(path.size() - 1);
    }
  }
}
