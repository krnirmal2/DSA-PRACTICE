package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.ADVANCED;

import java.util.*;

/*✅ Problem 6: Remove Invalid Parentheses (Minimal Deletions)
🔹 Problem Statement
You are given a string s containing parentheses and possibly other characters.
Your task is to remove the minimum number of invalid parentheses to make the string valid, and return all possible results.

You may return the answers in any order.
Only minimal removals are allowed.


 Approach:
    ---------
    • Use **BFS** (Breadth-First Search):
        - Generate all possible strings by removing one parenthesis at a time.
        - The first valid strings found correspond to the minimum number of deletions.
    • Use a queue for BFS traversal and a set to avoid duplicates.
    • Stop exploring further levels once valid strings are found.

    Pattern:
    --------
    BFS + String Generation + Parentheses Validation.

    Dry Run:
    --------
        Input: "()())()"
        Level 0: "()())()" → invalid.
        Level 1: remove one character → ["())()", "()()()", "())))()"...]
        Valid: "()()()", "(())()".
        Stop here (minimal deletions).

    Time Complexity:
    ----------------
        • O(N * 2^N) worst case — generate all possible substrings.
        • Optimized by BFS — stop at minimal deletions.

    Space Complexity:
    -----------------
        • O(N * 2^N) for queue + set.

    Follow-ups:
    -----------
        1. Can we optimize to use DFS with pruning?
        2. How to handle additional types of brackets?
        3. Can we count minimal deletions without generating all results?

    Related Problems:
    -----------------
        • Valid Parentheses
        • Minimum Remove to Make Valid Parentheses
        • Generate Parentheses*/
public class RemoveInvalidParentheses {
  /*  🔍 Approach: BFS (Breadth-First Search)
  Why BFS?
  Because we want the first level where a valid string appears — that ensures minimum removals.
          🧠 Algorithm:
  Use a queue for level-wise traversal.
  At each level, remove one parenthesis from each string.
  If any of those is valid — add to result & stop further exploration at deeper levels.
  Use a HashSet to avoid duplicates.*/
  public List<String> removeInvalidParentheses(String s) {
    List<String> result = new ArrayList<>();
    if (s == null) return result;

    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();

    queue.add(s);
    visited.add(s);
    boolean found = false;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        if (isValid(curr)) {
          result.add(curr);
          found = true;
        }
        if (found) continue; // skip deeper levels

        for (int j = 0; j < curr.length(); j++) {
          if (curr.charAt(j) != '(' && curr.charAt(j) != ')') continue;
          String next = curr.substring(0, j) + curr.substring(j + 1);
          if (!visited.contains(next)) {
            queue.add(next);
            visited.add(next);
          }
        }
      }

      if (found) break;
    }

    return result;
  }

  private boolean isValid(String s) {
    int count = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') count++;
      else if (c == ')') {
        if (count == 0) return false;
        count--;
      }
    }
    return count == 0;
  }
  /* 🧪 Dry Run
  Input: "()())()"
  Level 0: ["()())()"]
  Level 1: remove one paren:
          ")())()", "()())(", "())()", "(())()", "()()()", etc.
  First valid strings found: "()()()", "(())()"
          → Stop BFS at this level and return results ✅
          ⏱️ Time & Space Complexity
  Time: Exponential in worst case but efficient due to BFS + visited set

  Space: O(n × k) where n = length of input, k = number of valid results*/
  /*   Input: "()())()"
      Output: ["(())()", "()()()"]

      Input: "(a)())()"
      Output: ["(a())()", "(a)()()"]

      Input: ")("
      Output: [""]
  */
}
