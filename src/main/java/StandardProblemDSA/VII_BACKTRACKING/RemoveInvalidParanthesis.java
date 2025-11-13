package StandardProblemDSA.VII_BACKTRACKING;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveInvalidParanthesis {
  /**
   * Problem: Remove the minimum number of invalid parentheses to make the input string valid and
   * print all possible valid results. Example: "()())()" -> ["()()()", "(())()"]
   *
   * <p>Pattern: Breadth-First Search (BFS) for level-wise removal of parentheses, using a visited
   * set to avoid duplicates.
   *
   * <p>Follow-ups: 1. Solve using DFS + backtracking to generate valid strings. 2. Return only one
   * valid string with minimum removals. 3. Count the minimum removals without generating all valid
   * strings.
   *
   * <p>LeetCode Similar Problems: 301. Remove Invalid Parentheses, 1249. Minimum Remove to Make
   * Valid Parentheses
   *
   * <p>Time Complexity: O(N × 2^N) in the worst case (generate all substrings in BFS, each
   * validation O(N)). Space Complexity: O(N × 2^N) for the queue and visited set in the worst case.
   */

  // method checks if character is parenthesis(open
  // or closed)
  static boolean isParenthesis(char c) {
    return ((c == '(') || (c == ')'));
  }

  // method returns true if string contains valid
  // parenthesis
  static boolean isValidString(String str) {
    int cnt = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') cnt++;
      else if (str.charAt(i) == ')') cnt--;
      if (cnt < 0) return false;
    }
    return (cnt == 0);
  }

  // method to remove invalid parenthesis
  static void removeInvalidParenthesis(String str) {
    if (str.isEmpty()) return;

    // visit set to ignore already visited string
    HashSet<String> visit = new HashSet<String>();

    // queue to maintain BFS
    Queue<String> q = new LinkedList<>();
    String temp;
    boolean level = false;

    // pushing given string as
    // starting node into queue
    q.add(str);
    visit.add(str);
    while (!q.isEmpty()) {
      str = q.peek();
      q.remove();
      if (isValidString(str)) {
        System.out.println(str);

        // If answer is found, make level true
        // so that valid string of only that level
        // are processed.
        level = true;
      }
      if (level) continue;
      for (int i = 0; i < str.length(); i++) {
        if (!isParenthesis(str.charAt(i))) continue;

        // Removing parenthesis from str and
        // pushing into queue,if not visited already
        temp = str.substring(0, i) + str.substring(i + 1);
        if (!visit.contains(temp)) {
          q.add(temp);
          visit.add(temp);
        }
      }
    }
  }

  // Driver Code
  public static void main(String[] args) {
    String expression = "()())()";
    removeInvalidParenthesis(expression);

    expression = "()v)";
    removeInvalidParenthesis(expression);
  }
}
