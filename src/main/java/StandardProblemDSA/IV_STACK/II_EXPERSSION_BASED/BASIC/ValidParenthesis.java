package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.BASIC;

import java.util.Stack;

public class ValidParenthesis {
  public static void main(String[] args) {
    String[] testCases = {
      "()", // ✅ true
      "()[]{}", // ✅ true
      "(]", // ❌ false
      "([)]", // ❌ false
      "{[]}", // ✅ true
      "", // ✅ true (empty is valid)
      "((()))", // ✅ true
      "({[()]})", // ✅ true
      "((())", // ❌ false
      "((({{{[[[", // ❌ false
      ")))", // ❌ false
      "[({})](())", // ✅ true
      "[({)}]", // ❌ false
    };

    for (String test : testCases) {
      System.out.println("Input: " + test + " → " + isValid(test));
    }
    int i = 0;
  }

  /*### Problem
  Check if a string containing brackets `()`, `{}`, `[]` is **valid**, i.e., all opening brackets are properly closed in the correct order.
  ### Approach
  - Use a stack to track opening brackets:
    - Push `'('`, `'{'`, `'['` onto the stack.
    - When encountering a closing bracket `')'`, `'}'`, `']'`:
      - If stack is empty → invalid (no matching opening).
      - Pop the top and check if it matches the corresponding opening bracket.
      - If not matching → invalid.
  - At the end, if stack is empty → valid; else invalid.

  ### Time and Space Complexity
  - Time: **O(n)** — single pass through the string.
  - Space: **O(n)** — worst case all characters are opening brackets and get pushed.

  ---

  ### Similar LeetCode Questions
  - [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) :DONE
  - [921. Minimum Add to Make Parentheses Valid](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/) (DONE)
  - [1541. Minimum Insertions to Balance a Parentheses String](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)

  ---

  ### Follow-up Questions
  1. How would you extend this to support strings with wildcard characters like `*`?
  2. Can you return the position of the first invalid bracket?
  3. How to validate a string with additional types of brackets or paired delimiters?

  */

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c); // Push opening brackets
      } else {

        if (stack.isEmpty()) return false;

        char top = stack.pop();
        if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
          return false;
        }
      }
    }
    return stack.isEmpty(); // Valid if stack is empty
  }
}
