package StandardProblemDSA.IV_STACK.II_EXPERSSION_BASED.INTERMEDIATE;

import java.util.Stack;

/*Approach
* For every opening parenthesis, we push its index onto the stack.
For every closing parenthesis,
  we pop the stack.
      If the stack becomes empty after popping,
         it means we’ve encountered an unmatched closing parenthesis,
         so we push the current index to serve as a base for the next potential valid substring.
      If the stack is not empty,
          we calculate the length of the valid substring by subtracting the index at the top of the stack from the current index.
           A variable maxLength keeps track of the maximum length of valid parentheses encountered during the traversal.*/
public class LongestValidParenthesesSubstring {
  /*
  Problem: Find the length of the longest valid (well-formed) parentheses substring in a given string.
  Pattern: Stack-based parentheses matching (track indices of unmatched parentheses).

  Time Complexity: O(n) — single pass through the string.
  Space Complexity: O(n) — stack stores indices of '(' and base markers.

  LeetCode Similar Questions:
  - 32. Longest Valid Parentheses : DONE
  - 20. Valid Parentheses : DONE
  - 301. Remove Invalid Parentheses:
  - 678. Valid Parenthesis String

  Follow-up Questions:
  - Solve using two-pass counters (left-to-right & right-to-left) without extra space.
  - Return all longest valid substrings, not just the length.
  - Handle strings with other types of brackets ({}, []).
  - Optimize for streaming input (real-time evaluation).
  */

  // ITERATE OVER THE EACH CHARACTER
  static int maxLength(String s) {
    Stack<Integer> stack = new Stack<>();

    // Push -1 as the initial index to
    // handle the edge case
    stack.push(-1);
    int maxLen = 0;

    // Traverse the string
    for (int i = 0; i < s.length(); i++) {

      // If we encounter an opening parenthesis,
      // push its index
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {

        // If ')' is encountered:,
        // pop the stack
        stack.pop(); // match with a '('

        // If stack is empty, push the current index
        // as a base for the next validbst suring
        if (stack.isEmpty()) {
          stack.push(
              i); // reset base when no matched found there will new base created for next valid
          // string
        } else {

          // Update maxLength with the current length
          // of the valid parentheses substring
          maxLen = Math.max(maxLen, i - stack.peek());
        }
      }
    }

    return maxLen;
    /*
    | Index | Char | Stack              | Action / Result            |
    | ----- | ---- | ------------------ | -------------------------- |
    | 0     | `)`  | [-1] → [] → [0]    | No match, push 0           |
    | 1     | `(`  | [0, 1]            | Push '(' index             |
    | 2     | `)`  | [0]               | Match found, max = 2 =max(0,2-0)      |
    | 3     | `(`  | [0, 3]            | Push '(' index             |
    | 4     | `)`  | [0]               | Match found, max = 4 ✅ =max(2,4-0)    |
    | 5     | `)`  | [] → [5]         | No match, reset base index |
    */
  }

  public static void main(String[] args) {
    String s = ")()())";
    System.out.println(maxLength(s));
  }
  /*
  public static int longestValidParentheses(String s) {
    int left = 0, right = 0, maxLen = 0;

    // Pass 1: Left to Right
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') left++;
      else right++;

      if (left == right) {
        maxLen = Math.max(maxLen, 2 * right);
      } else if (right > left) {
        left = right = 0;
      }
    }

    left = right = 0; // Reset for second pass

    // Pass 2: Right to Left
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '(') left++;
      else right++;

      if (left == right) {
        maxLen = Math.max(maxLen, 2 * left);
      } else if (left > right) {
        left = right = 0;
      }
    }

    return maxLen;
  }

  */
  /* static int maxLength(String s) {
      int maxLen = 0;

      // Left to Right Traversal
      int open = 0, close = 0;
      for (char ch : s.toCharArray()) {
          if (ch == '(') {
              open++;
          } else if (ch == ')') {
              close++;
          }

          if (open == close) {
              maxLen = Math.max(maxLen, 2 * close);
          } else if (close > open) {
              open = close = 0;
          }
      }

      // Right to Left Traversal
      open = close = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
          if (s.charAt(i) == '(') {
              open++;
          } else if (s.charAt(i) == ')') {
              close++;
          }

          if (open == close) {
              maxLen = Math.max(maxLen, 2 * open);
          } else if (open > close) {
              open = close = 0;
          }
      }

      return maxLen;
  }*/

}
