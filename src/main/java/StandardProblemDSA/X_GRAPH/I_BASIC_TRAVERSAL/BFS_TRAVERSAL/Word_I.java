package StandardProblemDSA.X_GRAPH.I_BASIC_TRAVERSAL.BFS_TRAVERSAL;

import java.util.*;

/*127. Word Ladder
Solved
Hard
Topics
Companies
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.



Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.


Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.


🔍 Approach: BFS (Shortest Path in an Unweighted Graph)
- Treat each word as a node in a graph.
- An edge exists between two words if they differ by exactly one character.
- Use BFS to ensure the shortest path is found.

✅ Steps:
1. Convert `wordList` to a set for O(1) lookup.
2. Start BFS with `beginWord`.
3. For each word, change each character (a-z) and check if the new word exists in `wordList`.
4. If `endWord` is found, return the current level (number of transformations).
5. Mark visited words to prevent cycles.

⏱️ Time Complexity:
- O(N * L^2)
  - N = number of words in `wordList`
  - L = length of each word (since for each word we try changing each character to 26 letters).

📦 Space Complexity: O(N)
- For `visited` set and BFS queue.

📘 Similar LeetCode Problem:
- 127. Word Ladder

🔁 Pattern:
- BFS for shortest path in transformation graph.
- Generate neighbors by changing one letter at a time.

🔄 Follow-up:
- Optimize by using bidirectional BFS to reduce search space.*/

public class Word_I {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    if (!set.contains(endWord)) return 0;

    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);

    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    int changes = 1;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        if (word.equals(endWord)) return changes;

        for (int j = 0; j < word.length(); j++) {
          for (int k = 'a'; k <= 'z'; k++) {
            char[] arr = word.toCharArray();
            arr[j] = (char) k;

            String str = new String(arr);
            if (set.contains(str) && !visited.contains(str)) {
              queue.add(str);
              visited.add(str);
            }
          }
        }
      }
      ++changes;
    }
    return 0;
  }
}
