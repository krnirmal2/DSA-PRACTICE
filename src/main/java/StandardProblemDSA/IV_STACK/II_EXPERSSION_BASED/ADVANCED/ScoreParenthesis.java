package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.ADVANCED;

import java.util.*;

/*
📜 Statement:
Given a balanced parentheses string s, compute the score as per the following rules:
        "()" has a score of 1
        "AB" has a score of A + B, where A and B are valid parentheses strings

Input: "()"
Output: 1

Input: "(())"
Output: 2

Input: "()()"
Output: 2

Input: "(()(()))"
Output: 6


*/

public class ScoreParenthesis {
  /*  🧠 Approach 1: Using Stack (Most Intuitive)
  We process characters one by one:
  Push 0 to represent a new inner frame when ( is seen.
          When we encounter ), we:
  If top is 0 → it's a simple "()" → score = 1.
  Else → nested → score = 2 × innerScore.*/

  public int scoreOfParentheses(String s) {
    Stack<Integer> stack = new Stack<>();

    for (char ch : s.toCharArray()) {
      if (ch == '(') {
        stack.push(0); // mark start of new subexpression
      } else {
        int val = 0;
        while (stack.peek() != 0) {
          val += stack.pop();
        }
        stack.pop(); // remove the 0
        stack.push(val == 0 ? 1 : 2 * val);
      }
    }

    int score = 0;
    while (!stack.isEmpty()) {
      score += stack.pop();
    }
    return score;
  }
  /*🧠 Time & Space Complexity:
  Time: O(n)

  Space: O(n) (stack)

  */
}
/*
public int scoreOfParentheses(String s) {
    int score = 0, depth = 0;

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            depth++;
        } else {
            depth--;
            if (s.charAt(i - 1) == '(') {
                score += 1 << depth; // 2^depth
            }
        }
    }
    return score;
}
*/
