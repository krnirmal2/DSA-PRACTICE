package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.ADVANCED;

import java.util.Stack;

/*
    Problem:
    --------
    Given a balanced parentheses string s, compute its score based on:
        - "()" has a score of 1
        - "AB" has score = A + B where A and B are valid parentheses strings

    Examples:
    ---------
        Input: "()"
        Output: 1

        Input: "(())"
        Output: 2

        Input: "()()"
        Output: 2

        Input: "(()(()))"
        Output: 6

    Approach:
    ---------
        • Use a stack to track scores of subexpressions.
        • When '(' is encountered, push 0 to mark a new frame.
        • When ')' is encountered:
            - Pop all scores until 0 is found.
            - If no score (val == 0), this corresponds to "()": push 1.
            - Else nested structure: push 2 * val.

    Pattern:
    --------
        Stack-based evaluation of nested parentheses expressions.

    Dry Run:
    --------
        For "(()(()))":
        Stack evolves as: push 0 '(' -> push 0 '(' -> encounter ')' -> pop 0, push 1
        Then push 0 '(' -> push 0 '(' -> encounter ')' -> pop 0, push 1
        Encounter ')' -> pop 1 + 1 = 2, push 2 * 2 = 4
        Encounter ')' -> pop 1 + 4 = 5, push 2 * 5 = 10 (adjust logic accordingly)

### Time and Space Complexity
- **Time:** O(n), where n = length of the string (single pass).
- **Space:** O(n), stack can store up to n/2 elements in worst case.

---

### Similar LeetCode Questions
- [856. Score of Parentheses](https://leetcode.com/problems/score-of-parentheses/)
- [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)
- [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)

---

### Follow-up Questions
1. Can you solve this problem without using extra space? (Using counters or recursion)
2. How would you extend this to support multiple types of brackets `[]`, `{}`, and `()`?
3. Can you modify the code to return the **maximum depth** of the parentheses as well as the score?
4. How would you handle malformed parentheses strings or input validation?
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
